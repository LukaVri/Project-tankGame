package tankGame;

public class levelselectKnop extends MenuKnop {

	levelselectKnop(float knopX, float knopY, String sprite, Main app) {
		super(knopX, knopY, sprite, app);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean ingedrukt() {
		if(app.mouseX  > this.knopX && app.mouseX < this.knopX + this.width && app.mouseY > this.knopY && app.mouseY < this.knopY + this.height) {
			
			if(!(app.world.worldType + 1 > app.world.amountOfTypes) ) {
			app.world.worldType += 1;
			
			}
			else {
				app.world.worldType = 1;
				
			}
			System.out.println(app.world.worldType);
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