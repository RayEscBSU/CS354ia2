import java.util.ArrayList;
import java.util.List;

// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.
public class Parser {
	//TODO: Implement boolexpr, relop, prog, block
	private Scanner scanner;

	/**
	 Matches the given string with the current token returned by the scanner.
	 @param s the string to match
	 @throws SyntaxException if the current token doesn't match the given string
	 */
	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	/**
	 Returns the current token returned by the scanner.
	 @return the current token
	 @throws SyntaxException if the scanner has no more tokens
	 */
	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	/**
	 Returns the position of the current token in the input program.
	 @return the position of the current token
	 */
	private int pos() {
		return scanner.pos();
	}

	/**
 	 Parses and returns a NodeMulop object from the current token.
	 @return the NodeMulop object parsed from the current token or null if the current token is not a valid mulop
	 @throws SyntaxException if the current token doesn't match any valid mulop
	 */
	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	/**
	 Parses and returns a NodeAddop object from the current token.
	 @return the NodeAddop object parsed from the current token or null if the current token is not a valid addop
	 @throws SyntaxException if the current token doesn't match any valid addop
	 */
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}

	/**
	 Parses and returns a NodeFact object from the current token.
	 @return the NodeFact object parsed from the current token
	 @throws SyntaxException if the current token doesn't match any valid fact
	 */
	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("-"))) {
			match("-");
			NodeFact f = parseFact();
			return new NodeFactNeg(f);
		}
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	/**
	 Parses and returns a NodeTerm object.
	 @return the NodeTerm object parsed from the current token
	 @throws SyntaxException if the current token doesn't match any valid term
	 */
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	private NodeAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}

	//TODO: implement new parsable statements
	private NodeStmt parseStmt() throws SyntaxException {
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			match("=");
			NodeExpr expr = parseExpr();
			match(";");
			NodeAssn assn = new NodeAssn(id.lex(), expr);
			return new NodeStmt(assn, null);
		}

		if (curr().equals(new Token("rd"))) {
			match("rd");
			Token id = curr();
			match("id");
			match(";");
			return new NodeStmt(null, null, null, null,
					null, new NodeRd(id.lex()), null,null);
		}

		if (curr().equals(new Token("wr"))) {
			match("wr");
			NodeExpr expr = parseExpr();
			match(";");
			return new NodeStmt(null, null, null, null,
					null, null, new NodeWr(expr), null);
		}

		if (curr().equals(new Token("if"))) {
			match("if");
			NodeBoolExpr boolexpr = parseBoolExpr();
			match("then");
			NodeStmt ifThenStmt = parseStmt();
			match(";");
			if (curr().lex().equals("else")) {
				match("else");
				NodeStmt elseStmt = parseStmt();
				match(";");
				return new NodeStmtIfThenElse(boolexpr, ifThenStmt, elseStmt);
			} else {
				return new NodeStmtIfThen(boolexpr, ifThenStmt);
			}
		}

		if (curr().equals(new Token("while"))) {
			match("while");
			NodeBoolExpr whileBoolexpr = parseBoolExpr();
			match("do");
			NodeStmt whileStmt = parseStmt();
			return new NodeStmt(null, whileBoolexpr, null, null,
					new NodeWhile(whileBoolexpr, whileStmt), null, null,null);
		}

		if (curr().equals(new Token("begin"))) {
			match("begin");
			NodeBlock block = parseBlock();
			match("end");
			match(";");
			return new NodeStmt(null, null, null, null,
					null, null, null, block);
		}
		return null;
	}



	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		NodeStmt stmt = parseStmt();
		match("EOF");
		return stmt;
	}

	//TODO: implement Relop
	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			if (curr().equals(new Token("="))) {
				match("=");
				return new NodeRelop(pos(), "<=");
			} else if (curr().equals(new Token(">"))) {
				match(">");
				return new NodeRelop(pos(), "<>");
			} else {
				return new NodeRelop(pos(), "<");
			}
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			if (curr().equals(new Token("="))) {
				match("=");
				return new NodeRelop(pos(), ">=");
			} else {
				return new NodeRelop(pos(), ">");
			}
		}
		if (curr().equals(new Token("="))) {
			match("=");
			return new NodeRelop(pos(), "==");
		}
		throw new SyntaxException(pos(), new Token("ANY") ,curr());
	}

	//TODO: implement parseBoolExp
	private NodeBoolExpr parseBoolExpr() throws SyntaxException {
		NodeExpr left = parseExpr();
		NodeRelop relop = parseRelop();
		NodeExpr right = parseExpr();
		return new NodeBoolExpr(left, relop, right);
	}

	private NodeBlock parseBlock() throws SyntaxException {
		List<NodeStmt> stmtList = new ArrayList<>();
		while (!curr().equals(new Token("end"))) {
			NodeStmt stmt = parseStmt();
			stmtList.add(stmt);
			if (!curr().equals(new Token(";"))) {
				throw new SyntaxException(pos(), new Token(";"), curr());
			}
			match(";");
		}
		return new NodeBlock(stmtList);
	}


}
