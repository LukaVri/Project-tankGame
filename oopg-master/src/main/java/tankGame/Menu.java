package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Menu extends SpriteObject {
String menuSprite;
boolean menuOpen;
Main app;
StartKnop start;
Menu(String menuSprite,Main app){
	super(new Sprite(Main.MEDIA_URL.concat(menuSprite)));
	this.app = app;
	start = new StartKnop(200,200,"start.png",app);
	
	
}
void maakKnoppen() {
	app.addGameObject(start,start.knopX,start.knopY);
	
	
}
@Override
public void update() {
	
	
}


}
