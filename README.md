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
                     A - Finish documenting provided source code in Scanner.java
                     B - Extend the scanner to support source-code comments, design
                            our own form of comments
                     C - Change the Environment object to translate each command
                            line argument as exactly one assignment statement
                     D - Add a prefix unary mins operator
                     E- Change the translator to support double values instead of 
                            integer values 

              What I did 
                     A - Finished document all functions for all files included
                     B - Extended the the scanner to accept comment lines that 
                         start with "#", comment lines are completly skipped
                     C - Created a HashMap to store var and val values 
                     D - Added a unary variable to my grammer that allows '-'
                     E - Change all functions from "int" to "double",  added 
                            "." do the digits set

FILES
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
       

Results
       Refer to testResults.txt

       I did run in to an issue when testing the expected out put for doubles. For 
       example prog = 1.0 + 1.0, exp = 2.0, my out.i file would match the expected
       value of 2.0, but my test would still fail. It was calculating the correct 
       values but failing my test, as a workaround I casted my values to an int and
       so that it would pass the regression tester. Because of this I am not able 
       to compute percentages as a double. Such as 2.0 / 4.0 = .5. 
       


Teting 
       Testing was done using the regression tester. Test files
       are located in the 'test' directory.

       We were provided with a few test file examples that show us how 
       the test suit works. However these test were not complex enough
       and did not account for many scenarios. 

       I created my own test to better evaluate my code implementation. 
       My custom test are also stored in the 'test directory.
              Test include : 
                     test-plus - test adding (int and double)
                     test-minus - test subtraction (int and double)
                     test-mul - test multiply (int and double)
                     test-divide - test divide (int and double)
                     teest-two - test muntiple prog files (int and double)
                     test-unearthly - test weird inputs, Ex "==", "++"
            


CREDITS
       Author:       Raymundo Escobedo 
       Date:         Spring 2023
       Class:        CS 354
                                                                                           
