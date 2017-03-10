package sol.src;

public class complex
{
	//Add polar method

	
	/**
	 * Complex object constructor for real numbers. 
	 * Real is set to real. Imaginary is set to 0.
	 * @param real If no i is detected in a token.
	 */
	public complex(double real){
		this.real = real;
		this.imaginary = 0;
	}
	
	/**
	 * Complex object constructor for real and imaginary numbers.
	 * @param real Sets value of object real.
	 * @param imaginary Sets value of object imaginary. 
	 */
	public complex(double real, double imaginary)
	{
		this.real = real;
		this.imaginary = imaginary;
	}
	/**
	 * Prints out the polar form of any object.
	 */
	public void form(){
		double a = this.getReal();
		double b = this.getImaginary();
		double r = Math.sqrt(a * a + b * b);
		double theta = 0;
		if(a > 0.0){
			theta = Math.atan(b/a);
		}
		else if(a < 0.0){
			theta = Math.atan(b/a) + Math.PI;
		}
		//Formats it to 2 decimal places.
		System.out.printf("%.2f("+"cos(%.2f)+isin(%.2f))", r, theta, theta);
	}
        
	/**
	 * Returns a string of the complex object. 
	 * If imaginary is 0, returns just the real.
	 * Otherwise returns string of real + imaginary + i.
	 */
	public String toString()
	{
		if(this.imaginary == 0.0){
			return "" + real;
		}
		if(this.imaginary < 0.0){
			return real + " - " + imaginary + "i";
		}
		return real + " + " + imaginary + "i";
	}
	
	/**
	 * Returns the value of real.
	 * @return 0 for no real or value of real.
	 */
	public double getReal()
	{
		return this.real;
	}

	/**
	 * Gets the value of the imaginary number.
	 * @return 0 if no imaginary or value of imaginary. 
	 */
	public double getImaginary()
	{
		return this.imaginary;
	}

	/**
	 * Foils 2 complex numbers. First, outer, inner, last. 
	 * @param a complex object a
	 * @param b complex object b
	 * @return a new complex number conaining the foil'd result.
	 */
	public complex foil(complex a, complex b){
		return new complex (a.getReal() * b.getReal() - a.getImaginary() * b.getImaginary(), + a.getReal() * b.getImaginary() + a.getImaginary() * b.getImaginary());
	}
	/**
	 * 
	 * @param b
	 * @return
	 */
	public complex comAdd(complex b)
	{
		return new complex(this.getReal() + b.getReal(), this.getImaginary() + b.getImaginary());
    }

	/**
	 * Subtracts a complex object b from a complex object a.
	 * @param b a complex object
	 * @return returns the difference of a and b.
	 */
    public complex comSub(complex b)
    {
    	return new complex(this.getReal() - b.getReal(), this.getImaginary() - b.getImaginary());
    }
    /**
     * Multiplies an object with complex b.
     * @param b a complex object
     * @return the foil'd product of a and b.
     */
    public complex comMul(complex b)
    {
    	return foil(this, b);
    }
   /**
    * Returns reciprocol of a complex number.
    * @param b complex object to be flipped.
    * @return the reciprocol of an object.
    */
    public complex recip(complex b){
    	double scaling = this.getReal() * this.getReal() + this.getImaginary() * this.getImaginary();
    	complex scaledComplex = new complex (this.getReal()/scaling, -this.getImaginary()/scaling);
    	return scaledComplex;
    }
    /**
     * Multipies an object with complex b's reciprocol, getting the quotient.
     * @param b a complex object.
     * @return quotient of a and b.
     */
    public complex comDiv(complex b)
    {
    	return this.comMul(recip(b));
    }
    
    /** Value for the real number.*/
    private double real;
    /** Value for the imaginary number.*/
	private double imaginary;
}
