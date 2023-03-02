# README
                                                                                            
Run 
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



DESCRIPTION
       Our assignment is to extend a translator provided by the professor for a small
       programing language. The translator is both an interpreter and a compiler. The
       interpreter and compiler are implemented using Java, however the compilers
       target language is C. 

              TODO:
                     - Finish documenting provided source code in Scanner.java
                     - Extend the scanner to support source-code comments, design
                       our own form of comments
                     - Change the Environment object to translate each command 
                      line argument as exactly one assignment statement
                     - Add a prefix unary mins operator
                     - Change the translator to support double values instead of 
                      integer values 




FILES
       tst - test directory 
              test-minus    - stores test files that test minus opperations
              test-plus     - stores test files that test plus opperations
              test-tw0      - stores test files that test two mathematical 
                              opperations. May re-use variables calculated 
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
       

Results 
       


Teting 
       Testing was done using the regression tester. Test files
       are located in the the 'test' directory. 

       We were provided with a few test file examples that show us how 
       the test suit works. However these test were not complex enough
       and did not account for many scenarios. 

       I created my own test to better evaluate my code implementation. 
       My custom test are also stored in the 'test directory. 
            


CREDITS
       Author:       Raymundo Escobedo 
       Date:         Spring 2023
       Class:        CS 354
                                                                                           
