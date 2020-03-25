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
                                                                                                                                                                          


public class Tanks extends SpriteObject
implements ICollidableWithTiles,ICollidableWithGameObjects
{
	
	private Main app;
	String sprite;
	int player;
	ArrayList<Ammo> ammo = new ArrayList<>();
	
	
	Tanks(Main app, String sprite,int player){
		
		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
	
		this.app = app;
		this.sprite = sprite;
		this.player = player;
		setGravity(0.01f);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	   @Override
	    public void keyPressed(int keyCode, char key) {
		   if (keyCode == app.LEFT && player == 1 && app.player1Turn == true|| key == 'a'&& player == 2&& app.player1Turn == false) {
			   setDirectionSpeed(270, 5);
			   app.player1Turn = ! app.player1Turn;
		        }
		   if (keyCode == app.RIGHT && player == 1 && app.player1Turn == true || key == 'd'&& player == 2&& app.player1Turn == false) {
			   setDirectionSpeed(270, -5);
			   app.player1Turn = ! app.player1Turn;
		        }
		   if(key == 'r' && player == 1 && app.player1Turn == true ||key == 'p' && player == 2&& app.player1Turn == false) {
			   Ammo a = new Ammo(20, 1, app, "bullet.png");
			   ammo.add(a);
			   app.addGameObject(a, super.x, super.y);
			   app.player1Turn = ! app.player1Turn;
		   }
		   
	    }
	   public void keyReleased(int keyCode,char key) {
		   if (keyCode == app.LEFT && player == 1 || key == 'a'&& player == 2 ) {
			   setDirectionSpeed(0,0);
		        }
		   if (keyCode == app.RIGHT && player == 1 ||key == 'd'&& player == 2) {
			   setDirectionSpeed(0, 0);
		        }
		   
		   
	   }
	   @Override
	    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		   
	        PVector vector;
	        for (CollidedTile ct : collidedTiles) {
	            if (ct.getTile() instanceof groundTiles) {
	            	
	                try {	
	                	
	                    vector = app.getTileMap().getTilePixelLocation(ct.getTile());
	                  if( ct.getCollisionSide() == CollisionSide.RIGHT) {
	                	  setX(vector.x + getWidth());
	                  }
	                  if(ct.getCollisionSide() == CollisionSide.TOP) {
	                    setY(vector.y - getHeight());}
	                  if( ct.getCollisionSide() == CollisionSide.LEFT) {
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

		
	   


}
