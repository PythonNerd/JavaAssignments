package zbailey_hw4;

import java.util.Scanner;

public abstract class Tokenizer {
	public String tokenKnd;
	public Scanner scanner;
	public Number tokenVal;

	/**
	 * Tokenizer constructor. 
	 * @param s input from console.
	 */
	Tokenizer(String s) {
		assert s != null : "Invalid input string";
		scanner = new Scanner(s);
		scanner.useDelimiter("");
	}

	/**
	 * Checks if there is a valid token in the input.
	 * @param token input from console. 
	 * @return boolean value for valid token. 
	 */
	public static boolean isValidToken(String token) {
		String[] validTokens = new String[] { "(", ")", "*", "-", "/", "+" };

		for (String aToken : validTokens) {
			if (aToken.equals(token))
				return true;
		}

		return false;
	}

	/**
	 * Consumes the next token and gets
	 * the type of it and the value. 
	 */
	public void consume() {
		if (!scanner.hasNext()) {
			tokenKnd = "invalidToken";
			return;
		}

		if (scanner.hasNext("-")) {
			tokenKnd = scanner.next();
			return;
		}

		if (hasNextNumber()) {
			tokenKnd = "Number";
			tokenVal = nextNumber();
			return;
		}

		tokenKnd = scanner.next();
		if (" ".equals(tokenKnd)) {
			consume();
			return;
		}

		assert isValidToken(tokenKnd);
	}

	// Returns the type of a token.
	public String currTokenKnd() {
		return tokenKnd;
	}
	// Returns value of tokenVal.
	public Number getValue(){
		return tokenVal;
	}

	// Returns scanner object.
	public Scanner getScanner() {
		return scanner;
	}
	
	// Abstract method for hasNextNumber.
	public abstract boolean hasNextNumber();

	// Abstract method for the next number.
	public abstract Number nextNumber();
}
