package pacMan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import acm.util.RandomGenerator;

/**
 * Processed all functions of the pacman
 *
 */
public class Model {
	/** saves the position from the player. */
	private Player player;
	/** saves the different views we have. */
	private ArrayList<View> views = new ArrayList<>();
	/** saves the position from the ghosts + their current state. */
	private ArrayList<Ghost> ghosts = new ArrayList<>();
	/** saves the window size, x = width, y = height */
	private Point windowSize;
	/** */
	private char[][] map;
	/**
	 * Size of every box(block) on the map.
	 */
	private static final int SIZE = 16;

	/**
	 * saves last position of each ghost.
	 */
	private HashMap<Ghost, Direction> lastGhostDirection = new HashMap<Ghost, Direction>();

	/**
	 * Random number
	 */
	RandomGenerator rgen = RandomGenerator.getInstance();

	// # = grect, / = leer, P = player, G = ghost, : = specialdot, . = normaldot
	public Model() {
		// line 0:
		char[][] smap = {
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
						'#', '#', '#', '#', '#', '#', '#', '#' },
				// line 1:
				{ '#', ':', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'#', '.', '.', '.', '.', '.', ':', '#' },
				// line 2:
				{ '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.',
						'#', '.', '#', '#', '#', '.', '.', '#' },
				// line 3:
				{ '#', '.', '.', '#', 'P', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'#', '.', '.', '.', '#', '.', '.', '#' },
				// line4:
				{ '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '#', '.', '.', '#' },
				// line 5: map verändert
				{ '#', '.', '.', '#', '.', '.', '#', '#', '.', '.', '#', '#', '/', '/', '/', '/', '#', '#', '.', '.',
						'.', '#', '#', '.', '#', '.', '.', '#' },
				// line 6:
				{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '/', '/', '/', 'G', '/', '/', '#', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '#' },
				// line 7:
				{ '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '#' },
				// line 8:
				{ '#', '.', '.', '#', '.', '.', '#', '#', '.', '.', '.', '.', '.', '.', ':', '.', '.', '.', '.', '.',
						'.', '#', '#', '.', '#', '.', '.', '#' },
				// line 9:
				{ '#', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '#', '.', '.', '#' },
				// line 10:
				{ '#', '.', '.', '#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'#', '.', '.', '.', '#', '.', '.', '#' },
				// line 11:
				{ '#', '.', '.', '#', '#', '#', '.', '#', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.',
						'#', '.', '#', '#', '#', '.', '.', '#' },
				// line 12:
				{ '#', ':', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'#', '.', '.', '.', '.', '.', ':', '#' },
				// line 13:
				{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#',
						'#', '#', '#', '#', '#', '#', '#', '#' } };

		map = smap;
	}

	/**
	 * Getter of the map.
	 * 
	 * @return the map.
	 */
	public char[][] getMap() {
		return map;
	}

	/**
	 * Setter of the map.
	 * 
	 * @param map change.
	 */
	public void setMap(char[][] map) {
		this.map = map;
	}

	/**
	 * Getter of the Player.
	 * 
	 * @return the player.
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * x coordinate from player.
	 * 
	 * @return the x coordinate from the player.
	 */
	public double getPlayerX() {
		return player.getX();
	}

	/**
	 * y coordinate from the player.
	 * 
	 * @return the y coordinate from the player.
	 */
	public double getPlayerY() {
		return player.getY();
	}

	/**
	 * Setter of the x coordiante of the player.
	 * 
	 * @param x change to new one.
	 */
	public void setPlayerX(double x) {
		player.setX(x);
	}

	/**
	 * Setter of the y coordiante of the player.
	 * 
	 * @param y change to new one.
	 */
	public void setPlayerY(double y) {
		player.setY(y);
	}
/**
 * Getter of the ghost with position.
 * @param position of the ghost.
 * @return the ghost on the position.
 */
	public Ghost getGhost(int position) {
		if (position < 0 || position >= ghosts.size()) {
			throw new IllegalArgumentException();
		}
		return ghosts.get(position);
	}
/**
 * Getter of the ghost with coordiante.
 * @param x coordination.
 * @param y coordination.
 * @return the ghost position.
 */
	public Ghost getGhost(double x, double y) {
		for (Ghost ghost : ghosts) {
			if (ghost.getX() == x && ghost.getY() == y) {
				return ghost;
			}
		}
		return null;
	}
/**
 * Getter of every Ghost in the game.
 * @returns every ghost.
 */
	public ArrayList<Ghost> getAllGhosts() {
		return ghosts;
	}
/**
 * Setter of the Ghost.
 * @param position that will be set.
 * @param ghost that will be set on the position.
 */
	public void setGhost(int position, Ghost ghost) {
		ghosts.set(position, ghost);
	}
/**
 * Adds the player and ghosts to the map.
 * @param view
 */
	public void registerView(View view) {
		views.add(view);
		if (view instanceof DesktopView) {
			player = new Player(new Point(64, 48), 3);
			for (int i = 0; i < 4; i++) {
				Ghost ghost = new Ghost(new Point(224, 96));
				ghosts.add(ghost);
				((DesktopView) view).addGhost(ghost);
				lastGhostDirection.put(ghost, Direction.NONE);
			}
			((DesktopView) view).addPlayer(player);
		}
	}
/**
 * Update the position of the 
 * @param direction
 */
	public void updateViews(Direction direction) {
		player.setLastDirection(direction);
		
		int newX = 0, newY = 0;
		switch (direction) {
		case UP:
			newY -= 16;
			break;
		case DOWN:
			newY += 16;
			break;
		case RIGHT:
			newX += 16;
			break;
		case LEFT:
			newX -= 16;
			break;
		default:
			break;
		}
		// checks if the move is possible
		if (map[(int) ((player.getY() + newY) / SIZE)][(int) ((player.getX() + newX) / SIZE)] != '#') {
			// moves the player and corrects the map
			map[(int) (player.getY() / SIZE)][(int) (player.getX() / SIZE)] = '/';
			map[(int) ((player.getY() + newY) / SIZE)][(int) ((player.getX() + newX) / SIZE)] = 'P';
			player.setOldPosition(player.getPosition());
			player.setPosition(new Point(player.getX() + newX, player.getY() + newY));
		}
		
		
		
		
		// specialpoint got hit
		if (map[(int) ((player.getY() + newY) / SIZE)][(int) ((player.getX() + newX) / SIZE)] == ':') {
			// every ghost is now eatable
			for (Ghost ghost : ghosts) {
				ghost.setEatable(true);
			}
		}
		updateGhost();
		// checks if we've hitten a ghost
		for (Ghost ghost : ghosts) {
			if ((ghost.getX() == player.getX() && ghost.getY() == player.getY() || // player and ghost are on the
																					// same field
					(ghost.getX() == player.getOldPosition().getX()
							&& ghost.getY() == player.getOldPosition().getY() && // ghost is on the old player field
							player.getX() == ghost.getOldPosition().getX()
							&& player.getY() == ghost.getOldPosition().getY()))
					&& // player is on the old ghost field
					!ghost.getEatable()) {
				System.out.println("GEIST GETROFFEN");
				// we've hitten a ghost resets player position and map, as well as lifepoints
				map[(int) (player.getY() / SIZE)][(int) (player.getX() / SIZE)] = '/';
				player.setPosition(new Point(64, 48));
				map[(int) (player.getY() / SIZE)][(int) (player.getX() / SIZE)] = 'P';
				player.setLifePoints(player.getLifePoints() - 1);
				// resets the position from every ghost
				for (Ghost g : ghosts) {
					map[(int) (g.getY() / SIZE)][(int) (g.getX() / SIZE)] = g.getFieldType();
					g.setFieldType('/');
					g.setPosition(new Point(224, 96));
				}
			} else if ((ghost.getX() == player.getX() && ghost.getY() == player.getY() || // player and ghost are on
																							// the same field
					(ghost.getX() == player.getOldPosition().getX()
							&& ghost.getY() == player.getOldPosition().getY() && // ghost is on the old player field
							player.getX() == ghost.getOldPosition().getX()
							&& player.getY() == ghost.getOldPosition().getY()))
					&& // player is on the old ghost field
					ghost.getEatable()) {
				// reset position from specified ghost
				map[(int) (ghost.getY() / SIZE)][(int) (ghost.getX() / SIZE)] = '/';
				ghost.setFieldType('/');
				ghost.setPosition(new Point(224, 96));
				System.out.println("IMMUN");
			}
		}
		// The game is over
		if (player.getLifePoints() == 0) {
			System.out.println("GAME OVER!");
			System.exit(0);
		}
		// checks if we've won
		boolean win = true;
		for (int y = 0; y < 14; y++) {
			for (int x = 0; x < 28; x++) {
				if (map[y][x] == '.') {
					win = false;
				}
			}
		}
		if (win) {
			System.out.println("WIN!");
			System.exit(0);
		}
		for (View view : views) {
			view.update(this);
		}
	}
/**
 * Update the position of the ghost.
 */
	public void updateGhost() {
		for (Ghost ghost : ghosts) {
			ArrayList<Direction> possibleDirections = getPossibleDirections(ghost);
			ArrayList<Direction> filteredDirections = new ArrayList<>();
			
			Direction endDirection = possibleDirections.get(rgen.nextInt(0, possibleDirections.size() - 1));
		
			
			found:for(Direction direction : possibleDirections) {
				int newX = 0, newY = 0;
				switch (direction) {
				case UP:
					newY -= 16;
					break;
				case DOWN:
					newY += 16;
					break;
				case RIGHT:
					newX += 16;
					break;
				case LEFT:
					newX -= 16;
					break;
				default:
					break;
				}
				
				//checks if we can kill the player
				if(ghost.getX() + newX == player.getX() && ghost.getY() + newY == player.getY() || 
						ghost.getX() + newX == player.getOldPosition().getX() && ghost.getY() + newY == player.getOldPosition().getY()) {
					filteredDirections.clear();
					filteredDirections.add(direction);
					break found;
				}
				
				
				
				//checks if the direction ends on a field the ghost already visited
				for(Point lastPoint : ghost.getLastPositions()) {
					if(lastPoint.getX() == ghost.getX() + newX && lastPoint.getY() ==  ghost.getY() + newY) {
						continue found;
					}
				}
				//calculates distance to the player (without worrying about borders)
				double distancePlayer = Math.abs(player.getX() - ghost.getX()) + Math.abs(player.getY() - ghost.getY()); 
				double distancePlayerNew = Math.abs(ghost.getX() + newX - player.getX()) + Math.abs(ghost.getY() + newY - player.getY());
				if(distancePlayer < distancePlayerNew) {
					continue found;
				}
				filteredDirections.add(direction);
			}
			
			if(filteredDirections.size() > 0) {
				endDirection = filteredDirections.get(rgen.nextInt(0, filteredDirections.size() - 1));
			}
			
			// Sets the current Field to the state before the ghost enters
			map[(int) ghost.getY() / SIZE][(int) ghost.getX() / SIZE] = ghost.getFieldType();

			int newX = 0, newY = 0;
			switch (endDirection) {
			case UP:
				newY -= 16;
				break;
			case DOWN:
				newY += 16;
				break;
			case RIGHT:
				newX += 16;
				break;
			case LEFT:
				newX -= 16;
				break;
			default:
				break;
			}
			//sets ghost to the new position.
			ghost.setFieldType(map[(int) (ghost.getY() + newY) / SIZE][(int) (ghost.getX() + newX) / SIZE]);
			map[(int) (ghost.getY() + newY) / SIZE][(int) (ghost.getX() + newX) / SIZE] = 'G';
			ghost.setOldPosition(ghost.getPosition());
			ghost.setPosition(new Point(ghost.getX() + newX, ghost.getY() + newY));
			lastGhostDirection.replace(ghost, endDirection);
		}
	}
/**
 * looking for the way the ghost is able to enter.
 * @param ghost
 * @return
 */
	public ArrayList<Direction> getPossibleDirections(Ghost ghost) {
		ArrayList<Direction> possibleDirections = new ArrayList<Direction>();

		if (map[(int) ((ghost.getY()) / SIZE)][(int) ((ghost.getX() + 16) / SIZE)] != '#') {
			possibleDirections.add(Direction.RIGHT);
		}
		if (map[(int) ((ghost.getY()) / SIZE)][(int) ((ghost.getX() - 16) / SIZE)] != '#') {
			possibleDirections.add(Direction.LEFT);
		}
		if (map[(int) ((ghost.getY() + 16) / SIZE)][(int) ((ghost.getX()) / SIZE)] != '#') {
			possibleDirections.add(Direction.DOWN);
		}
		if (map[(int) ((ghost.getY() - 16) / SIZE)][(int) ((ghost.getX()) / SIZE)] != '#') {
			possibleDirections.add(Direction.UP);
		}

		return possibleDirections;
	}
}
