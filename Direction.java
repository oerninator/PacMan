package pacMan;

/**
 * Directions
 */
public enum Direction {

	UP, DOWN, LEFT, RIGHT, NONE;

	/**
	 * Reverse direction
	 * 
	 * @param direction normal direction
	 * @return reverse direction.
	 */
	public static Direction reverse(Direction direction) {
		switch (direction) {
		case UP:
			return Direction.DOWN;
		case DOWN:
			return Direction.UP;
		case LEFT:
			return Direction.RIGHT;
		case RIGHT:
			return Direction.LEFT;
		default:
			break;
		}
		return direction;
	}
}
