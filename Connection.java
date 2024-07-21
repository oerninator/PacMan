package pacMan;

import java.io.IOException;

import vacMan.LighthouseDisplay;

public class Connection {
	
	LighthouseDisplay display;
	public Connection() {

		// Try connecting to the display
		try {
			display = LighthouseDisplay.getDisplay();
			display.setUsername("olofnator");
			display.setToken("API-TOK_oiuS-+mHH-6B7b-u9v7-up0c");
		} catch (Exception e) {
			System.out.println("Connection failed: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void sendData(byte[] data) {
		// Send data to the display
				try {
					// This array contains for every window (14 rows, 28 columns) three
					// bytes that define the red, green, and blue component of the color
					// to be shown in that window. See documentation of LighthouseDisplay's
					// send(...) method.
					//byte[] data = new byte[14 * 28 * 3];
					
					
//					for(int i = 0; i < data.length - 84; i++) {
//						data[i] = (byte) 120;
//					}
					
					display.sendImage(data);
				} catch (IOException e) {
					System.out.println("Connection failed: " + e.getMessage());
					e.printStackTrace();
				}
	}
}
