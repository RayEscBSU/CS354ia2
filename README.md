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
       tst - test director 
              test-minus    - stores test files that test minus opperations
              test-plus     - stores test files that test plus opperations
              test-tw0      - stores test files that test two mathematical 
                              opperations. May re-use variables calculated 
                              in the first test
              run - used to run test 
       IA1
              Code.java - deq fundtion implementations
              Environment.java - deq function declerations
              EvalException.java - error function declerations
              Grammar - specifies grammer
              Main.java (provided) - 
              Node.java (provided) -
              NodeAddop.java (provided) - 
              NodeAssn.java (provided) - 
              NodeExpr.java method
              NodeFact.java -
              NodeFactExpr.java (provided) - 
              NodeMulop.java (provided) - 
              NodeStmt.java - 
              NodeTerm.jav - 
              NodeWr.java
              Parser.ljava - 
              README - read me
              Scannar. java - scanner
              SyntaxException.java - 
              Token.java - 
       

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
                                                                                           
