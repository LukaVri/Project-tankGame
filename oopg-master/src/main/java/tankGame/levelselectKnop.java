package tankGame;

public class levelselectKnop extends MenuKnop {

	levelselectKnop(float knopX, float knopY, String sprite, Main app) {
		super(knopX, knopY, sprite, app);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean ingedrukt() {
		WorldMaker world = app.getWorld();
		Menu menu = app.getMainMenu();
		if(app.mouseX  > this.knopX && app.mouseX < this.knopX + this.width && app.mouseY > this.knopY && app.mouseY < this.knopY + this.height) {
			if(!(app.getWorld().getWorldType() + 1 > world.getAmountOfTypes()) ) {
			world.setWorldType(world.getWorldType() + 1);
			}
			else {
				world.setWorldType(1);
				
			}
			System.out.println(world.getWorldType());
			menu.getLevelName().displayLevelName(world.getWorldType());
			return true;
			
			
		}
		else {
			return false;
			
			
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
