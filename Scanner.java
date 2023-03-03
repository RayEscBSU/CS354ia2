// This class is a scanner for the program
// and programming language being interpreted.

import java.util.*;

public class Scanner {

	private String program;		// source program being interpreted
	private int pos;			// index of next char in program
	private Token token;		// last/current scanned token

	// sets of various characters and lexemes
	private Set<String> whitespace=new HashSet<String>();
	private Set<String> digits=new HashSet<String>();
	private Set<String> letters=new HashSet<String>();
	private Set<String> legits=new HashSet<String>();
	private Set<String> keywords=new HashSet<String>();
	private Set<String> operators=new HashSet<String>();
	private Set<String> comments=new HashSet<String>();

	// initializers for previous sets

	// This method takes three parameters: s, lo, hi
	// It traverses the set passed from lo(exclusive)
	// to hi(inclusive) 
	// Resulting set contianing only the characters in
	// that range
	// Arguments:
	//    s  = Set of strings passed in 
	//	  lo = Start charactars to beign adding to set s
	// 	  hi = Ending charcater to stop adding to set s  
	// Members:
	//     program = the scanner's input
	//     pos = index of current input character
	private void fill(Set<String> s, char lo, char hi) {
		for (char c=lo; c<=hi; c++)
			s.add(c+"");
	}
	
	// This method defines initWhitespace, it
	// takes a set of stirings "s" then individually 
	// adds a space, newline, and tab charceters to it. 
	// Resulting set contianing only those three 
	// white space characters 
	// Can be used to check if a given sting contains 
	// any of these whitespcae characters
	// Arguments:
	//     s  = Set of strings passed in 
	private void initWhitespace(Set<String> s) {
		s.add(" ");
		s.add("\n");
		s.add("\t");
	}

	// This method defines initDigits, it takes a set
	// of stirings "s" then calls fill to add digits 
	// from 0 - 9 to string s
	// Resulting set contianing only those specified 
	// digit characters 
	// Can be used to check if a given sting contains 
	// any of these digit characters
	// Arguments:
	//     s  = Set of strings passed in 
	private void initDigits(Set<String> s) {
		fill(s,'0','9');
	}

	// This method defines initLetters, it takes a set
	// of stirings "s" then calls fill to add letters 
	// from A - Z, and a - z to string s
	// Resulting set contianing only those specified 
	// letter characters 
	// Can be used to check if a given sting contains 
	// any of these letter characters
	// Arguments:
	//     s  = Set of strings passed in 
	private void initLetters(Set<String> s) {
		fill(s,'A','Z');
		fill(s,'a','z');
	}

	// This method defines initLetters, it takes a set
	// of stirings "s" then adds all the letters and 
	// digets from the "letters" and "digits" HashSets
	// Resulting set contianing only those specified 
	// letters and digit characters 
	// Can be used to check if a given sting contains 
	// any of these letters and digits characters
	// Arguments:
	//     s  = Set of strings passed in 
	// Members:
	//     letters = HashSet created by init letters	
	//     digits = HashSet created by init digits
	private void initLegits(Set<String> s) {
		s.addAll(letters);
		s.addAll(digits);
	}

	// This method defines initOperators, it takes a set
	// of stirings "s" then adds all of the mathematical
	// opperators 
	// Resulting set contianing only those specified 
	// mathematical operator characters 
	// Can be used to check if a given sting contains 
	// any of these operators characters
	// Arguments:
	//     s  = Set of strings passed in 
	private void initOperators(Set<String> s) {
		s.add("=");
		s.add("+");
		s.add("-");
		s.add("*");
		s.add("/");
		s.add("(");
		s.add(")");
		s.add(";");
	}

	// This method defines initComments, it takes a set
	// of stirings "s" then adds the comment characters
	// Resulting set contianing only those comment
	// characters 
	// Can be used to check if a given sting contains 
	// any of these comments characters
	// Arguments:
	//     s  = Set of strings passed in 
	private void initComments(Set<String> s) {
		s.add("#");
	}

	// This method defines initKeywords, it takes a set
	// of stirings "s" 
	// Arguments:
	//     s  = Set of strings passed in 
	private void initKeywords(Set<String> s) {
	}

	// constructor:
	//     - squirrel-away source program
	//     - initialize sets
	public Scanner(String program) {
		this.program=program;
		pos=0;
		token=null;
		initWhitespace(whitespace);
		initDigits(digits);
		initLetters(letters);
		initLegits(legits);
		initKeywords(keywords);
		initOperators(operators);
		initComments(comments); 
	}

	// handy string-processing methods

	// This method returns true if the 
	// we are at the end of the file 
	public boolean done() {
		return pos>=program.length();
	}

