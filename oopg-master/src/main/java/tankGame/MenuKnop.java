package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public abstract class MenuKnop extends SpriteObject {
 float knopX;
 float knopY;
 String sprite;
 Main app;
MenuKnop(float knopX,float knopY,String sprite,Main app){
	super(new Sprite(Main.MEDIA_URL.concat(sprite)));
	this.knopX = knopX;
	this.knopY = knopY;
	this.app = app;
	
	
}

abstract boolean ingedrukt ();
}
