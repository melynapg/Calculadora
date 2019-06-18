package ar.edu.calculadora.myCalculadora;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    
    
	/*
	 * public static void main(String[] args) {
	 * 
	 * 
	 * CalculosControlador c = new CalculosControlador ();
	 * 
	 * String resultado = c.obtenerAB("(2.3,34.2)"); System.out.print(resultado);
	 * 
	 * }
	 */
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
