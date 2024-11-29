package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class levels implements Screen {

    private Main game;
    Stage stage;
    private Texture background;
    quit quit ;


    public levels(Main game) {
        this.game = game;
        game.music.pause();
    }

    @Override
    public void show() {
        background = new Texture("level_background.png");
        level1 level1 = new level1(game) ;
        level2 level2 = new level2(game) ;
        level3 level3 = new level3(game) ;
        quit = new quit(game) ;

        stage = new Stage(game.viewport) ;
        Gdx.input.setInputProcessor(stage);
        game.music.play();
        stage.addActor(level1);
        stage.addActor(level2);
        stage.addActor(level3);
        stage.addActor(quit);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 600);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();



    }

    @Override
    public void resize(int width, int height) {
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
        game.batch.dispose();
        background.dispose();

        stage.dispose();
    }
}

