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


public class level3_structure extends Actor {
    private Main game ;
    private final Texture structure ;
    float x ;
    float y ;
    float width ;
    float height ;

   
    public level3_structure(Main game , float x , float y , float width ,  float height ) {
        this.game = game ;
        this.x = x ;
        this.y = y ;
        this.width = width ;
        this.height = height ;

        structure = new Texture(Gdx.files.internal("level1_structure.png"));
        setBounds((float)  x, (float) y ,width , height );
        setTouchable(Touchable.enabled);

         }




    @Override
    public void draw(Batch batch, float parentAlpha) {
    batch.draw(structure, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);


    }









}
