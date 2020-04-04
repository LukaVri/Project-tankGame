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
		Menu menu = app.getMainMenu();
		levelselectKnop knop = menu.getSelect();
		knop.ingedrukt();
		if(app.getMenuOpened() == false) {
		if(app.player1Turn == true) {
			app.getPlayer1().fire();
			
		}
		else {
			app.getPlayer2().fire();
			
			
		}
		app.player1Turn = ! app.player1Turn;
	}
		else if (app.getMainMenu().getStart().ingedrukt()) {
			app.getMainMenu().menuOpen = false;
			
			
			
			
		}
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(int keyCode, char key) {
		if(key == 'm') {
			System.out.println("menuknop");
			
			app.getMainMenu().menuOpen = !app.getMainMenu().menuOpen;
			
			
			
		}
		
	}
}
