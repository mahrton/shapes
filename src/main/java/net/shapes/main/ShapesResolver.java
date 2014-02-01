package net.shapes.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.shapes.twodee.Circle;
import net.shapes.twodee.Donut;
import net.shapes.twodee.Rectangle;
import net.shapes.twodee.Shape2D;
import net.shapes.twodee.Square;
import net.shapes.twodee.Triangle;

/**
 * This is the centre point for all Shape creation related tasks.
 * It bridges the gap between user interaction and the thin client Shapes package. 
 * What doesn't end up in this file won't be available to the user.
 * 
 * @author Marton
 *
 */
public enum ShapesResolver {
	CIRCLE("circle.*", "circle (+/-)0.00 (+/-)0.00 (+)0.00") {
		@Override
		public Shape2D create(List<Double> params) throws Exception {
			if(params.size() < 3) throw new Exception("There are three params required to build a Circle");
			return new Circle(params.get(0), params.get(1), params.get(2));
		}
	},
	SQUARE("square.*", "square (+/-)0.00 (+/-)0.00 (+)0.00") {
		@Override
		public Shape2D create(List<Double> params) throws Exception {
			if(params.size() < 3) throw new Exception("There are three params required to build a Square.");
			return new Square(params.get(0), params.get(1), params.get(2));
		}
	},
	RECTANGLE("rectangle.*", "rectangle (+/-)0.00 (+/-)0.00 (+)0.00 (+)0.00") {
		@Override
		public Shape2D create(List<Double> params) throws Exception {
			if(params.size() < 4) throw new Exception("There are four params required to build a Rectangle.");
			return new Rectangle(params.get(0), params.get(1), params.get(2), params.get(3));
		}
	},
	TRIANGLE("triangle.*", "triangle (+/-)0.00 (+/-)0.00 (+/-)0.00 (+/-)0.00 (+/-)0.00 (+/-)0.00") {
		@Override
		public Shape2D create(List<Double> params) throws Exception {
			if(params.size() < 6) throw new Exception("There are six params required to build a Triangle.");
			return new Triangle(params.get(0), params.get(1), params.get(2), params.get(3), params.get(4), params.get(5));
		}
	},
	DONUT("donut.*", "donut (+/-)0.00 (+/-)0.00 (+)0.00 (+)0.00") {
		@Override
		public Shape2D create(List<Double> params) throws Exception {
			if(params.size() < 4) throw new Exception("There are four params required to build a Donut.");
			return new Donut(params.get(0), params.get(1), params.get(2), params.get(3));
		}
	};

	public static final Pattern floatRegex = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
	private String pattern = null;
	private String userPattern = null;

	private ShapesResolver(String pattern, String userPattern) {
		this.pattern = pattern;
		this.userPattern = userPattern;
	}

	public boolean matchLine(String line) {
		return line.matches(this.pattern);
	}
	
	public static Shape2D createShapeFromLine(String line) throws Exception {
		for(ShapesResolver r : values()) {
			List<Double> params = new ArrayList<Double>();
			if(r.matchLine(line)) {
				Matcher m = floatRegex.matcher(line);
				while(m.find()) {
					params.add(Double.parseDouble(m.group()));
				}
				return r.create(params);
			}
		}
		return null;
	}
	
	public Shape2D create(List<Double> params) throws Exception {
		// parent method to be overridden
		return null;
	}
	
	public String getUserPattern() {
		return this.userPattern;
	}
}
