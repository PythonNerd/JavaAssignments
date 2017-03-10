package zbailey_hw4;

public class DoubleTokenizer extends Tokenizer {
	/**
	 * Runs the superclass for the constructor and the getScanner() method. 
	 * @param s
	 */
	 DoubleTokenizer(String s)
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

	      while (hasNextPeriod())
	      {
	        val = val + scanner.next();
	      }
	    }

	    if (scanner.hasNext("e") || scanner.hasNext("E"))
	    {
	      val = val + scanner.next();

	      if (scanner.hasNext("\\+") || scanner.hasNext("-"))
	        val = val + scanner.next();

	      while (hasNextPeriod())
	      {
	        val = val + scanner.next();
	      }
	    } 
	   // return val;
	    return null;
	  }
}
