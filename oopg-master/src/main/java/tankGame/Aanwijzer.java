package tankGame;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class Aanwijzer extends SpriteObject {
	Main app;
	public Aanwijzer(String sprite,Main app) {
		super(new Sprite(Main.MEDIA_URL.concat(sprite)));
		this.app = app;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void destroySelf() {
		app.deleteGameObject(this);
		
		
	}

}
