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
		if(app.player1Turn == true) {
			app.getPlayer1().fire();
			
		}
		else {
			app.getPlayer2().fire();
			
			
		}
		app.player1Turn = ! app.player1Turn;
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
