package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;


public class setting_stage extends Actor {
    private Main game ;
    private Texture setting ;
    float x ;
    float y ;
    float width ;
    float height ;

    
    public setting_stage(Main game , float x , float y , float width ,  float height ) {
        this.game = game ;
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;

        setting = new Texture(Gdx.files.internal("settings.png"));
        setBounds((float)  x, (float) y ,width , height );
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new settings(game));
                return true;
            }
        }); }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        
        batch.draw(setting, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }









}
