package net.shapes.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;

import net.shapes.twodee.Shape2D;

public class Main {
	private static final String CURSOR = "=> ";
	private static final String HELP = " === Batch pocessor and 2D shapes framework === \n" +
	"you can exit by typing 'exit'. To create shapes please provide them in this format:\n" + 
	"circle (+/-)0.00, (+/-)0.00, +0.00\n" +
	"Once you've created some shapes you can search for points enveloped by them\n\n" +
	"Currently available shapes with their pattern usage:";
	
	public static void main(String[] args) {
		HashMap<Integer, Shape2D> shapes = new HashMap<Integer, Shape2D>();
		if (args.length > 0) {
			for (String s : args) {
				System.out.println("Reading shapes from '" + s + "' ...");
				System.out.println("===================================");
				try {
					BufferedReader br = new BufferedReader(new FileReader(s));
					String line = null;
					while ((line = br.readLine()) != null) {
						Shape2D sp = tryCreation(line);
						if(null != sp) shapes.put(sp.hashCode(), sp);
					}
					br.close();
				} catch (IOException e1) {
					System.err.println("An error occurred during the reading of the file '"	+ s + "'; skipping it.");
				}
				System.out.println("Done readig '" + s + "'.");
			}
		}
		
    	System.out.print("Welcome to the interactive Java Shapes creator console, " +
    			"type help for more information.\n");
		
		while(true) {
	        try {
	        	System.out.print(CURSOR);
	        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s = br.readLine().trim();
				// this condition tree is not the most beautiful code I have ever written
				// but making user input processing pretty is not sure worth the effort
				if(s.matches("exit.*")) {
					System.exit(0);
				} else if(s.matches("help.*")) {
					System.out.println(HELP); 
					for(ShapesResolver r : ShapesResolver.values()) {
						System.out.println(r.getUserPattern());
					}
				} else if(s.matches("envelope.*")) {
					// let's leave this slightly more generic in case we move towards 3-4-5D shapes
					double[] params = new double[2];
					Matcher m = ShapesResolver.floatRegex.matcher(s);
					for(int i = 0 ; i < params.length ; i++) {
						m.find();
						params[i] = Double.parseDouble(m.group());
					}
					double A = 0;
					Iterator<Shape2D> it = shapes.values().iterator();
					while(it.hasNext()) {
						Shape2D sp = it.next();
						if(sp.envelopesPoint(params[0], params[1])) {
							double surface = sp.surfaceArea();
							System.out.println(sp.prettyPrint("" + sp.hashCode()) + " - Surface area: " + surface);
							A += surface;
						}
					}
					System.out.println("The overall area covered by the shapes containign this point is: " + A + " units.");
				} else {
					Shape2D sp = tryCreation(s); 
					if(sp != null) {
						System.out.println(sp.prettyPrint(String.valueOf(sp.hashCode())));
						shapes.put(sp.hashCode(), sp);
					}
				}
	        } catch (IOException e) {
	        	System.err.println("There has been an error during read from command line, exiting.");
	        	e.printStackTrace();
	        }
		}
	}
	
	private static Shape2D tryCreation(String line) {
		try {
			Shape2D sp = ShapesResolver.createShapeFromLine(line);
			return sp;
		} catch (Exception e) {
			System.err.println("\nThere was an exception during the creation of shapes.\n" +
			"The problem is with line: '" + line + "'\n" +
			"The error message - " + e.getMessage());
		}
		return null;
	}
}
