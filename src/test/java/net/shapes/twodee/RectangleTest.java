package net.shapes.twodee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class RectangleTest {
	private Rectangle rectangleUp = null;
	private Rectangle rectangleDown = null;
	
    @Before
    public void setUp() throws Exception {
    	rectangleUp = new Rectangle(4, 4, 3, 2);
    	rectangleDown = new Rectangle(4, 4, -3, -2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void envelopesPointTest() {
        Assert.assertTrue(rectangleUp.envelopesPoint(4, 4));
        Assert.assertTrue(rectangleUp.envelopesPoint(7, 4));
        Assert.assertTrue(rectangleUp.envelopesPoint(7, 6));
        Assert.assertTrue(rectangleUp.envelopesPoint(6, 4));
        Assert.assertTrue(rectangleUp.envelopesPoint(5.23, 5.13));
        
        Assert.assertFalse(rectangleUp.envelopesPoint(12.324, 32.12));
        
        Assert.assertTrue(rectangleDown.envelopesPoint(4, 4));
        Assert.assertTrue(rectangleDown.envelopesPoint(4, 2));
        Assert.assertTrue(rectangleDown.envelopesPoint(1, 2));
        Assert.assertTrue(rectangleDown.envelopesPoint(2, 4));
        Assert.assertTrue(rectangleDown.envelopesPoint(1.42, 2.98));
        
        Assert.assertFalse(rectangleDown.envelopesPoint(-12.324, -32.12));
    }
    
    @Test
    public void surfaceAreaTest() {
        Assert.assertEquals(rectangleUp.surfaceArea(), 6.0, 0.01);
        Assert.assertEquals(rectangleDown.surfaceArea(), 6.0, 0.01);
    }
}
