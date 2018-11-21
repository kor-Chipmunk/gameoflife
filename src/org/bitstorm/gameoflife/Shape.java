/**
 * Copyright 1996-2004 Edwin Martin <edwin@bitstorm.nl>
 * @author Edwin Martin
 */

package org.bitstorm.gameoflife;

import java.awt.Dimension;
import java.util.Enumeration;

/**
 * Shape contains data of one (predefined) shape.
 *
 * @author Edwin Martin
 */

public abstract class Shape{
	

	
	public abstract Dimension getDimension();
	
	/**
	 * Get name of shape.
	 * @return name of shape
	 */
	public abstract String getName();
	/**
	 * Get shape data.
	 * Hide the shape implementation. Returns a anonymous Enumerator object.
	 * @return enumerated shape data
	 */
	public abstract Enumeration getCells() ;
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public abstract String toString();
	
}
