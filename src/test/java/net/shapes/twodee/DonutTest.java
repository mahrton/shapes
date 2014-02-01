package net.shapes.twodee;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DonutTest {
	private Donut donut = null;
    @Before
    public void setUp() throws Exception {
        donut = new Donut(4, 4, 3, 4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void envelopesPointTest() {
        Assert.assertTrue(donut.envelopesPoint(4, 0));
        Assert.assertTrue(donut.envelopesPoint(0, 4));
        Assert.assertTrue(donut.envelopesPoint(4, 8));
        Assert.assertTrue(donut.envelopesPoint(8, 4));
        
        Assert.assertFalse(donut.envelopesPoint(4, 4));
        Assert.assertFalse(donut.envelopesPoint(10, 11));
    }
    
    @Test
    public void surfaceAreaTest() {
    	BigDecimal A = new BigDecimal(donut.surfaceArea()).setScale(2, RoundingMode.HALF_UP);
    	int comp = new BigDecimal(21.99).setScale(2, RoundingMode.HALF_UP).compareTo(A);
        Assert.assertEquals(comp, 0);
    }
}
