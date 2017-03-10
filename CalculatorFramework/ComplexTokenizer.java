package zbailey_hw4;

public class ComplexTokenizer extends Tokenizer
{
	/**
	 * Runs the superclass for the constructor and the getScanner() method. 
	 * @param s
	 */
	 ComplexTokenizer(String s)
	 {
	    super(s);
	    getScanner();
	 }
	 /**
	  * Returns true if there is a number after the current one.
	  */
	  public boolean hasNextNumber()
	  {
		  for (int i = 0; i < 10; ++i)
		  {
			  if (scanner.hasNext(""+i))
			  {
				  return true;
			  }
		  }
		  return false;
	  }
	  /**
	   * Checks for a period, logically making the number a double.
	   * @return boolean true or false
	   */
	  private boolean hasNextPeriod()
	  {
	    return scanner.hasNext("\\.");
	  }
	  /**
	   * Returns the complex number objects after completing a number.
	   */
	  public Number nextNumber()
	  {
	    String val = scanner.next();
	    while (hasNextNumber())
	    {
	    	val = val + scanner.next();
	    }

	    if (hasNextPeriod())
	    {
	      val = val + scanner.next();

	      while (hasNextNumber())
	      {
	        val = val + scanner.next();
	      }
	    }

	    if (scanner.hasNext("e") || scanner.hasNext("E"))
	    {
	      val = val + scanner.next();

	      if (scanner.hasNext("\\+") || scanner.hasNext("-"))
	        val = val + scanner.next();

	      while (hasNextNumber())
	      {
	        val = val + scanner.next();
	      }
	    }

	    double  magnitude = Double.parseDouble(val);
	    Number res = null;

	    //Creates either an imaginary or real number. 
	    if (!scanner.hasNext("i"))
	    {
	      res = new Complex(magnitude, 0);
	    }
	    else
	    {
	      scanner.next(); // consume "i"
	      res = new Complex(0, magnitude);
	    }

	    assert res != null;
	    return res;
	  }

}
