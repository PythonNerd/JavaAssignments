package sol.src;

/**
 * Tester class for the complex constructor. 
 * Prints oututput regarding the arithmatic methods. 
 * @author ZBailey
 *
 */
public class complexTester
{
    public static void main(String[] args)
    {
    	test();
    }

    /**
     * Prints out the various tests.
     */
    public static void test()
    {
    	System.out.println("Testing addition.");
    	testAdd();
    	System.out.println();
    	System.out.println("Testing subtraction.");
    	testSub();
    	System.out.println();
    	System.out.println("Testing multiplication.");
    	testMul();
    	System.out.println();
    	System.out.println("Testing division.");
    	testDiv();
    }

    /**
     * If an object is asserted to be true, it passes.
     * @param obj
     */
    public static void assertTrue(complex obj)
    {
        if(obj != null)
        {
            System.out.println("Passed assert true of "+ obj.toString());
        }
        else
        {
            System.out.println("Failed assert true of "+ obj.toString());
        }
    }

    /**
     * If an object is asserted to be false it will pass the test.
     * @param obj
     */
    public static void assertFalse(complex obj)
    {
        if(obj != null)
        {
            System.out.println("Passed assert false of "+ obj.toString());
        }
        else
        {
            System.out.println("Failed assert false of "+ obj.toString());
        }
    }

    /**
     * Prints if expected results/string is equal to string2.
     * @param string The first item to compare. string2 the second item. 
     */
    public static void assertEquals(String string, String string2)
    {
        if(string.equals(string2))
        {
            System.out.println("Passed assert equals of "+ string.toString() +" and "+ string2.toString());
        }
        else
        {
            System.out.println("Failed assert equals of "+ string.toString()+" and "+ string2.toString());
        }
    }
    //Prints out the values for test cases of addition.
    public static void testAdd() {
        complex c1 = new complex(0, 1);
        complex c2 = new complex(2, 2);
        complex c3 = new complex(-4, 0);
        complex c4 = new complex(1.25, 5);
        assertEquals("2.0 + 3.0i", c1.comAdd(c2).toString());
        assertEquals(c1.comAdd(c2).toString(), c2.comAdd(c1).toString());
        assertEquals("-4.0 + 1.0i", c3.comAdd(c1).toString());
        assertEquals("1.25 + 6.0i", c4.comAdd(c1).toString());
    }
    //Tests cases for subtraction.
    public static void testSub() {
        complex c1 = new complex(0, 1);
        complex c2 = new complex(2, 2);
        complex c3 = new complex(-4, 0);

        assertEquals("-2.0 - -1.0i", c1.comSub(c2).toString());
        assertEquals("2.0 + 1.0i", c2.comSub(c1).toString());
        assertEquals("-4.0 - -1.0i", c3.comSub(c1).toString());
    }
    //Tests cases for multiplication.
    public static void testMul() {
        complex c1 = new complex(0, 1);
        complex c2 = new complex(2, 2);
        complex c3 = new complex(-4, 0);

        assertEquals("-2.0 + 2.0i", c1.comMul(c2).toString());
        assertEquals("-0.0 - -4.0i", c3.comMul(c1).toString());
    }
    //Tests cases for division.
    public static void testDiv() {
        complex c1 = new complex(0, 1);
        complex c2 = new complex(2, 2);
        complex c3 = new complex(-4, 0);
        
        assertEquals("1.0 - -1.0i", c1.comDiv(c2).toString());
        assertEquals("1.0", c3.comDiv(c1).toString());
    }

}
