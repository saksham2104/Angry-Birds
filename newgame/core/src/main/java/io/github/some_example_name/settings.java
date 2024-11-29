package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class settings implements Screen {
     Main game;
     Stage stage;

     Texture background ;
     vloume volume  ;
     back back ;
     Texture settings_banner ;

    public settings(Main game) {
        this.game = game;
    }

    @Override
    public void show() {

        stage = new Stage(game.viewport);

        Gdx.input.setInputProcessor(stage);
        background = new Texture("level.jpeg");
        settings_banner = new Texture("settings copy.png") ;
        volume = new vloume(game,482,252,85,85) ;
        back = new back(game, 214.00002F,250,85,85) ;

        stage.addActor(volume);
        stage.addActor(back);

    }

    @Override
    public void render(float v) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 600);

        game.batch.draw(settings_banner,271 , 353, 200, 200);
        game.batch.end();


        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();



    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        stage.dispose();
        game.batch.dispose();
    }
}
