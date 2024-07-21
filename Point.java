package pacMan;

/**
 * Helpclass 
 */
public class Point {

	/**
	 * x parameter
	 */
	private double x;
	/**
	 * y parameter
	 */
	private double y;

	/**
	 * Constructor.
	 * @param x sets new position.
	 * @param y sets new position.
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter of x value.
	 * 
	 * @return return x value.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter of y value.
	 * 
	 * @return return y value.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Setter of x value.
	 * 
	 * @param x, new x value.
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Setter of y value.
	 * 
	 * @param y, new y value.
	 */
	public void setY(double y) {
		this.y = y;
	}
}
