package net.shapes.twodee;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
	private Triangle triangle = null;
	
    @Before
    public void setUp() throws Exception {
    	triangle = new Triangle(1, 1, 3, 1, 2, 2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void envelopesPointTest() {
        Assert.assertTrue(triangle.envelopesPoint(1, 1));
        Assert.assertTrue(triangle.envelopesPoint(3, 1));
        Assert.assertTrue(triangle.envelopesPoint(2, 2));
        Assert.assertTrue(triangle.envelopesPoint(2.53, 1.13));
        
        Assert.assertFalse(triangle.envelopesPoint(-1, -1));
        Assert.assertFalse(triangle.envelopesPoint(2.53, 1.54));
    }
    
    @Test
    public void surfaceAreaTest() {
        Assert.assertEquals(triangle.surfaceArea(), 1.0, 0.01);
    }
}
