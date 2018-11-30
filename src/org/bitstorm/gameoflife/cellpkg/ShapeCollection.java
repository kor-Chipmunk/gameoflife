/**
 * Copyright 1996-2004 Edwin Martin <edwin@bitstorm.nl>
 * @author Edwin Martin
 */

package org.bitstorm.gameoflife.cellpkg;

import java.awt.Dimension;
import java.util.Enumeration;

/**
 * Contains some nice Game Of Life shapes.
 * @author Edwin Martin
 */
public class ShapeCollection {
	
	public static class Shapeofyou{
		private String name;
		private int[][] shape;
		Shapeofyou(String thatname,int[][] thatshape){
			name = thatname;
			shape = thatshape;
			
		}
		String getName() {
			return name;
		}
		
	}
	
	public static class Shapecell extends Shape{
		private String name;
		private int[][] shape;
		
		
		Shapecell(Shapeofyou sou){
			name = sou.name;
			shape = sou.shape;
			
		}
		
		public Dimension getDimension() {
			int shapeWidth = 0;
			int shapeHeight = 0;
			for (int cell = 0; cell < shape.length; cell++) {
				if (shape[cell][0] > shapeWidth)
					shapeWidth = shape[cell][0];
				if (shape[cell][1] > shapeHeight)
					shapeHeight = shape[cell][1];
			}
			shapeWidth++;
			shapeHeight++;
			return new Dimension( shapeWidth, shapeHeight );
		}
		
		/**
		 * Get name of shape.
		 * @return name of shape
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * Get shape data.
		 * Hide the shape implementation. Returns a anonymous Enumerator object.
		 * @return enumerated shape data
		 */
		public Enumeration getCells() {
			return new Enumeration() {
				private int index=0;
				public boolean hasMoreElements() {
					return index < shape.length;
				}
				public Object nextElement() {
					return shape[index++];
				}
			};
		}
		
		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return name+" ("+shape.length+" cell"+(shape.length==1?"":"s")+")";
		}
		
		
	}
	
	private static final Shapeofyou CLEAR;
	private static final Shapeofyou GLIDER;
	private static final Shapeofyou SMALLEXPL;
	private static final Shapeofyou EXPLODER;
	private static final Shapeofyou CELL10;
	private static final Shapeofyou FISH;
	private static final Shapeofyou PUMP;
	private static final Shapeofyou SHOOTER;
	private static final Shapeofyou[] COLLECTION;
	public static final String[] COLLECTIONNAME;

	


	static {
		CLEAR = new Shapeofyou("Clear", new int[][] {} );
		GLIDER = new Shapeofyou("Glider", new int[][] {{1,0}, {2,1}, {2,2}, {1,2}, {0,2}});
		SMALLEXPL = new Shapeofyou("Small Exploder", new int[][] {{0,1}, {0,2}, {1,0}, {1,1}, {1,3}, {2,1}, {2,2}});
		EXPLODER = new Shapeofyou("Exploder", new int[][] {{0,0}, {0,1}, {0,2}, {0,3}, {0,4}, {2,0}, {2,4}, {4,0}, {4,1}, {4,2}, {4,3}, {4,4}});
		CELL10 = new Shapeofyou("10 Cell Row", new int[][] {{0,0}, {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0}, {8,0}, {9,0}});
		FISH = new Shapeofyou("Lightweight spaceship", new int[][] {{0,1}, {0,3}, {1,0}, {2,0}, {3,0}, {3,3}, {4,0}, {4,1}, {4,2}});
		PUMP = new Shapeofyou("Tumbler", new int[][] {{0,3}, {0,4}, {0,5}, {1,0}, {1,1}, {1,5}, {2,0}, {2,1}, {2,2}, {2,3}, {2,4}, {4,0}, {4,1}, {4,2}, {4,3}, {4,4}, {5,0}, {5,1}, {5,5}, {6,3}, {6,4}, {6,5}});
		SHOOTER = new Shapeofyou("Gosper Glider Gun", new int[][] {{0,2}, {0,3}, {1,2}, {1,3}, {8,3}, {8,4}, {9,2}, {9,4}, {10,2}, {10,3}, {16,4}, {16,5}, {16,6}, {17,4}, {18,5}, {22,1}, {22,2}, {23,0}, {23,2}, {24,0}, {24,1}, {24,12}, {24,13}, {25,12}, {25,14}, {26,12}, {34,0}, {34,1}, {35,0}, {35,1}, {35,7}, {35,8}, {35,9}, {36,7}, {37,8}});
		COLLECTION = new Shapeofyou[] {CLEAR, GLIDER, SMALLEXPL, EXPLODER, CELL10, FISH, PUMP, SHOOTER};
		COLLECTIONNAME = new String[] {"Clear", "Glider", "Small Exploder", "Exploder", "10 Cell Row","Lightweight spaceship", "Tumbler", "Gosper Glider Gun"};

	}

	/**
	 * Get array of shapes.
	 * 
	 * It's not tamper-proof, but that's okay.
	 * @return collection of shapes
	 */
	public static String[] getShapes() {
		return COLLECTIONNAME;
	}
	public static Shapeofyou[] getShapescoll() {
		return COLLECTION;
	}
	
	/**
	 * Get shape by its name.
	 * @param name name of shape
	 * @return shapecell(extends Shape) object
	 * @throws ShapeException if no shape with this name exist
	 */
	public static Shape getShapeByName( String name ) throws ShapeException {
		for ( int i = 0; i < COLLECTIONNAME.length; i++ ) {
			if ( COLLECTIONNAME[i].equals( name )  ) {
				return new Shapecell(COLLECTION[i]);
			}
				
		}
		throw ( new ShapeException("Unknown shape: "+name) );
	}
}



