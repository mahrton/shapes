package net.shapes.twodee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SquareTest {
	private Square squareUp = null;
	private Square squareDown = null;
	
    @Before
    public void setUp() throws Exception {
    	squareUp = new Square(4, 4, 4);
    	squareDown = new Square(4, 4, -4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void envelopesPointTest() {
        Assert.assertTrue(squareUp.envelopesPoint(4, 4));
        Assert.assertTrue(squareUp.envelopesPoint(8, 4));
        Assert.assertTrue(squareUp.envelopesPoint(4, 8));
        Assert.assertTrue(squareUp.envelopesPoint(8, 8));
        Assert.assertTrue(squareUp.envelopesPoint(6, 6));
        
        Assert.assertFalse(squareUp.envelopesPoint(12.324, 32.12));
        
        Assert.assertTrue(squareDown.envelopesPoint(4, 4));
        Assert.assertTrue(squareDown.envelopesPoint(0, 4));
        Assert.assertTrue(squareDown.envelopesPoint(4, 0));
        Assert.assertTrue(squareDown.envelopesPoint(0, 0));
        Assert.assertTrue(squareDown.envelopesPoint(2, 2));
        
        Assert.assertFalse(squareDown.envelopesPoint(-12.324, -32.12));
    }
    
    @Test
    public void surfaceAreaTest() {
        Assert.assertEquals(squareUp.surfaceArea(), 16.0, 0.01);
        Assert.assertEquals(squareDown.surfaceArea(), 16.0, 0.01);
    }
}
