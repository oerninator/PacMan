package pacMan;

/**
 * Helpclass for the player.
 */
public class Player {

	/**
	 * parameter of the postition.
	 */
	private Point position;

	/**
	 * parameter for the last position.
	 */
	private Point oldPosition;

	/**
	 * parameter of the lifepoints.
	 */
	private int lifePoints;
	
	private Direction lastDirection;

	/**
	 * position and lightpoints.
	 * 
	 * @param position   of the player
	 * @param lifePoints of the player
	 */
	public Player(Point position, int lifePoints) {
		this.position = position;
		this.lifePoints = lifePoints;
		this.lastDirection = Direction.NONE;
	}
	
	public Direction getLastDirection() {
		return lastDirection;
	}
	
	public void setLastDirection(Direction lastDirection) {
		this.lastDirection = lastDirection;
	}
	/**
	 * Setter of the old position.
	 * 
	 * @param oldPosition of thr player.
	 */
	public void setOldPosition(Point oldPosition) {
		this.oldPosition = oldPosition;
	}

	/**
	 * Getter of the old position.
	 * 
	 * @return the old position.
	 */
	public Point getOldPosition() {
		return oldPosition;
	}

	/**
	 * Setter of the position.
	 * 
	 * @param newPosition of the player.
	 */
	public void setPosition(Point newPosition) {
		this.position = newPosition;
	}

	/**
	 * set the x position of the player.
	 * 
	 * @param x new coordinate.
	 */
	public void setX(double x) {
		position.setX(x);
	}

	/**
	 * set the y position of the player.
	 * 
	 * @param y new coordinate.
	 */
	public void setY(double y) {
		position.setY(y);
	}

	/**
	 * Getter of the position of the player.
	 * 
	 * @return the position of the player.
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * Getter of the x coordinate of the player.
	 * 
	 * @return the x position.
	 */
	public double getX() {
		return position.getX();
	}

	/**
	 * Getter of the y coordinate of the player.
	 * 
	 * @return the y position.
	 */
	public double getY() {
		return position.getY();
	}

	/**
	 * Getter of the Lifepoints of the player.
	 * 
	 * @return the lifepoints.
	 */
	public int getLifePoints() {
		return lifePoints;
	}

	/**
	 * Setter of the Liftpoints of the player.
	 * 
	 * @param lifePoints of the player.
	 */
	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
}
