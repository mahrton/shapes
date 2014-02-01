package net.shapes.twodee;

public class Square extends Shape2D {
	private double a = 0;
	
	public Square(double x, double y, double side) {
		if(side == 0) throw new ArithmeticException("The side of the square must be a number other than 0.");
		this.x = x;
		this.y = y;
		this.a = side;
	}
	
	@Override
	public String prettyPrint(String id) {
		return id + ": Square with " + (a > 0 ? "lower left" : "upper right") + " corner at (" + x + ", " + y + ") and side " + a;
	}

	@Override
	public boolean envelopesPoint(double xx, double yy) {
		return (((a > 0 && (xx >= x && yy >= y)) && (xx <= x + a) && (yy <= y + a)) || ((a < 0 && (xx <= x && yy <= y)) && (xx >= x + a) && (yy >= y + a)));
	}
	
	@Override
	public double surfaceArea() {
		return a * a;
	}
}
