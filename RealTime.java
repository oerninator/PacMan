package pacMan;

public class RealTime implements Runnable{
	
	Model world;
	
	public RealTime(Model world) {
		this.world = world;
	}
	
	@Override
	public void run() {
		while(true) {
			world.updateViews(world.getPlayer().getLastDirection());
			
			long startTime = System.currentTimeMillis();
			
			while(System.currentTimeMillis() - startTime < 500) {
				
			}
		}
	}

}
