package net.shapes.twodee;

public class Donut extends Shape2D {
	private Circle inner = null;
	private Circle outter = null;
	
	public Donut(double x, double y, double r1, double r2) {
		if(r1 > r2) throw new ArithmeticException("Radius r1 must be smaller than r2.");
		if(r1 < 0 || r2 <= 0) throw new ArithmeticException("Radiuses must be both positive, r2 also has to be bigger than 0.");
		inner = new Circle(x, y, r1);
		outter= new Circle(x, y, r2);
	}
	
	@Override
	public String prettyPrint(String id) {
		return id + ": Donut with centre at (" + x + ", " + y + ") and radiuses - r1:" + inner.getRadius() + ", r2:" + outter.getRadius();
	}

	@Override
	public boolean envelopesPoint(double xx, double yy) {
		return outter.envelopesPoint(xx, yy) && !inner.envelopesPoint(xx, yy);
	}

	@Override
	public double surfaceArea() {
		return outter.surfaceArea() - inner.surfaceArea();
	}
}
