package tankGame;

import javazoom.jl.player.Player;
import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;
public class Main  extends GameEngine {
	private Tanks player1;
	private Tanks player2;
	private WorldMaker world = new WorldMaker(80,45,this);
	
	public static String MEDIA_URL = "src/main/java/tankGame/sprites/"; 
	public static void main(String[] args) {
 Main m = new Main();
 m.runSketch();
 //TEster
	}
	
	@Override
    public void setupGame() {
        int worldWidth = 500;
        int worldHeight = 500;
        world.createWorld();
       
        player1 = new Tanks(this,"tankGroen.png");
        addGameObject(player1, 200, 200);
        player2 = new Tanks(this,"tankBlauw.png");
        addGameObject(player2, 400, 200);
        
        View view = new View(worldWidth, worldHeight);

        setView(view);
        size(worldWidth, worldHeight);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
