package tankGame;

import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class mouseHandler extends GameObject {
	private Main app;
	mouseHandler(Main app){
		this.app = app;
		
		
	}
	

	@Override
	public void update() {
		ScoreBoard Score = app.getScoreBoard();
		if(Score.getPlayer1Score() >= 3) {
			Score.setText("Player 1 Wins");
			
		}
        if(Score.getPlayer2Score() >= 3) {
        	Score.setText("Player 2 Wins");
			
		}
	}
	@Override
	public void mousePressed(int x, int y, int button) {
		for(MenuKnop k : app.getMainMenu().getK()) {
			k.ingedrukt();
		}
		if(app.getMenuOpened() == false) {
		if(app.isPlayer1Turn() == true) {
			app.getPlayer1().fire();
			
		}
		else {
			app.getPlayer2().fire();
			
			
		}
		app.setPlayer1Turn(! app.isPlayer1Turn());
	}
		
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(int keyCode, char key) {
		Menu menu = app.getMainMenu();
		if(key == 'm') {
			System.out.println("menuknop");
			
			menu.setMenuOpen(!menu.isMenuOpen());
		}
		
	}
}
