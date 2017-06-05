# Polygon

## Initial Design

Before I started on the project I took a step back to look at all the methods that had to be done and I thought of which variables  and data types I would need to use. Using my CS103 program as a guide line, I worked on the perimeter method despite knowing my old code had a bug. It turned out that I had misspelled a power sign and that messed up the formula to get the edge between two points. After fixing this small bug I began printing out the correct perimeter for a Polygon of 1 length on each side, which was 4.0. 
	
Once I could see results from my first method, I began to visualize how the Points method was called and recalled how we called object values. Number of sides and average edge lengths were almost the exact same as Python. I later added in a ‘dub’ variable to keep track of duplicate points and I subtracted that from the length of the Points, giving an accurate average length of all edges. 
  
## Testing 

I began thinking “What if we had an object with 2 or less points?” This clearly isn’t a Polygon so anything returned from it would be useless to the user. I added a System.exit() to close the program after displaying a message. This test is performed last so that the other tests can run first. I also thought about “What if there are duplicates?” and created an if statement to check up to length-1 (The last point won’t have anything after it to be a duplicate, so we don’t need to check it.) and then compare the x and y values of I and I + 1. If they are the same I call i++ and dup++ to skip the next point and keep track of the duplicates. At the beginning of Perimeter, I set dup to 0 so that each time I run Perimeter, the values don’t add up and skew results. For testing getAngleAtVertex, I added an if statement to check if the num called was less than 0 and if it was greater than the length of Points. I then called the method on 0, 1, 2, and 3.

## Other tweaks

Originally, I had the perimeter code inside the constructor just to visualize how to run the program but I later moved that to the perimeter method and added (Point…points) to the methods so I could call points from within any of them. I had to use some code from the perimeter function to find the edges which were then plugged into the formula to find the vertex (provided last semester by Dr. Johnstone, online sources attached). 


## Sources: 

I looked through several web forums and message boards to find similar problems. 
http://stackoverflow.com/questions/9970281/java-calculating-the-angle-between-two-points-in-degrees
https://en.wikipedia.org/wiki/Gift_wrapping_algorithm
http://stackoverflow.com/questions/471962/how-do-determine-if-a-polygon-is-complex-convex-nonconvex
