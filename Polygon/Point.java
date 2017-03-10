package edu.uab.cs203;

/** A simple point class allows you to return the x and y values of any
 * object constructed using points
 */
public class Point {
	Point(double cx, double cy) {
		x = cx; y = cy;
	}
	/**
	* Returns the x-coordinate.
	* @return x coordinate
	*/
	double getX() { return x; }
	/**
	* Returns the y-coordinate.
	* @return y coordinate
	*/
	double getY() { return y; }
	private double x;
	private double y;
}