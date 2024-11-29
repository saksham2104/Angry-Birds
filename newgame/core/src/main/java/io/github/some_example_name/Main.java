package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
/**%20%7B@link%20com.badlogic.gdx.ApplicationListener%7D%20implementation%20shared%20by%20all%20platforms.%20*/
//Main class
public class Main extends Game {
    public  SpriteBatch batch;
    public Viewport viewport;
    static float PPM= 2.22f;
    public OrthographicCamera camera;
    public Music music;


    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera() ;
        viewport = new FitViewport(800, 600 , camera);
        viewport.apply();
        setScreen(new mainmenu(this));

        camera.position.set( 400, 300 , 0);
        music=music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
    }


    @Override
    public void render(){
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
