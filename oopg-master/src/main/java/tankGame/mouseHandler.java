package tankGame;

import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class mouseHandler extends GameObject {
	
	Main app;
	mouseHandler(Main app){
		this.app = app;
		
		
	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(int x, int y, int button) {
		if(app.player1Turn == true) {
			app.player1.fire();
			
		}
		else {
			app.player2.fire();
			
			
		}
		app.player1Turn = ! app.player1Turn;
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
}
