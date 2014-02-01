package net.shapes.twodee;

public class Circle extends Shape2D {
	private double r = 0;
	
	public Circle(double x, double y, double r) {
		if(r <= 0) throw new ArithmeticException("Circles must have a positive radius.");
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	@Override
	public boolean envelopesPoint(double xx, double yy) {
		return r >= Math.sqrt(Math.pow(Math.abs(x - xx), 2) + Math.pow(Math.abs(y - yy), 2));
	}

	@Override
	public String prettyPrint(String id) {
		return id + ": Circle with centre at (" + x + ", " + y + ") and radius " + r;
	}
	
	public double getRadius() {
		return this.r;
	}

	@Override
	public double surfaceArea() {
		return Math.pow(r, 2) * Math.PI;
	}
}
