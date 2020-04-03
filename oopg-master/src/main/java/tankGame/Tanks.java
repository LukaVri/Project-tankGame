package tankGame;

import java.util.ArrayList;
import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.CollisionSide;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Tanks extends SpriteObject implements ICollidableWithTiles, ICollidableWithGameObjects {

	private Main app;
	String sprite;
	int player;
	float xPos;
	float yPos;
	boolean clicked;
	ArrayList<Ammo> ammo = new ArrayList<>();

	Tanks(Main app, String sprite, int player,float xPos,float yPos) {

		super(new Sprite(Main.MEDIA_URL.concat(sprite)));

		this.app = app;
		this.sprite = sprite;
		this.player = player;
		setGravity(0.01f);
		this.xPos = xPos;
		this.yPos = yPos;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		if (keyCode == app.LEFT && player == 1 && app.player1Turn == true
				|| key == 'a' && player == 2 && app.player1Turn == false) {
			setDirectionSpeed(270, 5);
			// app.player1Turn = ! app.player1Turn;
		}
		if (keyCode == app.RIGHT && player == 1 && app.player1Turn == true
				|| key == 'd' && player == 2 && app.player1Turn == false) {
			setDirectionSpeed(270, -5);
			// app.player1Turn = ! app.player1Turn;
		}

	}

	public void keyReleased(int keyCode, char key) {
		if (keyCode == app.LEFT && player == 1 || key == 'a' && player == 2) {
			setDirectionSpeed(0, 0);
		}
		if (keyCode == app.RIGHT && player == 1 || key == 'd' && player == 2) {
			setDirectionSpeed(0, 0);
		}

	}

	void fire() {

		if (player == 1) {
			if (getAngleFrom(app.mouseX, app.mouseY) > 270 || getAngleFrom(app.mouseX, app.mouseY) < 90) {
				if (getDistance() < 100 && getDistance() > 20) {

					Ammo a = new Ammo(getAngleFrom(app.mouseX, app.mouseY), 3, 1, app, "bullet.png",
							this.getDistance() / 20);
					ammo.add(a);
					app.addGameObject(a, super.x, super.y);

				}
			}

		}
		if (player == 2) {
			if (getAngleFrom(app.mouseX, app.mouseY) > 270 || getAngleFrom(app.mouseX, app.mouseY) < 90) {
				if (getDistance() < 100 && getDistance() > 20) {
					Ammo a = new Ammo(getAngleFrom(app.mouseX, app.mouseY), 2, 1, app, "bullet.png", this.getDistance() / 20);
					ammo.add(a);
					app.addGameObject(a, super.x, super.y);
				}
			}

		}

	}

	/*
	 * public void mousePressed(int x, int y, int button) { if(!clicked) { if
	 * (player == 1 && app.player1Turn == true) { if (getAngleFrom(app.mouseX,
	 * app.mouseY) > 270 || getAngleFrom(app.mouseX, app.mouseY) < 90) { if
	 * (getDistance() < 100 && getDistance() > 20) {
	 * 
	 * Ammo a = new Ammo(getAngleFrom(app.mouseX, app.mouseY), 20, 1, app,
	 * "bullet.png", getDistance() / 20); ammo.add(a);
	 * 
	 * app.addGameObject(a, super.x, super.y); app.player1Turn = false;
	 * 
	 * } } } else if (player == 2 && app.player1Turn == false) {
	 * 
	 * Ammo a = new Ammo(getAngleFrom(app.mouseX, app.mouseY), 20, 1, app,
	 * "bullet.png", 5); ammo.add(a);
	 * 
	 * app.addGameObject(a, super.x, super.y); app.player1Turn = true;
	 * 
	 * } }
	 * 
	 * }
	 */

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof groundTiles) {

				try {

					vector = app.getTileMap().getTilePixelLocation(ct.getTile());
					if (ct.getCollisionSide() == CollisionSide.RIGHT) {
						setX(vector.x + getWidth());
					}
					if (ct.getCollisionSide() == CollisionSide.TOP) {
						setY(vector.y - getHeight());
					}
					if (ct.getCollisionSide() == CollisionSide.LEFT) {
						setX(vector.x - getWidth());
					}

				} catch (TileNotFoundException e) {
					e.printStackTrace();

				}
			}
		}

	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		// TODO Auto-generated method stub

	}

	public float getDistance() {
		float d = app.dist(super.x, super.y, app.mouseX, app.mouseY);
		return d;
	}

}
