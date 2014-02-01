package net.shapes.twodee;

public class Rectangle extends Shape2D {
	private double a = 0;
	private double b = 0;
	
	public Rectangle(double x, double y, double a, double b) {
		if(a == 0 || b == 0) throw new ArithmeticException("The rectangle's sides must be positive.");
		if((a > 0 && b < 0) || (a < 0 && b > 0)) throw new ArithmeticException("The rectangle's sides must either be both positive or negative.");
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String prettyPrint(String id) {
		return id + ": Rectangle with centre at (" + x + ", " + y + ") and sides - a: " + a + ", b:" + b;
	}

	@Override
	public boolean envelopesPoint(double xx, double yy) {
		return (((a > 0 && (xx >= x && yy >= y)) && (xx <= x + a) && (yy <= y + b)) || ((a < 0 && (xx <= x && yy <= y)) && (xx >= x + a) && (yy >= y + b)));
	}
	
	@Override
	public double surfaceArea() {
		return a * b;
	}
}
