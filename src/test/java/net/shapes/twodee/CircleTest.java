package net.shapes.twodee;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CircleTest {
	private Circle circle = null;
    @Before
    public void setUp() throws Exception {
        circle = new Circle(4, 4, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void envelopesPointTest() {
        Assert.assertTrue(circle.envelopesPoint(4, 4));
        Assert.assertTrue(circle.envelopesPoint(4, 0));
        Assert.assertTrue(circle.envelopesPoint(0, 4));
        Assert.assertTrue(circle.envelopesPoint(4, 8));
        Assert.assertTrue(circle.envelopesPoint(8, 4));
        
        Assert.assertFalse(circle.envelopesPoint(10, 11));
    }
    
    @Test
    public void surfaceAreaTest() {
    	BigDecimal A = new BigDecimal(circle.surfaceArea()).setScale(2, RoundingMode.HALF_UP);
    	int comp = new BigDecimal(50.27).setScale(2, RoundingMode.HALF_UP).compareTo(A);
        Assert.assertEquals(comp, 0);
    }
}
