package tankGame;

import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class bulletSelector extends GameObject {
	Main app;
	bulletSelector(Main app) {
		this.app = app;
		
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub
		
	}
	public void keyPressed(int keyCode, char key) {
		switch (key) {
		case '1':
			if(app.player1Turn) {
			app.getPlayer1().selectedType = 1;
			}
			else {
				app.getPlayer2().selectedType = 1;
				
			}
			System.out.println(app.getPlayer1().selectedType);
			break;
		case '2':
			if(app.player1Turn) {
				app.getPlayer1().selectedType = 2;
				}
				else {
					app.getPlayer2().selectedType = 2;
					
				}
			System.out.println(app.getPlayer1().selectedType);
			break;
		case '3':
			if(app.player1Turn) {
				app.getPlayer1().selectedType = 3;
				}
				else {
					app.getPlayer2().selectedType = 3;
					
				}
			System.out.println(app.getPlayer1().selectedType);
			break;
		case '4':
			if(app.player1Turn) {
				app.getPlayer1().selectedType = 4;
				}
				else {
					app.getPlayer2().selectedType = 4;
					
				}
			System.out.println(app.getPlayer1().selectedType);
			break;
		}
		}

	}


