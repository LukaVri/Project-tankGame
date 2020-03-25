package tankGame;

import nl.han.ica.oopg.objects.TextObject;

public class ScoreBoard extends TextObject{

	public ScoreBoard(String text, int fontSize) {
		super(text, fontSize);
		this.setForeColor(255, 255, 255, 255);
	}

}
