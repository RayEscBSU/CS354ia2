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
       Our assingment was to esign a multi thread safe wrapper for our doulbe ended que implementation. A MT-safe wrapper use
       pthread mutex locks to lock a section of running code. This allows mulitple threads or jobs to run simultianiously but 
       allows only one thread to access critical data at a time. The multi threading capability allows the program to run more 
       effiecently and optimal. 
              Below are the functions implemented: 

               main
               - call - creates multiple pthreads 
               - wiat - joins created pthreads 
               - produce - produces moles  
               - consume - consumes moles 

               mtq
               - struct Rep - holds mtq variables 
               - mtq_init   - initalized a mtq
               - mtq_tail_put - MT-safe deq_tail_put, adds a node to the end of the list
               - mtq_head_get - MT-safe deq_head_get, returns the data from the last node
               - mtq_destroy  - frees mtq struct data


FILES
       GNUmakefile (provided) - make file
       CS452H2
              deq.c - deq fundtion implementations
              deq.h - deq function declerations
              error.h - error function declerations
              GNUmakefile (provided) - make file
              lawn.c (provided) - lawn fundtion implementations 
              lawn.h (provided) - lawn function declerations
              lawnimp.cc (provided) - lawnimp fundtion implementations
              linkage.h (provided) - linkage function declerations
              main.c - main method
              man_mtq.md - Readme 
              mole.c (provided) - mole fundtion implementations
              mole.h (provided) - mole function declerations
              mtq.c - mtq fundtion implementations
              mtq.h - mtq function declerations
       
       Once compiled  
              wam - executable 
              *.o - object files
              *.d - dependancy files


Results 
      I am testing begining with only 2 threads. The program runs ok but when I increase the number of threads I get a 
      segmentation fault. I will continue to work on this know bug. 



Teting 
       Testing was done using the regression tester. Test files
       are located in the the 'test' directory. 

       We were provided with a few test file examples that to see how 
       the test suit works. However these were not complex enought and 
       did not account for many scenarios. 

       I created my own test to really evaluate my code implementation. 
       My custom test are also stored in the 'test directory. 
            


CREDITS
       Author:       Raymundo Escobedo 
       Date:         Spring 2023
       Class:        CS 354
                                                                                           
