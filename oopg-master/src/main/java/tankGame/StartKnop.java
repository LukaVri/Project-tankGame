package tankGame;

public class StartKnop extends MenuKnop {

	
	StartKnop( int knopX,int knopY,String knopSprite,Main app) {
		super( knopX,knopY,knopSprite,app);
		
	}
	@Override
	boolean ingedrukt() {
		Menu menu = app.getMainMenu();
		if(app.mouseX  > this.knopX && app.mouseX < this.knopX + this.width && app.mouseY > this.knopY && app.mouseY < this.knopY + this.height) {
			menu.setMenuOpen(false);
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
