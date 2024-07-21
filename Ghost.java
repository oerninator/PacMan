package pacMan;

import java.util.ArrayList;

/**
 * Methods for the ghosts.
 */
public class Ghost {

	/**
	 * Position parameter.
	 */
	private Point position;

	/**
	 * If Ghost is eatable.
	 */
	private boolean eatable;

	/**
	 * Type of field the ghost stands on
	 */
	private char fieldType;
	
	private Point oldPosition;
	
	Point[] lastPositions;
	
	private int addedLastPositions;

	/**
	 * Constrcuctor thats the position and the type of field he stands on.
	 * 
	 * @param position
	 */
	public Ghost(Point position) {
		this.position = position;
		fieldType = '/';
		lastPositions = new Point[10];
		for(int i = 0; i < 10; i++) {
			lastPositions[i] = new Point(0,0);
		}
	}
	
	public Point[] getLastPositions() {
		return this.lastPositions;
	}
	
	/**
	 * Setter of the field type.
	 * 
	 * @param fieldType he stands on
	 * 
	 */
	public void setFieldType(char fieldType) {
		if(fieldType != 'G' && fieldType != 'P') {
			this.fieldType = fieldType;
		}
	}
	
	public void setOldPosition(Point oldPosition) {
		this.oldPosition = oldPosition;
		lastPositions[addedLastPositions % lastPositions.length] = oldPosition; 
		addedLastPositions++;
	}
	
	public Point getOldPosition() {
		return oldPosition;
	}

	/**
	 * Getter of the fieldtype
	 * 
	 * @return return the fieldType he stands on.
	 */
	public char getFieldType() {
		return fieldType;
	}

	/**
	 * Setter of the Position.
	 * 
	 * @param newPosition of the Ghost.
	 */
	public void setPosition(Point newPosition) {
		this.position = newPosition;
	}

	/**
	 * Setter of the new x value.
	 * 
	 * @param x new position.
	 */
	public void setX(double x) {
		position.setX(x);
	}

	/**
	 * Setter of the new y value.
	 * 
	 * @param y new position.
	 */
	public void setY(double y) {
		position.setY(y);
	}

	/**
	 * Getter of the position of the ghost.
	 * 
	 * @return the position.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Getter of the x position.
	 * 
	 * @return the x position.
	 */
	public double getX() {
		return position.getX();
	}

	/**
	 * Getter of the y position.
	 * 
	 * @return the y position.
	 */
	public double getY() {
		return position.getY();
	}

	/**
	 * Getter of eatable.
	 * 
	 * @return if the ghost is eatable or not.
	 */
	public boolean getEatable() {
		return eatable;
	}

	/**
	 * Setter of eatable.
	 * 
	 * @param eatable sets the status eatable.
	 */
	public void setEatable(boolean eatable) {
		this.eatable = eatable;
	}

}
