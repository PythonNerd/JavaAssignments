#DESIGN:  
For creating the abstract framework, I started off by designing the Number class. I created the abstract arithmetic and toString methods, then began to work on the tokenizer and calculator. After the realization under difficulty, I sorted most of the code in the framework and began to design the sub classes. 

I worked through the rest of the code understanding to implement the subclasses while calling the superclass for all the methods that were already defined. 

#DIFFICULTY: 
For some reason, the tokenVal kept reading as Number despite attempts to override or cast the value as another type. After 3 days of constant tinkering with the code, I looked over the HW pdf again and noticed the word “only” bolded for extra attention. It then struck me that we could put most of the code in the framework and only call 1-2 methods per subclass, and leave typecasting to the Complex class rather than calling Complex methods elsewhere.

I also experienced an issue working with a fraction tokenizer. 

#TESTING: 
I wrote a JUNIT test suite that checked the arithmetic functions of the complex class.
 
JUNIT ran all of the tests without error for the addition. The sub, mul, and div methods all used the same c1, c2, c3, and c4, while passing all of their tests. 
 
I also ran a test on the calculator to make sure it printed out the correct result. 

#HELP: 
For this assignment I used the canvas discussion and looked at previous assignments. 

 
#SOURCES:
No outside sources used.
