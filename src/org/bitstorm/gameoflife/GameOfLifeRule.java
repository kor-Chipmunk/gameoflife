package org.bitstorm.gameoflife;

import java.util.Enumeration;
import java.util.Hashtable;

public interface GameOfLifeRule {
	default void checkRule(Hashtable<Cell, Cell> currentShape, Hashtable<Cell, Cell> nextShape) {
		Enumeration<Cell> currentEnums; 
		Enumeration<Cell> nextEnums;
		
		nextShape.clear();
		
		currentEnums = currentShape.keys();
		resetCells(currentEnums);
		
		currentEnums = currentShape.keys();
		addNeighbours(currentEnums);
		
		currentEnums = currentShape.keys();
		buryDeads(currentEnums);
		
		nextEnums = nextShape.keys();
		newBorns(nextEnums);
	}
	
	void resetCells(Enumeration<Cell> enums);
	void addNeighbours(Enumeration<Cell> enums);
	void buryDeads(Enumeration<Cell> enums);
	void newBorns(Enumeration<Cell> enums);
}
