package edu.uab.cs203;

/**
 * A simple test class.
 * Used to create Polygon objects.
 *
 */
public class test {
	
	public static void main(String[] args){
		test();
	}
	
	public static void test() {
		
		Polygon square1 = new Polygon(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0));
		System.out.println("Square 1");
		System.out.println("---------");
		System.out.println("Vertices: " + square1.getNumVertices());
		System.out.println("Perimeter: " + square1.getPerimeter(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Average edge length: " + square1.getAvgEdgeLength(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Is Polygon convex? " + square1.isConvex(new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Angle at vertex 0: " + square1.getAngleAtVertex(0, new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Angle at vertex 1: " + square1.getAngleAtVertex(1, new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Angle at vertex 2: " + square1.getAngleAtVertex(2, new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Angle at vertex 3: " + square1.getAngleAtVertex(3, new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("Angle at vertex 4: " + square1.getAngleAtVertex(4, new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,1), new Point(1,0)));
		System.out.println("---------");
		
		Polygon square2 = new Polygon(new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1));
		System.out.println("Square 2");
		System.out.println("---------");
		System.out.println("Vertices: " + square2.getNumVertices());
		System.out.println("Perimeter: " + square2.getPerimeter(new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,1)));
		System.out.println("Average edge length: " + square2.getAvgEdgeLength(new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		System.out.println("Is Polygon convex? " + square2.isConvex(new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		System.out.println("Angle at vertex 0: " + square2.getAngleAtVertex(0, new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		System.out.println("Angle at vertex 1: " + square2.getAngleAtVertex(1, new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		System.out.println("Angle at vertex 2: " + square2.getAngleAtVertex(2,new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		System.out.println("Angle at vertex 3: " + square2.getAngleAtVertex(3, new Point(-1,0), new Point(0,0), new Point(0,1), new Point(-1,-1)));
		
		
		Polygon triangle1 = new Polygon(new Point(0,0), new Point(0,1), new Point(2,2));
		System.out.println("---------");
		System.out.println("Triangle 1");
		System.out.println("---------");
		System.out.println("Vertices: " + triangle1.getNumVertices());
		System.out.println("Perimeter: " + triangle1.getPerimeter(new Point(0,0), new Point(0,1), new Point(2,2)));
		System.out.println("Average edge length: " + triangle1.getAvgEdgeLength(new Point(0,0), new Point(0,1), new Point(2,2)));
		System.out.println("Angle  at vertex 1: " + triangle1.getAngleAtVertex(0, new Point(0,0), new Point(0,1), new Point(2,2)));
		System.out.println("Angle  at vertex 2: " + triangle1.getAngleAtVertex(1, new Point(0,0), new Point(0,1), new Point(2,2)));
		System.out.println("Angle  at vertex 3: " + triangle1.getAngleAtVertex(2, new Point(0,0), new Point(0,1), new Point(2,2)));
		System.out.println("Is Polygon convex? " + triangle1.isConvex(new Point(0,0), new Point(0,1), new Point(2,2)));
		
		System.out.println("---------");
		System.out.println("Line (Last Object)");
		System.out.println("---------");
		Polygon square3 = new Polygon(new Point(0,0), new Point(0,1));
	}

}
