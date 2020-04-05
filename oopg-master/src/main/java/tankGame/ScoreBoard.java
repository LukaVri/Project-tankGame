package tankGame;

import nl.han.ica.oopg.objects.TextObject;

public class ScoreBoard extends TextObject {
	int player1Score = 0;
	int player2Score = 0;

	public ScoreBoard(String text, int fontSize) {
		super(text, fontSize);
		this.setForeColor(255, 255, 255, 255);
	}

	void addScorePlayer1(int score) {
		player1Score += score;
	}

	void addScorePlayer2(int score) {
		player2Score += score;
	}

	void displayScore() {
		this.setText(Integer.toString(this.player1Score) + ":" + Integer.toString(this.player2Score));

	}
	
	public void update() {
		this.displayScore();
	}
}
