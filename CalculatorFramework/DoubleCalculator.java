package zbailey_hw4;

public class DoubleCalculator extends Calculator {
	/**
	 * Creating the calculator constructor. 
	 * @param expr the string from the console input.
	 */
	public DoubleCalculator(String expr) {
		super(expr);
	}
	/**
	 * Gets a new tokenizer object from string input.
	 * @return new tokenizer object.
	 */
	public DoubleTokenizer getTokenizer(String expr) {
		return new DoubleTokenizer(expr);
	}
}
