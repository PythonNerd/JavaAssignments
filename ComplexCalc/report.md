#Complex Calculator
##DESIGN:  
I began to draw out the new additions to the program, basing it off the model solution. I made pseudocode for the complex class, its constructor, and the method to turn it into a string. I then wrote down how the program types would be changed to the Complex object, and how the tokenizer would handle complex numbers. While going down the list I paused at #4 and watched a Khan Academy video on forms of complex numbers so I could better understand what I was about to be doing. I created the constructor and remade all the arithmetic operations, then while working on the calculator class I realized I needed another constructor in case there was not an imaginary number, so I created a new method constructor for just one parameter, the real value. 

##DIFFICULTY: 
Working on the tokenizer was difficult as I had to determine where I had to diverge from a double/string to a complex. I decided to just keep track if a number was imaginary or real and then return a new complex built from the double, either (tokenVal, iValue) or just (tokenVal). I also had to research the multiplication method for complex numbers. 

The hardest challenge was checking the calculator and making sure the complex number computed properly.

##TESTING:
I have a variable in calculator called verbose set to false. Change to true to run test. I created a test suite to assert the that add, sub, mul, and div all work and get the expected output. I created the following test cases:  c1 as (0, 1), c2 as (2, 2), c3 as (-4,0), and c4 as (1.25, 5). I called assertEquals on c1.add(c2) which should return true and it did. I tested c3 and c4 to see if negatives or doubles impacted the method but they both returned the correct result. 

I then ran the tests again using c1, c2, and c3 for subtraction. 

`assertEquals("-2.0 - -1.0i", c1.comSub(c2).toString());` returned true. 

I used c1, c2, and c3 for multiplication. 

`assertEquals("-2.0 + 2.0i", c1.comMul(c2).toString());`

`assertEquals("-0.0 - -4.0i", c3.comMul(c1).toString());`

`“-2.0 + 2.0i”` is what c1 and c2 multiplied together should be. The method returned true. 

Finally, I used the same variables as above for division and received the correct output. 

The test suite checks the expected values, entered as strings, with the results of the methods converted to strings. If they are equal, then it printed that they pass.  

##HELP: 
I consulted several students asking about which methods they switched to complex and if they left anything as double. (Joshua Echols, Chandler Jones) I contacted a friend of mine who is a programmer and asked him for advice when creating a testing suite and he went out of his way to explain a really in depth approach to constructing testing suites and how I could verify that a data structure is well formed. This explains why my testing class is noticeably more detailed and verbose than previous assignments. 



##SOURCES: 
https://www.khanacademy.org/math/precalculus/imaginary-and-complex-numbers/polar-form-of-complex-numbers/e/rectangular-and-polar-forms-of-complex-numbers
http://tutorial.math.lamar.edu/Extras/ComplexPrimer/Forms.aspx
https://coderanch.com/t/538466/java/Complex-Numbers-Java
http://stackoverflow.com/questions/10098958/java-complex-numbers-3-classes
http://tutorial.math.lamar.edu/Extras/ComplexPrimer/Arithmetic.aspx
