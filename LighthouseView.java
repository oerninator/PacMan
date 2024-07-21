package pacMan;

import java.awt.Color;

/**
 * Creates the map of the PacMan game on the lighthouse.
 */

public class LighthouseView implements View {

	/**
	 * byte of the Lighthouse
	 */
	byte[] lighthouseMap = new byte[14 * 28 * 3];

	/**
	 * parameter to connect.
	 */
	Connection connection;

	/**
	 * puts the map on the Lighthouse.
	 * 
	 * @param map of pacman
	 */
	public LighthouseView(char[][] map) {
		connection = new Connection();
		connection.sendData(convertMap(map));
	}

	/**
	 * updates the view on the Lighthouse.
	 */
	@Override
	public void update(Model world) {
		connection.sendData(convertMap(world.getMap()));
	}

	/**
	 * map in colour on Lighthouse.
	 * 
	 * @param map of pacman
	 * @return the Lighthouse map.
	 */
	private byte[] convertMap(char[][] map) {
		for (int y = 0; y < 14; y++) {
			for (int x = 0; x < 28; x++) {
				Color color = null;
				switch (map[y][x]) {
				case '#':
					color = Color.GRAY;
					break;
				case '/':
					color = Color.BLUE;
					break;
				case '.':
					color = Color.WHITE;
					break;
				case 'G':
					color = Color.GREEN;
					break;
				case 'P':
					color = Color.YELLOW;
					break;
				case ':':
					color = new Color(255, 140, 0);
					break;
				}

				lighthouseMap[y * 28 * 3 + x * 3] = (byte) color.getRed();
				lighthouseMap[y * 28 * 3 + x * 3 + 1] = (byte) color.getGreen();
				lighthouseMap[y * 28 * 3 + x * 3 + 2] = (byte) color.getBlue();
			}
		}
		System.out.println("LIGHTHOUSE");
		return lighthouseMap;
	}

}
