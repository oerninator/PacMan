package pacMan;

import java.awt.event.KeyEvent;
import acm.program.GraphicsProgram;

/**
 * Gets a input and calls the model to use the functions.
 */
public class Controller extends GraphicsProgram {

	/**
	 * create a model.
	 */
	private Model model;

	/**
	 * starts the program
	 * 
	 * @param args starts the program
	 */
	public static void main(String[] args) {
		new Controller().start();
	}

	/**
	 * Call the view for the canvas and calls the model if a key is used.
	 */
	public void init() {
		model = new Model();

		addKeyListeners();

		DesktopView deskView = new DesktopView(model.getMap());
		model.registerView(deskView);
		add(deskView);

		LighthouseView lightView = new LighthouseView(model.getMap());
		model.registerView(lightView);
		
		Thread rt = new Thread(new RealTime(model));
		rt.start();
		

	}
/**
 * keys that are Input for the Controller
 */
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("UP");
			if(model.getPlayer().getLastDirection() != Direction.UP) {
				model.getPlayer().setLastDirection(Direction.UP);
			}
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("DOWN");
			if(model.getPlayer().getLastDirection() != Direction.DOWN) {
				model.getPlayer().setLastDirection(Direction.DOWN);
			}
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("RIGHT");
			if(model.getPlayer().getLastDirection() != Direction.RIGHT) {
				model.getPlayer().setLastDirection(Direction.RIGHT);
			}
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("LEFT");
			if(model.getPlayer().getLastDirection() != Direction.LEFT) {
				model.getPlayer().setLastDirection(Direction.LEFT);
			}
			break;
		}
	}
}
