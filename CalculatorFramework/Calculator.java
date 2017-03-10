package zbailey_hw4;

public abstract class Calculator {
	public Tokenizer tokenizer;
	
    public Calculator(String expr)
    {
    	tokenizer = getTokenizer(expr);
    }
    
    public String compute() {
    	assert tokenizer != null;
        return "" + calc();
	}
    
    private Number calc() {
    	// load first token
        tokenizer.consume();

        // parse addop
        return addop();
	}

	private Number addop() {
		Number res = mulop();
	    String  op = tokenizer.currTokenKnd();

	    while (isPlusMinusKind(op))
	    {
	      tokenizer.consume();
	      Number rhs = mulop();

	      if ("+".equals(op))
	      {
	        res = res.add(rhs);
	      }
	      else
	      {
	        assert "-".equals(op);
	        res = res.sub(rhs);
	      }

	      op = tokenizer.currTokenKnd();
	    }
	    
	    assert res != null;
	    return res;
	}

	private boolean isPlusMinusKind(String k) {
		return "+".equals(k) || "-".equals(k);
	}

	private Number mulop() {
		Number res = parVal();
	    String  op  = tokenizer.currTokenKnd();

	    while (isMulDivKind(op))
	    {
	      tokenizer.consume();
	      Number rhs = parVal();

	      if ("*".equals(op))
	      {
	        res = res.mul(rhs);
	      }
	      else
	      {
	        assert "/".equals(op);
	        res = res.div(rhs);
	      }

	      op = tokenizer.currTokenKnd();
	    }

	    assert res != null;
	    return res;
	}

	private boolean isMulDivKind(String k) {
		return "*".equals(k) || "/".equals(k);
	}
	
	private Number parVal() {
		Number res = null;
	    String kind = tokenizer.currTokenKnd();

	    if ("(".equals(kind))
	    {
	      tokenizer.consume();
	      res = addop();

	      if (")".equals(tokenizer.currTokenKnd()))
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
	      assert "Number".equals(kind) : "wrong input";
	      //running into issues here
	      res = tokenizer.getValue();
	     // System.out.println(tokenizer.getValue());
	     // System.out.println(res);
	      tokenizer.consume();
	    }

	    assert res != null;
	    return res;
	}
    
    public abstract Tokenizer getTokenizer(String expr);
    
}