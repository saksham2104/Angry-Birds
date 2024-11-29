package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class retry extends Actor {
    private Main game ;
    private final Texture ex;


    public retry(Main game) {
        this.game =game ;
        ex = new Texture("retry.png");
        setBounds((float)200, (float) 300 ,100 , 100 );
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new levels(game));
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(ex, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
}