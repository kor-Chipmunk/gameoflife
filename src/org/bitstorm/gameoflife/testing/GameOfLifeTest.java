package org.bitstorm.gameoflife.testing;

import static org.junit.Assert.*;

import java.util.Enumeration;

import org.bitstorm.gameoflife.*;
import org.bitstorm.gameoflife.ShapeCollection.Shapecell;
import org.bitstorm.gameoflife.ShapeCollection.Shapeofyou;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameOfLifeTest {

	// GameOfLife gameoflife;
	
	@Before
	public void setUp() throws Exception {
		// gameoflife = new GameOfLife();
	}
	
	@Test
	public void testSingleton() throws Exception {
		GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid(50, 30);
		int cellSize = 11;
		
		CellGridCanvas canvas1 = CellGridCanvas.getInstance(gameOfLifeGrid, cellSize);
		CellGridCanvas canvas2 = CellGridCanvas.getInstance(gameOfLifeGrid, cellSize);
		CellGridCanvas canvas3 = CellGridCanvas.getInstance(new GameOfLifeGrid(5,  5), 5);
		
		assertEquals(canvas1, canvas2);
		assertEquals(canvas1, canvas3);
		assertEquals(canvas2, canvas3);
	}
	
	@Test
	public void testFactory() throws Exception {
		checkShapes("Glider");
		checkShapes("Small Exploder");
		checkShapes("Exploder");
		checkShapes("10 Cell Row");
		checkShapes("Lightweight spaceship");
		checkShapes("Tumbler");
		checkShapes("Gosper Glider Gun");
	}
	
	public int[][] get2DShapeData(String name) {
		switch (name) {
		case "Glider":
			return new int[][] {{1,0}, {2,1}, {2,2}, {1,2}, {0,2}};
		case "Small Exploder":
			return new int[][] {{0,1}, {0,2}, {1,0}, {1,1}, {1,3}, {2,1}, {2,2}};
		case "Exploder":
			return new int[][] {{0,0}, {0,1}, {0,2}, {0,3}, {0,4}, {2,0}, {2,4}, {4,0}, {4,1}, {4,2}, {4,3}, {4,4}};
		case "10 Cell Row":
			return new int[][] {{0,0}, {1,0}, {2,0}, {3,0}, {4,0}, {5,0}, {6,0}, {7,0}, {8,0}, {9,0}};
		case "Lightweight spaceship":
			return new int[][] {{0,1}, {0,3}, {1,0}, {2,0}, {3,0}, {3,3}, {4,0}, {4,1}, {4,2}};
		case "Tumbler":
			return new int[][] {{0,3}, {0,4}, {0,5}, {1,0}, {1,1}, {1,5}, {2,0}, {2,1}, {2,2}, {2,3}, {2,4}, {4,0}, {4,1}, {4,2}, {4,3}, {4,4}, {5,0}, {5,1}, {5,5}, {6,3}, {6,4}, {6,5}};
		case "Gosper Glider Gun":
			return new int[][] {{0,2}, {0,3}, {1,2}, {1,3}, {8,3}, {8,4}, {9,2}, {9,4}, {10,2}, {10,3}, {16,4}, {16,5}, {16,6}, {17,4}, {18,5}, {22,1}, {22,2}, {23,0}, {23,2}, {24,0}, {24,1}, {24,12}, {24,13}, {25,12}, {25,14}, {26,12}, {34,0}, {34,1}, {35,0}, {35,1}, {35,7}, {35,8}, {35,9}, {36,7}, {37,8}};
		}
		
		return new int[][] {{0, 0}};
	}
	
	public void checkShapes(String name) throws Exception {
		Shape shape = ShapeCollection.getShapeByName(name);
		Enumeration enumShape = shape.getCells();
		
		int[][] ShapeOfData = get2DShapeData(name);
		
		Enumeration enumShapeOfGlider = new Enumeration() {
			private int index=0;
			public boolean hasMoreElements() {
				return index < ShapeOfData.length;
			}
			public Object nextElement() {
				return ShapeOfData[index++];
			}
		};
		
		while (enumShape.hasMoreElements()) {
			int[] numGlider = (int[]) enumShape.nextElement();
			int[] numShapeOfGlider = (int[]) enumShapeOfGlider.nextElement();
			
			for (int num = 0; num < numGlider.length; num++) {
				assertTrue(numShapeOfGlider[num] == numGlider[num]);
			}
		}
	}

}
