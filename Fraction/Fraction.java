package edu.uab.cis.cs203.zbailey;
/** SimpleFraction is a class modeling fractions where numerator
*  and denominator are represented as int.
*/
public class Fraction 
	{
	/**
	* Constructs a new Fraction object.
	* @param init initial value
	*/
	public Fraction(int num, int denom)
	{	
		assert denom != 0: "Cannot have a fraction with a denominator of 0";
		numerator = num;
		denominator = denom;
	}
	/**
	* Cross between two fractions.
	* @param a Fraction object b Fraction object
	* @return Cross multiplication of a and b.
	*/
	private int cross(Fraction a, Fraction b)
	{
		return (a.numerator * b.denominator);
	}
	/**
	* Greatest common denominator.
	* @param num Top of fraction denom Bottom of Fraction
	* @return Recursive call until num or denom is 0, then num + denom.
	*/
	private int gcd(int num, int denom)
	{
		//If either num or denom is 0, return them added together.
		if(num == 0 || denom == 0)
		{
			return num+denom;
		}
		//Otherwise return the method with a mod of num and denom. 
		return gcd(denom,num%denom);
	}
	/**
	* Reduces a fraction. Finds greatest common denominator 
	* and returns a new function object divided by the gcd.
	* @param num Top of fraction denom Bottom of Fraction
	* @return a new object representing the reduced fraction. 
	*/
    private Fraction reduce(int num, int denom)
    {
    	int gcdNum = gcd(num, denom);
    	return new Fraction(num /gcdNum, denom/gcdNum);
    }
	/**
	* Computes "this+that" and returns the result in a new object.
	* @param that the left-hand side operand.
	* @return a new object representing this+that
	*/
	public Fraction add(Fraction that)
	{ 
		// Calls the cross multiply method.
		int num1 = cross(this, that) + cross(that, this); 
		// Num2 makes the denominators equal.
		int num2 = this.denominator * that.denominator;
		// Reduce the new numerator and denominator.
		return reduce(num1,num2);
	}
	/**
	* Computes "this-that" and returns the result in a new object.
	* @param that the left-hand side operand.
	* @return a new object representing this-that
	*/
	public Fraction sub(Fraction that) 
	{
		int num1 = cross(this, that) - cross(that, this); 
		int num2 = this.denominator * that.denominator;
		return reduce(num1,num2);
	}
	/**
	*  Computes "this*that" and returns the result in a new object.
	*  @param that the left-hand side operand.
	*  @return a new object representing this-that
	*/
	public Fraction mul(Fraction that) 
	{ 
		int num1 = this.numerator * that.numerator; 
		int num2 = this.denominator * that.denominator;
		return reduce(num1,num2);
	}
	/**
	* Computes "this/that" and returns the result in a new object.
	*  @param that the left-hand side operand.
	*  @return a new object representing this/that
	*/
	public Fraction div(Fraction that) 
	{ 
		int num1 = this.numerator * that.denominator; 
		int num2 = this.denominator * that.numerator;
		return reduce(num1,num2);
	}
	/**
	* Computes the quotient of the fraction.
	* @return a new object representing the quotient of this/that
	*/
	public int getQuotient() 
	{ 
		return this.numerator/this.denominator;
	}
	/**
	* Computes the remainder of the fraction.
	* @return a new object representing the remainder of this/that
	*/
	public int getRemainder() 
	{   
		return this.numerator % this.denominator;
	}
	/**
	* Computes the floating point value of the fraction.
	* @result a floating point number that approximates this fraction
	*/
	public double doubleValue() 
	{   
		temp = this.numerator;
		return temp / this.denominator;
	}
	/**
	* Returns the textual representation of the fraction in the form
	* of ”num / denom”. If denom is zero, only ”num” will be
	* returned.
	* @result a string representing this fraction
	*/
	public String toString()
	{
		return this.numerator + "/" + this.denominator;
	}
	/* VARIABLES */
	private int numerator;
	private int denominator;
	private double temp; 
}