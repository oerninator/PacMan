package pacMan;

import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class EatCounter extends GraphicsProgram implements Runnable{

	ArrayList<GRect> ghostsGraph;
	ArrayList<Ghost> ghostsModel;
	
	public EatCounter(ArrayList<GRect> ghostsGraph, ArrayList<Ghost> ghostsModel) {
		this.ghostsGraph = ghostsGraph;
		this.ghostsModel = ghostsModel;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 4; i++) {
			ghostsGraph.get(i).setFillColor(Color.PINK);
			//ghostsModel.get(i).setEatable(true);
		}

		long startTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() - startTime < 5000) {
			
		}
		
		for(int i = 0; i < 4; i++) {
			ghostsGraph.get(i).setFillColor(Color.GREEN);
			ghostsModel.get(i).setEatable(false);
		}
	}

}
