package tankGame;


import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class explosion extends SpriteObject {
	Main app;
	float timer;
	float setter = 100;
	public explosion(Main app ) {
		super(new Sprite(Main.MEDIA_URL.concat("explosion.png")));
		this.app = app;
		timer = app.millis();
	}

	@Override
	public void update() {
	if(app.millis() > timer + setter ) {
		destroySelf();
		
	}
		
	}
	public void destroySelf() {
		app.deleteGameObject(this);
		
		
	}

}
