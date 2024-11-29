package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;

import java.util.ArrayList;
import java.util.List;

public class slingshot extends Actor {
    private Main game;
    private World world;
    private Texture slingShotTexture;
    private float x, y, width, height;

    private List<Body> birds; // List of bird bodies
    private int index; // Index of the current bird to launch

    private Vector2 startPosition;

    // Updated constructor to match your game setup
    public slingshot(Main game, World world, List<Body> birds, float x, float y, float width, float height) {
        this.game = game;
        this.world = world;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Initialize bird bodies list
        this.birds = new ArrayList<>(birds);
        this.index = 0;

        slingShotTexture = new Texture(Gdx.files.internal("slingshot_remove.png"));
        setBounds(x, y, width, height);
        setTouchable(Touchable.enabled);

        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (index < 3) {
                    startPosition = new Vector2(x, y).add(getX(), getY()); // Local to world
                }
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if (index < 3) {
                    Body currentBirdBody = birds.get(index);
                    Vector2 endPosition = new Vector2(x, y).add(getX(), getY()); // Local to world
                    Vector2 force = startPosition.sub(endPosition).scl(10f);


                    if (currentBirdBody != null) {
                        currentBirdBody.applyLinearImpulse(force, currentBirdBody.getWorldCenter(), true);
                        index++;
                    }
                }
                else{
                    game.setScreen(new gameoverscreen(game));
                }

            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(slingShotTexture, getX(), getY(), getWidth(), getHeight());
    }
}
