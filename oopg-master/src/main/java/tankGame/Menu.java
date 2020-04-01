package tankGame;

public class Menu {
String menuSprite;
boolean menuOpen;
Main app;
StartKnop start = new StartKnop(50,20,20,"start.png");
Menu(String menuSprite,Main app){
	this.app = app;
	
	
	
}
void maakKnoppen() {
	app.addGameObject(start,start.knopX,start.knopY);
	
	
}

}
