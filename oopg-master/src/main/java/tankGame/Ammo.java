package tankGame;

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

public class Ammo extends SpriteObject implements ICollidableWithTiles {
	Main app;
	String sprite;
	int size;
	int direction;
	int type;
	float speed;
	float angle;
	int bounced;

	Ammo(float angle, int type, int direction, Main app, String sprite, float speed) {

		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
		this.angle = angle;
		this.type = type;
		this.direction = direction;
		this.app = app;
		this.sprite = sprite;
		this.speed = speed;
		setGravity(0.1f);
		setFriction(0.1f);

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof groundTiles) {
				try {

					vector = app.getTileMap().getTilePixelLocation(ct.getTile());

					if (this.type != 2 || this.bounced > 2) {
						app.deleteGameObject(this);
					}
					if (this.type == 2 && this.bounced < 3) {
						this.bounced++;
						this.y = this.y - 5;
						if (this.angle < 180) {
							this.angle = 45;
						}
						if (this.angle > 180) {
							this.angle = 315;
						}
					}
				}

				catch (TileNotFoundException e) {
					e.printStackTrace();

				}
			}
		}

	}

	@Override
	public void update() {

		float power = 6 - this.speed;
		setDirectionSpeed(this.angle, speed);
		if (this.angle < 150) {
			this.angle = this.angle + power;
		}
		if (this.angle >= 240) {
			this.angle = this.angle - power;
		}
		if (this.type == 3) {
			if (this.angle >= 150 && this.angle <= 240) {
				if (this.y > 50) {
					Ammo a = new Ammo(135, 1, 1, app, "bullet.png", power);
					app.addGameObject(a, this.x, this.y);
					Ammo b = new Ammo(180, 1, 1, app, "bullet.png", power);
					app.addGameObject(b, this.x, this.y);
					Ammo c = new Ammo(225, 1, 1, app, "bullet.png", power);
					app.addGameObject(c, this.x, this.y);
					app.deleteGameObject(this);
				}
			}
		}
		if (this.type == 4) {

		}
	}

	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {

		for (GameObject go : collidedGameObjects) {
			if (go instanceof Tanks) {

				app.deleteGameObject(this);

			}
		}

	}
}
