package tankGame;

import javazoom.jl.player.Player;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;
import nl.han.ica.oopg.view.View;
@SuppressWarnings("serial")
public class Main  extends GameEngine {
	public  Tanks player1;
	public Tanks player2;
	boolean player1Turn = true;
	private ScoreBoard scores;
	boolean menuOpened = false;
	boolean worldLoaded = false;
	private mouseHandler handler = new mouseHandler(this);
	public  WorldMaker world = new WorldMaker(60,"tile_earth.png",this);
	int scorePlayer1 =0;
	int scorePlayer2 =0;
	Menu mainMenu = new Menu("menu.png", this);
	public static String MEDIA_URL = "src/main/java/tankGame/sprites/"; 
	public static void main(String[] args) {
 Main m = new Main();
 m.runSketch();
	}
	
	@Override
    public void setupGame() {
		player1 = new Tanks(this,"tankGroen.png",1,100,100);
		player2 = new Tanks(this,"tankBlauw.png",2,200,100);
		mainMenu.menuOpen = true;
		
		
        int worldWidth = 500;
        int worldHeight = 500;
        
        addGameObject(handler);
       
        View view = new View(worldWidth, worldHeight);

        setView(view);
        size(worldWidth, worldHeight);
    }

	@Override
	public void update() {
		if(worldLoaded == true) {
		scores.setText(Integer.toString(scorePlayer1) +":"+ Integer.toString(scorePlayer2));
		}
		if(mainMenu.menuOpen && menuOpened == false) {
			 addGameObject(mainMenu,0,0);
			 mainMenu.maakKnoppen();
			 
			menuOpened = true;
			
		}
		if(!mainMenu.menuOpen && menuOpened == true) {
			 mainMenu.destroyKnoppen();
			 deleteGameObject(mainMenu);
			 
			 if(worldLoaded == false) {
			 loadGame();
			 worldLoaded = true;
			 }
			menuOpened = false;
			
		}
		
	}
	void loadGame() {
		    world.initializeTileMap();
		    
	        addGameObject(player1, player1.xPos, player1.yPos);
	        
	        addGameObject(player2, player2.xPos, player2.yPos);
	        scores = new ScoreBoard("1:0", 20);
	        addGameObject(scores,50,100);
		
		
		
	}
	
	
	

}
