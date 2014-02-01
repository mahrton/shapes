package net.shapes.twodee;

public class Triangle extends Shape2D {
	private double x2 = 0;
	private double y2 = 0;
	private double x3 = 0;
	private double y3 = 0;

	public Triangle(double x, double y, double x2, double y2, double x3, double y3) {
		if ((x == x2 && y == y2) || (x2 == x3 && y2 == y3) || (x == x3 && y == y3)) throw new ArithmeticException("The triangle's coordinates must be distinct.");
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	@Override
	public String prettyPrint(String id) {
		return id + ": Triangle with corners at (x1:" + x + ", y1:" + y + "), (x2:" + x2 + ", y2:" + y2 + "), (x3:" + x3 + ", y3:" + y3 + ") ";
	}

	@Override
	public boolean envelopesPoint(double xx, double yy) {
		// see Barycentric algorhythm 
    	double v1x = x2 - x;
        double v1y = y2 - y;
        double v2x = x3 - x;
        double v2y = y3 - y;
        
        double qx = xx - x;
        double qy = yy - y;
        
        double s = crossProduct(qx, qy, v2x, v2y) / crossProduct(v1x, v1y, v2x, v2y);
        double t = crossProduct(v1x, v1y, qx, qy) / crossProduct(v1x, v1y, v2x, v2y);
        
        if ( (s >= 0) && (t >= 0) && (s + t <= 1)) {
            return true;
        } else {
            return false;
        }
	}
	
    private double crossProduct(double x, double y, double x1, double y1) {
        return x * y1 - y * x1;
    }
	
	@Override
	public double surfaceArea() {
		return Math.abs((x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2)) / 2);
	}
}
