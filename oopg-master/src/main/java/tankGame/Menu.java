package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Menu extends SpriteObject {
String menuSprite;
boolean menuOpen;
Main app;
StartKnop start;
levelselectKnop select;
Menu(String menuSprite,Main app){
	super(new Sprite(Main.MEDIA_URL.concat(menuSprite)));
	this.app = app;
	start = new StartKnop(200,200,"start.png",app);
	select = new levelselectKnop(300,200,"select.png",app);
	
}
void maakKnoppen() {
	app.addGameObject(start,start.knopX,start.knopY);
	app.addGameObject(select,select.knopX,select.knopY);
	
}
@Override
public void update() {
	
	
}
public StartKnop getStart() {
	return start;
}
public levelselectKnop getSelect() {
	return select;
}
void destroyKnoppen() {
	app.deleteGameObject(start);
	app.deleteGameObject(select);
	
}


}
