package sol.src;

/*
 *
 * public interface if the Tokenizer class.
 *
  class CalcTokenizer
  {
  // Constructs a new tokenizer with the input that needs to be processed
  CalcTokenizer(String s)

  // reads the next token from the input and matches
  // the kind of tokens.
  public void consume()

  //
  public String currentTokenKind()

  // Returns the complex representation of the token
  public complex getValue()
}
*/


/**
 * Calculator
 *
 * Floating point calculator. The calculator is invoked through { @link #compute }.
 * Note in order to make the calculator easily extensible towards other types,
 * we use complex objects instead of float values for the computation.
 */
public class Calculator
{
  public Calculator(String expr)
  {
    tokenizer = new CalcTokenizer(expr);
  }

  // calculation

  /**
   * Handles optional parenthesis, otherwise parses the next number.
   *
   * @return the next floating point value
   */
  private complex parVal()
  {
    complex res = null;
    String kind = tokenizer.currTokenKind();

    if ("(".equals(kind))
    {
      tokenizer.consume();
      res = addop();

      if (")".equals(tokenizer.currTokenKind()))
      {
        // consume closing parenthesis
        tokenizer.consume();
      }
      else
      {
        assert false : "wrong input";
      }
    }
    else
    {
      assert "complex".equals(kind) : "wrong input";

      res = tokenizer.getValue();
      tokenizer.consume();
    }

    assert res != null;
    return res;
  }

  /**
   * Tests whether a token is either mul or div
   *
   * @param k a token
   */
  static boolean isMulDivKind(String k)
  {
    return "*".equals(k) || "/".equals(k);
  }

  /**
   * Handles multiplication/division, otherwise returns next number
   *
   * @return computed value
   */
  private complex mulop()
  {
    complex res = parVal();
    String op  = tokenizer.currTokenKind();

    if (isMulDivKind(op))
    {
      tokenizer.consume();
      complex rhs = mulop();

      if ("*".equals(op))
      {
        res = res.comMul(rhs);
      }
      else
      {
        assert "/".equals(op);
        res = res.comDiv(rhs);
      }
    }

    assert res != null;
    return res;
  }


  /**
   * Tests whether a token is either plus or minus
   *
   * @param k a token
   */
  static boolean isPlusMinusKind(String k)
  {
    return "+".equals(k) || "-".equals(k);
  }


  /**
   * Handles addition/subtraction, otherwise returns next number
   *
   * @return computed value
   */
  private complex addop()
  {
    complex res = mulop();
    String op = tokenizer.currTokenKind();

    if (isPlusMinusKind(op))
    {
      tokenizer.consume();
      complex rhs = addop();

      if ("+".equals(op))
      {
    	  res = res.comAdd(rhs);
      }
      else
      {
        assert "-".equals(op);
        res = res.comSub(rhs);
      }
    }

    assert res != null;
    return res;
  }

  /**
   * Invokes start production
   *
   * @return computed value
   */
  private complex calc()
  {
    // load first token
    tokenizer.consume();

    // parse addop
    return addop();
  }

  /**
   * Computes the value for a given expression
   *
   * @param expr input expression
   * @return computed value
   * @throws RuntimeException if the input is not valid
   */
  public String compute()
  {
    assert tokenizer != null;
    return "" + calc();
  }

  /** We use a simple tokenizer to chop up the input stream. */
  private CalcTokenizer tokenizer;
}
