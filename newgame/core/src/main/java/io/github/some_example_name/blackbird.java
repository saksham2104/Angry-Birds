package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;

public class blackbird extends Actor {
    float x ;
    float y ;
    String colour ;
    private Main game ;
    private Texture black ;
    World world ;
    Body body;


    public blackbird(Main game, float x, float y, String colour, World world){
        super() ;
        this.game = game ;
        this.x = x ;
        this.y = y ;
        this.colour = "black" ;
        black = new Texture("black_removed.png") ;
        this.world = world ;

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);



        CircleShape shape = new CircleShape();
        shape.setRadius(0.5f);

        FixtureDef  fixtublackef = new  FixtureDef ();
        fixtublackef.shape = shape;
        fixtublackef.density = 1.0f;
        fixtublackef.friction = 2.5f;
        fixtublackef.restitution = 0.6f;

        body = world.createBody(bodyDef);
        body.setUserData("bird");

        body.createFixture(fixtublackef);
        shape.dispose();

        setBounds((float)  x, (float) y ,50 , 50 );
        setTouchable(Touchable.enabled);


    }
    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(black, getX(), getY(), 50, 50);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        Vector2 position = body.getPosition();
        setPosition(position.x - getWidth() / 2, position.y - getHeight() / 2);

        float minX = 1.25f, maxX = 748.75f, minY = 97.5f, maxY = 558.75f;
        float constrainedX = MathUtils.clamp(position.x, minX, maxX);
        float constrainedY = MathUtils.clamp(position.y, minY, maxY);

        if (position.x != constrainedX || position.y != constrainedY) {
            body.setTransform(constrainedX, constrainedY, body.getAngle());
        }




    }



}
