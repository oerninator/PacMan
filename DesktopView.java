package pacMan;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;

/**
 * Creates the map of the PacMan game in the canvas.
 */
public class DesktopView extends GCompound implements View {

	/**
	 * saves every box with the coordinates.
	 */
	ArrayList<GRect> rects = new ArrayList<GRect>();

	/**
	 * saves every big point on the map.
	 */
	ArrayList<GOval> specialPoints = new ArrayList<GOval>();

	/**
	 * saves every little point on the map.
	 */
	ArrayList<GOval> points = new ArrayList<GOval>();

	/**
	 * saves every Ghost graphic.
	 */
	ArrayList<GRect> ghosts = new ArrayList<GRect>();

	/**
	 * represents the player.
	 */
	GOval player;

	/**
	 * Size of every box(block) on the map.
	 */
	private static final int SIZE = 16;
	
	GLabel remainingDots;
	
	GLabel lifePoints;

	/**
	 * Constructor for background and map.
	 */
	public DesktopView(char[][] newMap) {
		background();
		generateMap(newMap);
	}

	/**
	 * Draws the map on the canvas.
	 * 
	 * @param newMap that gets printed on the canvas.
	 * 
	 */
	private void generateMap(char[][] newMap) {
		for (int y = 0; y < 14; y++) {
			for (int x = 0; x < 28; x++) {
				switch (newMap[y][x]) {
				case '#':
					GRect rect = block(x * SIZE, y * SIZE);
					fillAndColorBlock(rect);
					break;
				case '.':
					GOval dot = new GOval(x * SIZE + 5, y * SIZE + 5, 8, 8);
					dot.setFillColor(Color.WHITE);
					dot.setFilled(true);
					points.add(dot);
					add(dot);
					break;
				case ':':
					GOval specialDot = new GOval(x * SIZE, y * SIZE, SIZE, SIZE);
					fillAndColorEatPoints(specialDot);
					break;
				}
			}
		}
		remainingDots = new GLabel("Remaining Dots: " + Integer.toString(points.size()));
		remainingDots.setColor(Color.RED);
		remainingDots.setLocation(0, 250);
		remainingDots.setFont("Sansserif-25");
		add(remainingDots);
		
		lifePoints = new GLabel("Lifepoints: " + Integer.toString(3));
		lifePoints.setColor(Color.RED);
		lifePoints.setLocation(300, 250);
		lifePoints.setFont("Sansserif-25");
		add(lifePoints);
	}

	/**
	 * Creates every box in the correct Size and location.
	 * 
	 * @param x coordinate for the box.
	 * @param y coordinate for the box.
	 * @return the box on the correct location.
	 */
	private GRect block(int x, int y) {
		GRect baseBox = new GRect(x, y, SIZE, SIZE);
		return baseBox;
	}

	/**
	 * Fill and print the box, also put it on the canvas and save it into the
	 * ArrayList.
	 * 
	 * @param box, where the functions are used on.
	 */
	private void fillAndColorBlock(GRect box) {
		box.setFilled(true);
		rects.add(box);
		box.setFillColor(Color.BLUE);
		add(box);
	}

	/**
	 * Fill, color and adds the spcialpoint to the canvas, also adding it to the
	 * ArrayList of specialpoints.
	 * 
	 * @param eatPoint location of the specialPpoint to put it on the canvas.
	 * 
	 */
	private void fillAndColorEatPoints(GOval eatPoint) {
		eatPoint.setFilled(true);
		eatPoint.setFillColor(new Color(255, 140, 0));
		add(eatPoint);
		specialPoints.add(eatPoint);
	}

	/**
	 * Prints the background of the map black.
	 */
	private void background() {
		GRect back = new GRect(2000, 2000);
		back.setFilled(true);
		back.setColor(Color.BLACK);
		add(back);
	}

	/**
	 * Gets the new Position of the player , removes dots when they are touched,
	 * adds a animation for the special dot, get the new Position of the ghosts..
	 */
	public void update(Model world) {
		player.move(world.getPlayerX() - player.getX(), world.getPlayerY() - player.getY());

		// removes the touched dot
		for (GOval dot : points) {
			if (player.getBounds().contains(dot.getX(), dot.getY())) {
				remove(dot);
				points.remove(dot);
				break;
			}
		}
		// remove the dots when there is a special dot and add a animation for hitting
		// the specialdots
		for (GOval dot : specialPoints) {
			if (player.getBounds().contains(dot.getX(), dot.getY())) {
				remove(dot);
				specialPoints.remove(dot);
				Thread animation = new Thread(new EatCounter(ghosts, world.getAllGhosts()));
				animation.start();
				break;
			}
		}
		// change to new place of the ghost.
		for (GRect ghost : ghosts) {
			ghost.move(world.getGhost(ghosts.indexOf(ghost)).getX() - ghost.getX(),
					world.getGhost(ghosts.indexOf(ghost)).getY() - ghost.getY());
		}
		
		//update remaining dots and lifepoints
		remainingDots.setLabel("Remaining Dots: " + Integer.toString(points.size()));
		lifePoints.setLabel("Lifepoints: " + Integer.toString(world.getPlayer().getLifePoints()));
	}

	/**
	 * Prints the first position of the player on the map.
	 * 
	 * @param player Location of the player.
	 */
	public void addPlayer(Player player) {
		this.player = new GOval(player.getX(), player.getY(), SIZE, SIZE);
		this.player.setFillColor(Color.YELLOW);
		this.player.setFilled(true);
		add(this.player);
	}

	/**
	 * Print the ghosts at the first position on the map.
	 * 
	 * @param ghost Location of the ghosts.
	 */
	public void addGhost(Ghost ghost) {
		GRect newGhost = new GRect(ghost.getX(), ghost.getY(), SIZE, SIZE);
		newGhost.setFillColor(Color.GREEN);
		newGhost.setFilled(true);
		ghosts.add(newGhost);
		add(newGhost);
	}
}
