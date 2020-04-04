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
	   app.getMainMenu().getSelect().ingedrukt();
		if(app.menuOpened == false) {
		if(app.player1Turn == true) {
			app.player1.fire();
			
		}
		else {
			app.player2.fire();
			
			
		}
		app.player1Turn = ! app.player1Turn;
	}
		else if (app.getMainMenu().getStart().ingedrukt()) {
			app.mainMenu.menuOpen = false;
			
			
			
			
		}
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(int keyCode, char key) {
		if(key == 'm') {
			System.out.println("menuknop");
			app.mainMenu.menuOpen = !app.mainMenu.menuOpen;
			
			
			
		}
		
	}
}
