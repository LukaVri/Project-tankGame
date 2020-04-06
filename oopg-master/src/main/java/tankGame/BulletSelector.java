package tankGame;

import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class BulletSelector extends GameObject {
	Main app;
	BulletSelector(Main app) {
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
		Tanks player1 = app.getPlayer1();
		Tanks player2 = app.getPlayer2();
		switch (key) {
		case '1':
			if(app.isPlayer1Turn()) {
			 player1.setSelectedType(1);
			 player1.setAmmoSprite("bullet.png");
			}
			else {
				 player2.setSelectedType(1);
				 player2.setAmmoSprite("bullet.png");
			}
			
			break;
		case '2':
			if(app.isPlayer1Turn()) {
				player1.setSelectedType(2);
				player1.setAmmoSprite("bouncyBullet.png");
				}
				else {
					player2.setSelectedType(2);
					player2.setAmmoSprite("bouncyBullet.png");
				}
			
			break;
		case '3':
			if(app.isPlayer1Turn()) {
				player1.setSelectedType(3);
				player1.setAmmoSprite("scatterBullet.png");
				}
				else {
					player2.setSelectedType(3);
					player2.setAmmoSprite("scatterBullet.png");
					
				}
			
			break;
		case '4':
			if(app.isPlayer1Turn()) {
				player1.setSelectedType(4);
				player1.setAmmoSprite("bombBullet.png");
				}
				else {
					player2.setSelectedType(4);
					player2.setAmmoSprite("bombBullet.png");
					
				}
			
			break;
		}
		}

	}


