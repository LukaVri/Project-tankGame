package tankGame;

import java.util.ArrayList;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Menu extends SpriteObject {
String menuSprite;
boolean menuOpen;
Main app;
ArrayList<MenuKnop> knop = new ArrayList<>();
Menu(String menuSprite,Main app){
	super(new Sprite(Main.MEDIA_URL.concat(menuSprite)));
	this.app = app;
	
}
void maakKnoppen() {
	knop.add(new StartKnop(200,200,"start.png",app));
	app.addGameObject(knop.get(0),200,200);
	knop.add( new levelselectKnop(300,200,"select.png",app));
	app.addGameObject(knop.get(1),300,200);
	
}
@Override
public void update() {
	
	
}
void destroyKnoppen() {
	app.deleteGameObject(knop.get(0));
	app.deleteGameObject(knop.get(1));
	
}
public MenuKnop getKnop(int welke) {
	return knop.get(welke);
}

public ArrayList<MenuKnop> getK() {
	return knop;
}




}
