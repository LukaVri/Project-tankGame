package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public  class WorldObjects extends SpriteObject {
	float xPos;
	float yPos;
	int size;
	Main app;
	String sprite;
	WorldObjects(float xPos,float yPos,int size,String sprite,Main app){
		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.app = app;
		this.sprite = sprite;
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
