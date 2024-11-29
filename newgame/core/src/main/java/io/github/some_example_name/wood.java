package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.Objects;

public class wood extends Actor {
    private Main game;
    private Texture woodx;
    float x;
    float y;
    float width;
    float height;
    int health;
    String type;
    World world;
    Body body;

    public wood(Main game, float x, float y, float width, float height, int health, String type, World world) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.type = type;
        this.world = world;

        if (Objects.equals(type, "horizontal_wood")) {
            woodx = new Texture("horizontal_wood.png");
        } else {
            woodx = new Texture("straight_wooden.png");
        }

        setBounds(x, y, width, height);
        setTouchable(Touchable.enabled);

        woodbody();
    }

    private void woodbody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x + width / 2, y + height / 2);
        bodyDef.linearDamping = 0.5f;
        bodyDef.angularDamping = 0.5f;

        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2, height / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.5f;  // You can keep the density
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;

        body.createFixture(fixtureDef);
        body.setUserData(this); // or "pig" for pig objects

        shape.dispose();

       // body.setUserData(this);  // Add this line at the end of createPhysicsBody()
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(woodx, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        // Update actor position based on body position
        Vector2 position = body.getPosition();
        setPosition(position.x - getWidth() / 2, position.y - getHeight() / 2);
    }

    public Body getBody() {
        return body;
    }

}

