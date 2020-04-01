package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public abstract class MenuKnop extends SpriteObject {
int knopSize;
float knopX;
float knopY;
String sprite;
MenuKnop(int knopSize,float knopX,float knopY,String sprite){
	super(new Sprite(Main.MEDIA_URL.concat(sprite)));
	this.knopX = knopX;
	this.knopY = knopY;
	this.knopSize = knopSize;
	
	
}

abstract void ingedrukt ();
}
