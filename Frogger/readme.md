# Frogger

## Problem Specification 

Develop a simplified version of Frogger, that consists of a single car lane, a single car, and a frog. The objective when designing this program is to use interface polymorphism, listeners, and drawing images in Java.

## Program Design 


When designing the program, I knew I would have to create two objects, Frog and Car, which would be repainted during keypresses and time intervals. I would also have to add collisions and have meaningful output to ensure collisions occurred at the correct coordinates. I designed my program in a simple way with minimal classes, although it could have been broken up into a few more such as a class for giving objects collision bounds. 


a)	I used the 3 icon classes from lab to construct ImageIcons from Buffered Images. I modified the newIcon method to accomplish this. I also removed the curr tracking features, as they were not needed with just a static image.

b)	I moved to the AnimationTester class and created the frog and car objects then set their heights and widths. I then set up the frame and variables for the frog and car objects, which would be used to dynamically alter the size of the frame.

c)	After setting up the icons and their bounds, I created a listener to move the frog whenever the arrow keys are pressed.

d)	I then created a while loop that moved the car right until it hit the wall and then it would go left.

e)	With the controls working and shapes created, I worked on adding collision detection. This would check the bounds of the objects and return the frog to its original position if they touch.

## Testing Plan 

For testing I ran through the program multiple times. The only way to quantify my tests was to output the coordinates of the car and frog upon collision to verify that they are correct. objWidth is the x coordinate + frogWidth() / 2, as the frog starts at the center of the screen and is a half block off being even with the car. This cleans up any x axis collisions.

## Test Cases

| Test Case Number	| Coordinates	| Expected output |	Output |

| ------------- |:-------------:| -----:|

| 1 |	210, 170 |	Collision!	X: 210, objX: 105 Y: 170, objY: 170| X: 210, objWidth: 210 Y: 170, objHeight: 170|

| 2	| 420, 170 | Collision!	X: 420, objX: 525 Y: 170, objY: 170 | X: 420, objWidth: 630 Y: 170, objHeight: 170|

| 3	| 525, 0	| No output. |	No output.  | There is not a collision. |

## Conclusions and difficulty

Through this assignment, I learned more about drawing in Java and organizing programs. While the program was simple, I could have made it more polymorphic or added the extended version. During my free time, I’ll likely create a version with a working background and multiple lanes to upload to GitHub. 

The only difficult part of the assignment was collision, due to me forgetting the frog was half a grid off. Once I recognized this problem it was an easy fix.

## References

There was some basic research done on collision detection.
http://gpsnippets.blogspot.com.es/2008/10/bounding-box-collision-detection.html
The classes were built from the lab code.
