package sol.src;

import java.util.Scanner;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Simple Tokenizer that generates a token stream of an input stream.
 *
 *  The implementation attempts to match the token descriptions
 *  against the input. For any given input, only a single token description can be
 *  successfully matched; otherwise the Tokenizer reports the ambiguity through
 *  an exception.
 */
public class CalcTokenizer
{
  /** Constructs a new scanner with the input that needs to be processed
   *
   *  @param s input
   */
  CalcTokenizer(String s)
  {
    assert s != null : "Invalid input string";

    scanner = new Scanner(s);

    scanner.useDelimiter("");
    scanner.useLocale(Locale.US);
  }

  /**
   * Tests whether token is a valid token.
   *
   * @param token a String that contains a candidate token
   * @return true, iff token is valid; false otherwise
   */
  private static boolean isValidToken(String token)
  {
    String[] validTokens = new String[] { "(", ")", "*", "-", "/", "+", "i" };

    for (String aToken : validTokens)
    {
      if (aToken.equals(token)) return true;
    }

    return false;
  }

  /**
   * Returns if the next token is an i, 
   * designating it as a complex number.
   * @return boolean determining if imaginary.
   */
  private boolean hasImaginary(){
	  return scanner.hasNext("i");
  }
  /**
   * Returns boolean of whether or not there is 
   * another digit in a token.
   * @return boolean termining if next digit.
   */
  private boolean hasNextDigit()
  {
    for (int i = 0; i < 10; ++i)
      if (scanner.hasNext(""+i)) return true;

    return false;
  }
  
  /**
   * To check for doubles. 
   * @return boolean for if the number is a double.
   */
  private boolean hasNextDouble()
  {
    return hasNextDigit();
  }
  /**
   * Determines if there is a period in a token.
   * @return boolean for if there is a period. 
   */
  private boolean hasNextPeriod()
  {
    return scanner.hasNext("\\.");
  }

  /**
   * 
   * @return
   */
  private double nextDouble()
  {
    String val = scanner.next();

    while (hasNextDigit())
    {
      val = val + scanner.next();
    }

    if (hasNextPeriod())
    {
      val = val + scanner.next();

      while (hasNextDigit())
      {
        val = val + scanner.next();
      }
    }

    if (scanner.hasNext("e") || scanner.hasNext("E"))
    {
      val = val + scanner.next();

      if (scanner.hasNext("\\+") || scanner.hasNext("-"))
        val = val + scanner.next();

      while (hasNextDigit())
      {
        val = val + scanner.next();
      }
    }
    if (hasImaginary()){
    	iTrue = true;
    }
    return Double.parseDouble(val);
  }

  /**
   * Reads the next token from the scanner and 
   * matches it to the kind of tokens. 
   */
  public void consume()
  {
    if (!scanner.hasNext())
    {
      tokenKnd = "invalidToken";
      return;
    }

    if (scanner.hasNext("-"))
    {
      tokenKnd = scanner.next();
      return;
    }

    if (hasNextDouble())
    {
    	tokenKnd = "Double";
        tokenVal = nextDouble();
        System.out.println("" + tokenVal);
        return;
    }

    tokenKnd = scanner.next();
    if (" ".equals(tokenKnd))
    {
      consume();
      return;
    }

    System.out.println(tokenKnd);
    assert isValidToken(tokenKnd);
  }

  /**
   * Returns the current kind of a token.
   */
  public String currTokenKind()
  {
    return tokenKnd;
  }

  /**
   * Returns the Float representation of the token
   *
   * @return Float object for the current token
   */
  public complex getValue()
  {
	if(iTrue){
		return new complex(0, iValue);
	}
    return new complex(tokenVal);
  }

  /** Tokenizer that chops up the input string */
  private Scanner         scanner;

  /** Textual representation of last token matched */
  private double         tokenVal;

  /** Describes the kind of token that was matched */
  private String          tokenKnd;
  /** Value for the imaginary number. */
  private double          iValue;
  /** Keeps track of whether or not there is an i.*/
  private boolean         iTrue = false;
}
