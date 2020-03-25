package tankGame;

import java.util.ArrayList;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.tile.TileMap;
import nl.han.ica.oopg.tile.TileType;



public class WorldMaker {

	Main app;
	String groundSprite;
	int size;
	ArrayList<WorldObjects> blocks = new ArrayList<>();
	WorldMaker(int size,String groundSprite,Main app){
		this.size = size;
		this.app = app;
		
		
		
	}
	
	/*void createWorld() {
		for(int i =0; i < height;i ++) {
			for(int j =0; j < width; j ++) {
				WorldObjects obj = new WorldObjects(i + 8, j + 8, 20, "tile_earth.png", app);
				blocks.add(obj);
				app.addGameObject(obj,  j * 8, 600 - i * 8);
				
			}
			
			
		}
		
		
		
	}*/
	 void initializeTileMap() {
        // Load Sprites
        Sprite floorSprite = new Sprite(app.MEDIA_URL.concat("tile_earth.png"));
        // Create tile types with the right Tile class and sprite
        TileType<groundTiles> floorTileType = new TileType<>(groundTiles.class, floorSprite);

        TileType[] tileTypes = {floorTileType};
        int tileSize = 64;
        int tilesMap[][] = {
                {-1, -1, -1, -1, -1, -1, -1, },
                {-1, -1, -1, -1, -1, -1, -1, },
                {-1, -1, -1, -1, -1, -1, -1, },
                {-1, -1, -1, -1, -1, -1, -1, },
                {0, 0, 0, 0, 0, 0, 0, },
                {-1, -1, -1, -1, -1, -1, -1, },
                {-1, -1, -1, -1, -1, -1, -1, },
        };
        TileMap tileMap = new TileMap(tileSize, tileTypes, tilesMap);
    }
	
}
