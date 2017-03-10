package zbailey_hw4;

import java.util.Scanner;

public class Calc
{
  /**
   * Generates a new calculator object (factory function)
   */
  public static Calculator calculator(String s)
  {
    return new ComplexCalculator(s);
  }

  public static Calculator doubleCalculator(String s)
  {
    return new DoubleCalculator(s);
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
    Scanner sc = new Scanner(System.in);

    System.out.println("Complex calculator.");
    while (sc.hasNextLine())
    {
      String res = calculator(sc.nextLine()).compute();

      System.out.println(res);
    }
    sc.close();
  }
}