	// This method is used to check if we have 
	// not reached the end and there are more
	// characters left to read
	// The "pos" variable is moved to the next char
	// that matches the set "s"
	// Loop continues as long as the "done" method
	// returns false and the Set "s" contains the
	// character at the current index in "program."
	private void many(Set<String> s) {
		while (!done()&&s.contains(program.charAt(pos)+""))
			pos++;
	}

	// This method advances the scanner,
	// until the current input character
	// is just after a sequence of one or more
	// of a particular character.
	// Arguments:
	//     c = the character to search for
	// Members:
	//     program = the scanner's input
	//     pos = index of current input character
	private void past(char c) {
		while (!done()&&c!=program.charAt(pos))
			pos++;
		if (!done()&&c==program.charAt(pos))
			pos++;
	}

	// scan various kinds of lexeme

	// This method is used create a token substring 
	// from the "old" to "pos". Calls many to advance
	// the pointer to the end of "digits" tokens until
	// the next character is no longer in the set
	// Members: 
	//   old - Intiger variables use to store 
	//		  "pos" value
	//   digits - HashSet containing only digits
	//   pos - index of the next char in program 
	//   token - new token created from substring
	private void nextNumber() {
		int old=pos;
		many(digits);
		token=new Token("num",program.substring(old,pos));
	}

	// This method is used create a token substring 
	// from the "old" to "pos". Calls "many" to advance
	// the pointer to the end of the "letters" and 
	// "legits" tokens  until the next character 
	//  is no longer in the set
	//
	// It then checks if the substirng is a keyword, 
	// if it is then it is used as a token type, if
	// not it is marked as an "id"
	//
	// Members: 
	//   old - Intiger variables use to store 
	//		  "pos" value
	//   letters - HashSet containing only letters
	// 	 legits - HashSet containing only legits
	//   pos - index of the next char in program 
	// 	 lexeme - stores substring from "old" - "pos"
	//   token - new token created contains token type 
	private void nextKwId() {
		int old=pos;
		many(letters);
		many(legits);
		String lexeme=program.substring(old,pos);
		token=new Token((keywords.contains(lexeme) ? lexeme : "id"),lexeme);
	}

	// This method is used create a token substring 
	// from the "old" to "pos". It checks if the 
	// lexeme contains an operator, if it does it
	// creates a new token object conatianing the 
	// operator lexmeme
	//
	// If it reaches an invalid charactor or the end 
	// of the input, it moves the position back then
	// creates a new lexeme from the substring, finally
	// it creates a new token from the lexeme
	//
	// Members: 
	//   old - Intiger variables use to store 
	//		  "pos" value
	//   letters - HashSet containing only letters
	// 	 legits - HashSet containing only legits
	//   pos - index of the next char in program 
	// 	 lexeme - stores substring from "old" - "pos"
	//   token - new token created contains token type 
	private void nextOp() {
		int old=pos;
		pos=old+2;
		if (!done()) {
			String lexeme=program.substring(old,pos);
			if (operators.contains(lexeme)) {
				token=new Token(lexeme); // two-char operator
				return;
			}
		}
		pos=old+1;
		String lexeme=program.substring(old,pos);
		token=new Token(lexeme); // one-char operator
	}

	// This method determines the kind of the next token (e.g., "id"),
	// and calls a method to scan that token's lexeme (e.g., "foo").
	public boolean next() {
		many(whitespace);
		if (done()) {
			token=new Token("EOF");
			return false;
		}
		String c=program.charAt(pos)+"";
		if(checkComment()){
			past('\n');
			return next();
		}
		else if (digits.contains(c))
			nextNumber();
		else if (letters.contains(c))
			nextKwId();
		else if (operators.contains(c))
			nextOp();
		else {
			System.err.println("illegal character at position "+pos);
			pos++;
			return next();
		}
		return true;
	}

	// This method determines if the next character is a comment "#"
	// in the current line,
	// Returns true if a comment is found
	public boolean checkComment() {
		int old=pos;
			if(program.charAt(old) == '#'){
				return true;
			}
		return false;
	}

	// This method scans the next lexeme,
	// if the current token is the expected token.
	public void match(Token t) throws SyntaxException {
		if (!t.equals(curr()))
			throw new SyntaxException(pos,t,curr());
		next();
	}

	// This method checks if "token" is null
	// Throws exception if null else returns "token"
	// Members:
	// 	token - last/current scanned token
	public Token curr() throws SyntaxException {
		if (token==null)
			throw new SyntaxException(pos,new Token("ANY"),new Token("EMPTY"));
		return token;
	}

	// This method returns the position
	// Members: 
	// 	pos - index of the next char in program 
	public int pos() {
		return pos;
	}

	// for unit testing
	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(args[0]);
			while (scanner.next())
				System.out.println(scanner.curr());
		} catch (SyntaxException e) {
			System.err.println(e);
		}
	}

}
