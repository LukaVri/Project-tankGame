package tankGame;

import java.util.ArrayList;



public class WorldMaker {

	Main app;
	int width;
	int height;
	ArrayList<WorldObjects> blocks = new ArrayList<>();
	WorldMaker(int width,int height,Main app){
		this.width = width;
		this.height = height;
		this.app = app;
		
		
		
	}
	
	void createWorld() {
		for(int i =0; i < height;i ++) {
			for(int j =0; j < width; j ++) {
				WorldObjects obj = new WorldObjects(i + 8, j + 8, 20, "tile_earth.png", app);
				blocks.add(obj);
				app.addGameObject(obj,  j * 8, 600 - i * 8);
				
			}
			
			
		}
		
		
		
	}
	
}
