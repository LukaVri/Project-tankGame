package tankGame;


import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
                                                                                                                                                                               


public class Tanks extends SpriteObject {
 
	private Main app;
	String sprite;
	Tanks(Main app, String sprite){
		
		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
	
		this.app = app;
		this.sprite = sprite;
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
	   


}
