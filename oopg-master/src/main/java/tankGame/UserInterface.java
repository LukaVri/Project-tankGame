package tankGame;

import nl.han.ica.oopg.objects.TextObject;

public class UserInterface extends TextObject {
	private int health = 100;
	
	Main app;
	String name;

	public UserInterface(String text, int fontSize, Main app, String name) {
		super(text, fontSize);
		this.setForeColor(255, 255, 255, 255);
		this.app = app;
		this.name = name;
	}

	public void displayHealth(Tanks player) {
		setText(name +Integer.toString(player.getHealth()));
		
	}
	
	public void displayLevelName(int number) {
		setText(name + Integer.toString(number));
	}
}
