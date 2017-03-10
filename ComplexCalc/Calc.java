package sol.src;

import java.util.Scanner;

public class Calc
{
  /**
   * Generates a new calculator object (factory function)
   */
  public static Calculator calculator(String s)
  {
    return new Calculator(s);
  }

  /**
   * main - test driver
   *
   * Reads an expression from the standard input stream
   * and prints the output to the console
   *
   * @param args unused
   */
  public static void main(String[] args)
  {
	  if(verbose){
		  complexTester.test();
	  }
	  
	  Scanner sc = new Scanner(System.in);

    //Keeps asking the user for input. 
    while (sc.hasNextLine())
    {
    	System.out.println("Enter an expression.");
    	String res = calculator(sc.nextLine()).compute();

    	System.out.println(res);
    }
  }
  /** Turns on testing */
  static boolean verbose = false;
}
