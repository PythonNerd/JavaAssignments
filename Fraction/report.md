# Design

The algorithms for this exercise involved a cross method, greatest common denominator, and reducing fractions. I planned to create some helper methods to improve the code design. After the Tuesday lecture I planned in my head how I would reduce functions, which would involve finding the greatest common denominator between the numerator and denominator and divided both of them by that. During my research into fractions, I found several online articles that helped me understand that public function itself was an object and the variables inside it were values constructed inside the object. 

For design of the code, I used the Allman style to make sure each of the brackets lined up properly. It took several tries to get the test code working, because I had just grasped the concept of objects and how all the methods were called on an object then the “that” was the parameter. To work on this I had a mix of whitebox and blackbox testing. After looking at my code I decided to check my assertion that denominators cannot be 0, and then tested negative fractions to make sure that they worked too. 
  
I received no help from students this time around, and mainly relied on internet research to find the formulas and implement them in the way I saw fit. There were multiple ways to calculate greatest common denominator, so I chose a recursive formula that offered the least amount of lines. Another alternative would have been to use a loop to calculate the GCD until the mod reached 0, meaning that they divided evenly into each other. 

# Sources:

http://www.dreamincode.net/forums/topic/87241-fraction-class-that-does-the-4-main-calculation-functions/
http://www.dreamincode.net/forums/topic/203711-beginner-java-question/
https://people.eecs.berkeley.edu/~jrs/61bf98/labs/lab2/Fraction.java
http://aleph0.clarku.edu/~djoyce/cs101/Resources/Fraction.java
http://www.cs.ucf.edu/~dmarino/ucf/java/fraction.java
