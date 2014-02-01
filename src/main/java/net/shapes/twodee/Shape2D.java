package net.shapes.twodee;

/**
 * Abstract superclass that all 2D shapes must extend. These shapes are thin
 * clients, they should not know about their ids or how they are handled, they
 * provide a purely mathematical iomplementation of these abstract entities.
 * 
 * @author Marton
 * 
 */
public abstract class Shape2D {
	protected double x = 0;
	protected double y = 0;
	
	public abstract String prettyPrint(String id);

	public abstract boolean envelopesPoint(double xx, double yy);
	
	public abstract double surfaceArea();
}
