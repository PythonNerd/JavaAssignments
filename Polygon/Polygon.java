package edu.uab.cs203;


/** A simple polygon class*/
public class Polygon {
	/**
	* Constructs a new polygon object defined as a sequence of points.
	* Can call methods within Polygon to output information such as
	* number of vertices, perimeter, average edge length, or angle at
	* a vertex. 
	* @param points an arbitrary number of points
	**/
	public Polygon(Point... points) {
		//Checks to see if there are less than 3 points.
		//If not, it closes the program as there is no useful information
		//that can be discovered.
		if(points.length < 3){ 
			System.out.println("A polygon cannot have less than 3 points.");
			System.exit(numberOfSides);
		}
		//Value to hold the number of points entered.
		numberOfSides = points.length;
	}
	/**
	* Computes the perimeter by iterating over the array of points and squaring the
	* 2nd power of the x and y coordinates of each point at [i] and [i+1]. 
	* The values are then added together before being added to a total value.
	* @return the perimeter value
	**/
	public double getPerimeter(Point...points){
		//Resets duplicates to 0 each time so that multiple calls don't stack.
		dup = 0;
		for(int i = 0; i < numberOfSides; i++){
			//No need to see if the last one is a duplicate, since i+1 would catch it.
			if(i < numberOfSides-1){ 
				if(points[i].getX() == points[i+1].getX() && points[i].getY() == points[i+1].getY()){
					System.out.println("Duplicate points, skipping.");
					//Skipping the extra.
					i++; 
					//Adding to duplicate total.
					dup++;
				}
			}
			//Since the formula uses i+1, it cannot be called on the last index.
			//I used an else to hardcode the final i with index 0, since that is logically where it would connect.
			//Formula: ((px-qx)^2 + (py-qy)^2)^(1/2)
			if(i < numberOfSides-1){
				side = Math.sqrt(Math.pow((points[i].getX())-points[i+1].getX(),2)+ Math.pow(points[i].getY()-points[i+1].getY(),2));
			}else{
				side = Math.sqrt(Math.pow(points[i].getX()-points[0].getX(), 2) + Math.pow(points[i].getY()-points[0].getY(),2));
			}
			total += side;
		}
		return total;
	}
	/**
	* This simple method just returns the variable for numberOfSides.
	* @return the average edge length
	**/
	public int getNumVertices() {
		//Returning the number of sides. Minimalism. 
		return numberOfSides;
	}
	/**
	* Computes the average lengths of the edges by dividing the 
	* return value of getPerimeter by the number of sides in
	* the polygon. This will result in the average length of each
	* side.
	* @return the average edge length
	**/
	public double getAvgEdgeLength(Point...points) {
		//As stated above, I have to subtract the count of duplicates
		//from the side length to make sure the average edge length is accurate.
		newSideLength = numberOfSides - dup;
		return (total)/(newSideLength);
	}
	/**
	* Computes the angle at vertex num.
	* @param num the vertex number (the first vertex has index 0)
	* @return angle at vertex num
	**/
	public double getAngleAtVertex(int num, Point...points) {
		//This method took several days to get right. 
		//Main reference: http://stackoverflow.com/questions/28260962/calculating-angles-between-line-segments-python-with-math-atan2
		//I threw in Math.abs to every point to make it work with negatives.
		//Duplicates is set to false originally.
		dupl = false;
		//No need to see if the last one is a duplicate, since i+1 would catch it.
		if(num < numberOfSides-1){ 
			if(points[num].getX() == points[num+1].getX() && points[num].getY() == points[num+1].getY()){
				System.out.println("Duplicate points, skipping.");		
				dupl = true;
				}
			}
		//Making sure we don't go out of bounds.
		if (num > numberOfSides || num < 0){
			System.out.println("Index out of range.");
		}else if(num <  getNumVertices() -1 && num > 0){
			//If there is a duplicate, this if/else block will catch it and fix the skipping issue.
			//The solution is to use num+2 instead of num+1, as the later would cancel it out.
			if(dupl){
				
				line1a = ((Math.abs(points[num].getX()) - Math.abs((points[num+2].getX()))));
				line1b = ((Math.abs(points[num].getY()) - Math.abs((points[num+2].getY()))));
				line2a = ((Math.abs(points[num].getX()) - Math.abs((points[num-1].getX()))));
				line2b = ((Math.abs(points[num].getY()) - Math.abs((points[num-1].getY()))));
			}else{
				//If there are no duplicates, we just use the formula with num+1.
				line1a = ((Math.abs(points[num].getX())) - Math.abs((points[num+1].getX())));
				line1b = ((Math.abs(points[num].getY())) - Math.abs((points[num+1].getY())));
				line2a = ((Math.abs(points[num].getX())) - Math.abs((points[num-1].getX())));
				line2b = ((Math.abs(points[num].getY())) - Math.abs((points[num-1].getY())));
			}
			//Plug in the lines to dot product.
		    dotProduct = (line1a*line2a+line1b*line2b);
		    //Then caculate the magnitude of each line.
		    magnitude1 = Math.sqrt((line1a*line1a+line1b*line1b));
		    magnitude2 = Math.sqrt((line2a*line2a+line2b*line2b));
		    //Divide dotProduct by both magnitudes to find the cosine.
		    cosine = dotProduct/magnitude1/magnitude2;
		    //Now we can use that to find the angle using Math.acos.
		    angle = Math.acos(dotProduct/magnitude1/magnitude2);;
		    //Finally we convert it to degrees and mod it by 360 to find the angle.
		    angleDegrees = Math.toDegrees(angle)%360;
		    if (angleDegrees-180>=0){
		    	return 360 - angleDegrees;
		    }else{
		    	return angleDegrees;
		    }
		//Special case for 0, the first index. It has to use the last index, so we
		//call getNumVertices()-1.
		}else if(num == 0){
			line1a = (Math.abs(points[num].getX()) - Math.abs(points[num+1].getX()));
			line1b = (Math.abs(points[num].getY()) - Math.abs(points[num+1].getY()));
			line2a = (Math.abs(points[num].getX()) - Math.abs(points[getNumVertices()-1].getX()));
			line2b = (Math.abs(points[num].getY()) - Math.abs(points[getNumVertices()-1].getY()));
		    dotProduct = (line1a*line2a+line1b*line2b);
		    magnitude1 = Math.sqrt((line1a*line1a+line1b*line1b));
		    magnitude2 = Math.sqrt((line2a*line2a+line2b*line2b));
		    cosine = dotProduct/magnitude1/magnitude2;
		    angle = Math.acos(dotProduct/magnitude1/magnitude2);
		    angleDegrees = Math.toDegrees(angle)%360;
		    if (angleDegrees-180>=0){
		    	return 360 - angleDegrees;
		    }else{
		    	return angleDegrees;
		    }
		//If it isn't 0 through length-1, it has to be the very last index.
		//So we plug in 0 and n-1 to get the first index, which naturally connects to the last point.
		}else{
			line1a = (Math.abs(points[num].getX()) - Math.abs(points[0].getX()));
			line1b = (Math.abs(points[num].getY()) - Math.abs(points[0].getY()));
			line2a = (Math.abs(points[num].getX()) - Math.abs(points[num-1].getX()));
			line2b = (Math.abs(points[num].getY()) - Math.abs(points[num-1].getY()));
		    dotProduct = (line1a*line2a+line1b*line2b);
		    magnitude1 = Math.sqrt((line1a*line1a+line1b*line1b));
		    magnitude2 = Math.sqrt((line2a*line2a+line2b*line2b));
		    cosine = dotProduct/magnitude1/magnitude2;
		    angle = Math.acos(dotProduct/magnitude1/magnitude2);
		    angleDegrees = Math.toDegrees(angle)%360;
		    if (angleDegrees-180>=0){
		    	return 360 - angleDegrees;
		    }else{
		    	return angleDegrees;
		    }
		}
		return angle;
	}
	/**
	* Tests if the polygon is convex (all angles are less than 180 degrees).
	* The code iterates through Points and checks each angle. If any angle 
	* is greater than or equal to 180, then it will return false. Otherwise
	* the code will return true.
	* @return true, iff convex; false, otherwise
	**/
	public boolean isConvex(Point...points) {
		//A simple for loop iterates over the length of points and makes sure the angle is not greater
		//than 180. If it is then we return false right away. 
		for(int i = 0; i < getNumVertices(); i++){
			if(getAngleAtVertex(i, points)>=180){
				return false;
			};
		}
		return true;
	}
	/**
	* Tests if the polygon is simple (no edges intersect).
	* @return true, iff simple; false, otherwise
	**/
	public boolean isSimple() {
	/**
	 * line intersection can be computed using cross product. not finished.
	 */
		//Didn't finish this method. 
		return simple;
	}	
	/**Variables used. I created doubles for all calculations such as: side,
	 * total, edge1, edge2, and angle. I used a boolean to return the value of 
	 * isSimple and an int for numberOfSides.
	 */

	int numberOfSides; 							      // Counts number of sides.
	int dup; 								         // Counts duplicate points.
	double newSideLength; 					        // NumberOfSides - duplicates
	double total; 								   // Used for perimeter.
	double side; 								  // Value for the angle method.
	double angle; 								 // Value used in angle method.
	double dotProduct; 							// Dot product.
	double magnitude1; 						   // Magnitude of the first line.
	double magnitude2;			              // Magnitude of the second line.
	double line1a; 	 						 // Normalized line1
	double line1b; 							// Normalized line1
	double line2a; 						   // Normalized line 2
	double line2b; 						  // Normalized line 2
	double cosine; 						 // Holder for the cosine value
	double angleDegrees; 				// Holder for angle degrees 
	boolean simple; 				   // Boolean to check if a polygon isSimple.
	boolean dupl; 					  //Boolean to switch between duplicate if/else branches
}
