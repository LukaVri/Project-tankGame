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

public class Tanks extends SpriteObject implements ICollidableWithTiles {

	private Main app;
	String sprite;
	int player;
	float xPos;
	float yPos;
	boolean clicked;
	int health = 100;
	//Ammo
	String ammoSprite = "bullet.png";
	int selectedType = 1;
	ArrayList<Ammo> ammo = new ArrayList<>();
	int amountOfBounce = 8,amountOfScatter = 4,AmountOfBomb = 1;

	Tanks(Main app, String sprite, int player, float xPos, float yPos) {

		super(new Sprite(Main.MEDIA_URL.concat(sprite)));

		this.app = app;
		this.sprite = sprite;
		this.player = player;
		this.xPos = xPos;
		this.yPos = yPos;		
		setGravity(0.01f);
		setFriction(0.01f);
	}

	@Override
	public void update() {
		checkHealth();
		checkTurn();
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		if (keyCode == app.LEFT && player == 1 && app.player1Turn == true
				|| key == 'a' && player == 2 && app.player1Turn == false) {
			setDirectionSpeed(270, 5);
			app.player1Turn = !app.player1Turn;
		}
		if (keyCode == app.RIGHT && player == 1 && app.player1Turn == true
				|| key == 'd' && player == 2 && app.player1Turn == false) {
			setDirectionSpeed(270, -5);
			app.player1Turn = !app.player1Turn;
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
		if(selectedType == 1|| selectedType ==2 && amountOfBounce > 0 || selectedType == 3 && amountOfScatter > 0 || selectedType == 4 && AmountOfBomb > 0) {
		float range = 0;
		if (getAngleFrom(app.mouseX, app.mouseY) > 270 || getAngleFrom(app.mouseX, app.mouseY) < 90) {
			if (getDistance() < 100 && getDistance() > 20) {
				range = getDistance();
			}
			else if (getDistance() <= 20) {
				range = 20;
			}
			else if(getDistance() >= 100) {
				range = 100;
			}
			
				Ammo a = new Ammo(getAngleFrom(app.mouseX, app.mouseY) + randomNumber(-10, 10), selectedType, 1, app,
						ammoSprite, range / 20, this);
				switch(selectedType) {
				case 1:
					//Nothing
					break;
				
				case 2:
					amountOfBounce -=1;
					break;
				case 3:
					amountOfScatter -=1;
					break;
				case 4:
					AmountOfBomb -=1;
					break;
				
				
				}
				ammo.add(a);
				app.addGameObject(a, super.x, super.y);

		}
		}
	}

	void damage(float damageDone) {
		this.health -= damageDone;
		System.out.println(this.health);

	}

	void checkHealth() {
		if (health <= 0) {
			if (player == 1) {
				app.getScoreBoard().addScorePlayer2(1);
				
				
			}
			if (player == 2) {
				app.getScoreBoard().addScorePlayer1(1);
			}
			this.health = 100;
			explosion explosionSprite = new explosion(app);
			app.addGameObject(explosionSprite,this.getX(),this.getY());
			app.deleteGameObject(this);
			respawn();
		}

	}
	void checkTurn() {
		if(player == 1 && app.player1Turn == true || player == 2 && app.player1Turn == false) {
			 
			app.getPijl().setX(this.xPos);
			app.getPijl().setY(this.yPos);
		}
		
		
		
		
	}
	void respawn() {
		app.addGameObject(this,xPos,yPos - 50);
		
		
	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {

		PVector vector;
		for (CollidedTile ct : collidedTiles) {
			if (ct.getTile() instanceof groundTiles) {

				try {

					if (ct.getCollisionSide() == CollisionSide.RIGHT) {
						vector = app.getTileMap().getTilePixelLocation(ct.getTile());
						this.setX(vector.x + this.getWidth());
					}
					if (ct.getCollisionSide() == CollisionSide.TOP) {
						vector = app.getTileMap().getTilePixelLocation(ct.getTile());
						this.setY(vector.y - this.getHeight());

					}
					if (ct.getCollisionSide() == CollisionSide.LEFT) {
						vector = app.getTileMap().getTilePixelLocation(ct.getTile());
						this.setX(vector.x - this.getWidth());
					}

				} catch (TileNotFoundException e) {
					e.printStackTrace();

				}
			}
		}

	}

	private float getDistance() {
		float d = app.dist(super.x, super.y, app.mouseX, app.mouseY);
		return d;
	}

	private float randomNumber(float min, float max) {
		float randomNum = (float) Math.random() * (max - min + 1) + min;
		return randomNum;
	}

	public String getAmmoSprite() {
		return ammoSprite;
	}

	public void setAmmoSprite(String ammoSprite) {
		this.ammoSprite = ammoSprite;
	}

	public int getSelectedType() {
		return selectedType;
	}

	public void setSelectedType(int selectedType) {
		this.selectedType = selectedType;
	}

	

}
