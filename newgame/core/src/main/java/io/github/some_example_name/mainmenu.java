//main menu class
package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class mainmenu implements Screen {
    final Main game;
    Stage stage;
    Texture mainmenu;

    public mainmenu(Main game) {
        this.game = game;
    }

    @Override
    public void show() {

        stage = new Stage(game.viewport);

        Gdx.input.setInputProcessor(stage);
        mainmenu = new Texture("angry bird 1.png");

        playbuuton play = new playbuuton(game);
        exit exit = new exit(game);
        stage.addActor(exit);
        stage.addActor(play);
    }

    @Override
    public void render(float v) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        game.music.play();

        game.batch.begin();
        game.batch.draw(mainmenu, 0, 0, 800, 600);
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
        mainmenu.dispose();
        game.batch.dispose();
    }
}
