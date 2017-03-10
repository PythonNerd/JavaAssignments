package zbailey_hw4;
/**
 * Subclass of Number, creates complex numbers.
 *
 */
public class Complex extends Number{
	private double re;
	private double im;

	public Complex(double real, double imag) {
		re = real;
		im = imag;
	}

	public Complex add(Number that) {
		Complex other = (Complex) that;
		return new Complex(this.re + other.re, this.im + other.im);
	}

	public Complex sub(Number that) {
		Complex other = (Complex) that;
		return new Complex(this.re - other.re, this.im - other.im);
	}

	public Complex mul(Number that) {
		Complex other = (Complex) that;
		double real = this.re * other.re - this.im * other.im;
		double imag = this.re * other.im + this.im * other.re;

		return new Complex(real, imag);
	}

	private Complex conjugate() {
		return new Complex(re, -im);
	}

	public Complex div(Number that) {
		Complex other = (Complex) that;
		Complex conj = other.conjugate();
		Complex numerator = this.mul(conj);
		Complex divisor = other.mul(conj);

		assert Math.abs(divisor.getImaginary()) < 0.0001;
		return new Complex(numerator.getReal() / divisor.getReal(), numerator.getImaginary() / divisor.getReal());
	}

	public double getImaginary() {
		return im;
	}

	/**
	 * returns the real part.
	 * 
	 * @return a double reflecting the real component.
	 */
	public double getReal() {
		return re;
	}

	public String toString() {
		String imstr = (im >= 0) ? " + " + im : " - " + (-im);
		return "(" + re + imstr + "i)";
	}


}
