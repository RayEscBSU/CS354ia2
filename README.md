# README
                                                                                            
# Run 
       How to run: 
              From directory where source files are located    

              To compile and run the translator: 
                     javac *.java
                     java Main "x = 1+2;" "y = x+3;" 

              To run the interpreter and the compiler set a Bash environment variable
              to the desired file name. Ex. generate a C file named gen.c, produce an
              executable file, and execute it.

                     Code=gen java Main "x = 1+2;"
                     gcc -o gen gen.c
                     ./gen



# DESCRIPTION
       Our assignment is to extend a translator provided by the professor for a small
       programing language. The translator is both an interpreter and a compiler. The
       interpreter and compiler are implemented using Java, however the compilers
       target language is C. 

              TODO:
                     A - Extned the scnaner to recoginize new keywords and operators
                     B - Extend the parser to recognize new grammer rules
                     C - Extend the interpreter to evaluate new grammer rules
              What I did: 
                    Extended the scanner, parser and evaluator/generator to recognize new keywords, operators and grammer rules. 
                         I added the following: 
                                - relational operators - <, >, <=, >=, ==, !=
                                - if statements - if, then, else
                                - block statements - begin, end
                                - read statements - rd 
                                - write statements - wr
                                - while statements - while, do
                      

# FILES
       tst - test directory 
              test-minus    - stores test files that test minus operations
              test-plus     - stores test files that test plus operations
              test-tw0      - stores test files that test two mathematical 
                              operations. May re-use variables calculated 
                              in the first test
              run - used to run test 
       IA1 - contains source files
              Code.java (provided) - Used for C code
              Environment.java (provided) - defines environment
              EvalException.java (provided) - defines EvalException
              Grammar (provided) - specifies grammer
              Main.java (provided) - Main class for program
              Node.java (provided) - Models parse tree nodes
              NodeAddop.java (provided) - Defiens NodeAddop
              NodeAssn.java (provided) - Defines NodeAssn
              NodeExpr.java (provided) - defines NodeExpr
              NodeFactExpr.java (provided) - defines FactExpr
              NodeFactID.java (provided) - defines FactID
              NodeFactNum.java (provided) - defines factor opp
              NodeMulop.java (provided) - defines multiplication opp
              NodeStmt.java (provided) - defines NodeStmt
              NodeTerm.jav (provided) - defines NodeTerm 
              NodeWr.java (provided) - evaluate expr
              Parser.ljava (provided) - parser based on grammer
              README - read me
              Scannar. java (provided) - scanner for program
              SyntaxException.java (provided) - handles syntax exceptions 
              Token.java (provided) - models a token
              NodeBlock.java - defines NodeBlock
              NodeIf.java - defines NodeIf
              NodeRelop.java - defines NodeRelop
              NodeWhile.java - defines NodeWhile
              NodeRd.java - defines NodeRd
              NodeWr.java - defines NodeWr
              NodeStmtIfThen.java - defines NodeStmtIfThen
              NodeStmtIfThenElse.java - defines NodeStmtIfThenElse             
              NodeStmtWhileDo.java - defines NodeStmtWhile
              NodeStmtAssn.java - defines NodeStmtAssn
             


# Results
       Refer to included file testResults
       
       I was able to get most of the added features implemented but they are not working exactly as expected. I have some bugs that I was not able to fix. Howevr my test for the ia1 are all passing.


# Testing 
       Testing was done using the regression tester. Test files
       are located in the 'test' directory.

       We were provided with a few test file examples that show us how 
       the test suit works. However these test were not complex enough
       and did not account for many scenarios. 

       I created my own test to better evaluate my code implementation. 
       My custom test are also stored in the 'test directory.
              Test include : 
                     test-comments - test skip comment lines
                     test-plus - test adding (int and double)
                     test-minus - test subtraction (int and double)
                     test-mul - test multiply (int and double)
                     test-divide - test divide (int and double)
                     teest-two - test muntiple prog files (int and double)
                     test-relop - test relational operators (int and double)
                     test-if - test if statements (int and double)
                     test-block - test block statements (int and double)
                     test-rd - test read statements (int and double)
                     test-wr - test write statements (int and double)
                     test-while - test while statements (int and double)
            


# CREDITS
       Author:       Raymundo Escobedo 
       Date:         Spring 2023
       Class:        CS 354
                                                                                           
