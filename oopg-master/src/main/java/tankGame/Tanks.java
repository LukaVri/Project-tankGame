package tankGame;


import java.util.List;

import nl.han.ica.oopg.collision.CollidedTile;
import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.collision.ICollidableWithTiles;
import nl.han.ica.oopg.exceptions.TileNotFoundException;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import processing.core.PVector;
                                                                                                                                                                          


public class Tanks extends SpriteObject
implements ICollidableWithTiles
{
	
	private Main app;
	String sprite;
	
	
	Tanks(Main app, String sprite){
		
		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
	
		this.app = app;
		this.sprite = sprite;
		setGravity(0.01f);
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	   @Override
	    public void keyPressed(int keyCode, char key) {
		   if (keyCode == app.LEFT) {
			   setDirectionSpeed(270, 5);
		        }
		   
	    }
	   public void keyReleased(int keyCode,char key) {
		   if (keyCode == app.LEFT) {
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
	                    setY(vector.y - getHeight());
	                } catch (TileNotFoundException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	      
	    }

		
	   


}
