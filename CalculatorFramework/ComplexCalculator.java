package zbailey_hw4;

public class ComplexCalculator extends Calculator {
	/**
	 * Creating the calculator constructor. 
	 * @param expr the string from the console input.
	 */
	public ComplexCalculator(String expr) {
		super(expr);
	}
	/**
	 * Gets a new tokenizer object from string input.
	 * @return new tokenizer object.
	 */
	public ComplexTokenizer getTokenizer(String expr) {
		return new ComplexTokenizer(expr);
	}

}