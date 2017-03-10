package zbailey_hw4;
/**
 * Abstract class for creating methods for an unknown object Number.
 */
public abstract class Number {
	//Abstract classes for arithmatic and printing out string.
	public abstract Number add(Number that);
	
	public abstract Number sub(Number that);
	
	public abstract Number mul(Number that);
	
	public abstract Number div(Number that);
	
	public abstract String toString();
	
}

