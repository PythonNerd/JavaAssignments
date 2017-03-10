package zbailey_hw4;

import static org.junit.Assert.*;

import java.awt.print.Book;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComplexTester
{
	
	@Test
	public void testAdd() {
        Complex c1 = new Complex(0, 1);
        Complex c2 = new Complex(2, 2);
        Complex c3 = new Complex(-4, 0);
        Complex c4 = new Complex(1.25, 5);
        assertEquals("(2.0 + 3.0i)", c1.add(c2).toString());
        assertEquals(c1.add(c2).toString(), c2.add(c1).toString());
        assertEquals("(-4.0 + 1.0i)", c3.add(c1).toString());
        assertEquals("(1.25 + 6.0i)", c4.add(c1).toString());
    }
	
    //Tests cases for subtraction.
	@Test
    public void testSub() {
        Complex c1 = new Complex(0, 1);
        Complex c2 = new Complex(2, 2);
        Complex c3 = new Complex(-4, 0);

        assertEquals("(-2.0 - 1.0i)", c1.sub(c2).toString());
        assertEquals("(2.0 + 1.0i)", c2.sub(c1).toString());
        assertEquals("(-4.0 - 1.0i)", c3.sub(c1).toString());
    }
    //Tests cases for multiplication.
	@Test
    public void testMul() {
        Complex c1 = new Complex(0, 1);
        Complex c2 = new Complex(2, 2);
        Complex c3 = new Complex(-4, 0);

        assertEquals("(-2.0 + 2.0i)", c1.mul(c2).toString());
        assertEquals("(-0.0 - 4.0i)", c3.mul(c1).toString());
    }
    //Tests cases for division.
	@Test
    public void testDiv() {
        Complex c1 = new Complex(0, 1);
        Complex c2 = new Complex(2, 2);
        Complex c3 = new Complex(-4, 0);
        
        assertEquals("(0.25 + 0.25i)", c1.div(c2).toString());
        assertEquals("(0.0 + 4.0i)", c3.div(c1).toString());
    }

	@Test 
	public void testCalculation(){
		String res = Calc.calculator(("(4 - 5i) * ( 4 + 5i)")).compute();
		assertEquals("(41.0 + 0.0i)",res.toString());
	}

}