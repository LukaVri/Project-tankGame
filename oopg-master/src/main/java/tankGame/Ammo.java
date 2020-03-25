package tankGame;

import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;

public class Ammo extends SpriteObject implements ICollidableWithTiles {
	Main app;
	String sprite;
	int size;
	int direction;
	int type;

	Ammo(int type, int direction, Main app, String sprite) {

		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
		this.type = type;
		this.direction = direction;
		this.app = app;
		this.sprite = sprite;
		setGravity(0.01f);
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof groundTiles) {
				try {
					vector = app.getTileMap().getTilePixelLocation(ct.getTile());
					setY(vector.y - getHeight());
				} catch (TileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update() {
		setDirectionSpeed(270, -5);		
	}
}
