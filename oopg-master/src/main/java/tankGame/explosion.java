package tankGame;

import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class explosion extends AnimatedSpriteObject {
	Main app;
	
	public explosion(Main app ) {
		super(new Sprite(Main.MEDIA_URL.concat("gif/explosion.gif")), 5);
		this.app = app;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
