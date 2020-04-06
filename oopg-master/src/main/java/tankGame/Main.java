package tankGame;


import nl.han.ica.oopg.engine.GameEngine;

import nl.han.ica.oopg.view.View;

@SuppressWarnings("serial")
public class Main extends GameEngine {
	private Tanks player1;
	private Tanks player2;
	private boolean player1Turn = true;
	
	
	private ScoreBoard scores;
	private UserInterface healthP1;
	private UserInterface healthP2;
	
	private boolean menuOpened = false;
	private boolean worldLoaded = false;
	private mouseHandler handler = new mouseHandler(this);
	private WorldMaker world = new WorldMaker(60, "tile_earth.png", this);
	private Menu mainMenu = new Menu("menu.png", this);
	private BulletSelector sel = new BulletSelector(this);
	
	private Aanwijzer pijl = new Aanwijzer ("turnArrow.png",this);

	public static String MEDIA_URL = "src/main/java/tankGame/sprites/";

	public static void main(String[] args) {
		Main m = new Main();
		m.runSketch();
	}

	@Override
	public void setupGame() {
		player1 = new Tanks(this, "tankGroen.png", 1, 100, 270);
		player2 = new Tanks(this, "tankBlauw.png", 2, 200, 270);
		scores = new ScoreBoard("1:0", 20);
		healthP1 = new UserInterface("100", 20, this, "player 1 HP: ");
		healthP2 = new UserInterface("100", 20, this, "player 2 HP: ");
		mainMenu.menuOpen = true;

		int worldWidth = 500;
		int worldHeight = 500;
		addGameObject(pijl);
		addGameObject(handler);
		addGameObject(sel);
		View view = new View(worldWidth, worldHeight);

		setView(view);
		size(worldWidth, worldHeight);
	}

	

	@Override
	public void update() {
		healthP1.displayHealth(player1);
		healthP2.displayHealth(player2);

		if (worldLoaded == true) {
		}
		if (mainMenu.menuOpen && menuOpened == false) {
			addGameObject(mainMenu, 0, 0);
			mainMenu.maakMenu();

			menuOpened = true;

		}
		if (!mainMenu.menuOpen && menuOpened == true) {
			mainMenu.destroyMenu();
			deleteGameObject(mainMenu);

			if (worldLoaded == false) {
				loadGame();
				worldLoaded = true;
			}
			menuOpened = false;
			
		}

	}

	
	void loadGame() {
		world.initializeTileMap();

		addGameObject(player1, player1.getxPos(), player1.getyPos());
		addGameObject(player2, player2.getxPos(), player2.getyPos());
		addGameObject(scores, width/2, 20);
		addGameObject(healthP1, 0, 0);
		addGameObject(healthP2, 330, 0);

	}

	public Tanks getPlayer1() {
		return player1;
	}

	public Tanks getPlayer2() {
		return player2;
	}

	public Menu getMainMenu() {
		return mainMenu;
	}
	
	public ScoreBoard getScoreBoard() {
		return scores;
	}

	public boolean getMenuOpened() {
		return menuOpened;
	}

	public void setMenuOpened(boolean menuOpened) {
		this.menuOpened = menuOpened;
	}

	public WorldMaker getWorld() {
		return world;
	}

	public ScoreBoard getScores() {
		return scores;
	}
	public Aanwijzer getPijl() {
		return pijl;
	}

	public boolean isPlayer1Turn() {
		return player1Turn;
	}

	public void setPlayer1Turn(boolean player1Turn) {
		this.player1Turn = player1Turn;
	}
	

}
