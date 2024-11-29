package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class gameoverscreen implements Screen {

    private Main game;
    Stage stage;
    private Texture background;
   //private Texture gameover ;


    public gameoverscreen(Main game) {
        this.game = game;
        game.music.pause();
    }

    @Override
    public void show() {
        background = new Texture("level.jpeg");
        //gameover =  new Texture("gameover.png");
        gameover gameover = new gameover(game,250,350,300,200) ;

        //quit = new quit(game) ;
        end end = new end(game) ;
        retry retry = new retry(game) ;

        stage = new Stage(game.viewport) ;
        Gdx.input.setInputProcessor(stage);
        game.music.play();
        stage.addActor(gameover);
        stage.addActor(end);
        stage.addActor(retry);

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

