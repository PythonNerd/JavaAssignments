package edu.uab.cis.cs203.zbailey;

public class fracTest {

	public static void main(String[] args) {
		// TEST 1
		System.out.println("Test 1");
		Fraction a = new Fraction(2, 4);
		Fraction b = new Fraction(1, 4);
		Fraction add1 = a.add(b);
		Fraction sub1 = a.sub(b);
		Fraction mul1 = a.mul(b);
		Fraction div1 = a.div(b);
		int remain1 = a.getRemainder();
		int quot1 = a.getQuotient();
		double doub1 = a.doubleValue();
		System.out.println("Addition of " + a.toString() + " and " + b.toString() + " = " + add1);
		System.out.println("Subtraction of " + a.toString() + " and " + b.toString() + " = " + sub1);
		System.out.println("Multiplication of " + a.toString() + " and " + b.toString() + " = " + mul1);
		System.out.println("Division of " + a.toString() + " and " + b.toString() + " = " + div1);
		System.out.println("Remainder of " + a.toString() + " = " + remain1);
		System.out.println("Quotient of " + a.toString() + " = " + quot1);
		System.out.println("Double value of " + a.toString() + " = " + doub1);
		System.out.println();
		// TEST 2
		System.out.println("Test 2");
		Fraction d = new Fraction(5, 2);
		Fraction e = new Fraction(2, 2);
		Fraction add2 = d.add(e);
		Fraction sub2 = d.sub(e);
		Fraction mul2 = d.mul(e);
		Fraction div2 = d.div(e);
		int remain2 = d.getRemainder();
		int quot2 = d.getQuotient();
		double doub2 = d.doubleValue();
		System.out.println("Addition of " + d.toString() + " and " + e.toString() + " = " + add2);
		System.out.println("Subtraction of " + d.toString() + " and " + e.toString() + " = " + sub2);
		System.out.println("Multiplication of " + d.toString() + " and " + e.toString() + " = " + mul2);
		System.out.println("Division of " + d.toString() + " and " + e.toString() + " = " + div2);
		System.out.println("Remainder of " + d.toString() + " = " + remain2);
		System.out.println("Quotient of " + d.toString() + " = " + quot2);
		System.out.println("Double value of " + d.toString() + " = " + doub2);
		System.out.println();
		// TEST 3
		System.out.println("Test 3");
		Fraction f = new Fraction(-5, 2);
		Fraction g = new Fraction(2, 2);
		Fraction add3 = f.add(g);
		Fraction sub3 = f.sub(g);
		Fraction mul3 = f.mul(g);
		Fraction div3 = f.div(g);
		int remain3 = f.getRemainder();
		int quot3 = f.getQuotient();
		double doub3 = f.doubleValue();
		System.out.println("Addition of " + f.toString() + " and " + g.toString() + " = " + add3);
		System.out.println("Subtraction of " + f.toString() + " and " + g.toString() + " = " + sub3);
		System.out.println("Multiplication of " + f.toString() + " and " + g.toString() + " = " + mul3);
		System.out.println("Division of " + f.toString() + " and " + g.toString() + " = " + div3);
		System.out.println("Remainder of " + f.toString() + " = " + remain3);
		System.out.println("Quotient of " + f.toString() + " = " + quot3);
		System.out.println("Double value of " + f.toString() + " = " + doub3);
		System.out.println();
		// TEST 4
		System.out.println("Test 4");
		Fraction h = new Fraction(0, 2);
		Fraction i = new Fraction(2, 2);
		Fraction add4 = h.add(i);
		Fraction sub4 = h.sub(i);
		Fraction mul4 = h.mul(i);
		Fraction div4 = h.div(i);
		int remain4 = h.getRemainder();
		int quot4 = h.getQuotient();
		double doub4 = h.doubleValue();
		System.out.println("Addition of " + h.toString() + " and " + i.toString() + " = " + add4);
		System.out.println("Subtraction of " + h.toString() + " and " + i.toString() + " = " + sub4);
		System.out.println("Multiplication of " + h.toString() + " and " + i.toString() + " = " + mul4);
		System.out.println("Division of " + h.toString() + " and " + i.toString() + " = " + div4);
		System.out.println("Remainder of " + h.toString() + " = " + remain4);
		System.out.println("Quotient of " + h.toString() + " = " + quot4);
		System.out.println("Double value of " + h.toString() + " = " + doub4);
		System.out.println();
		//TEST4
		System.out.println("Test 5");
		Fraction j = new Fraction(1,0);
		Fraction k = new Fraction(1,1);
		Fraction add5 = j.add(k);
	}

}
