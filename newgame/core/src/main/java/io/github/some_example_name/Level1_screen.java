package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;
import java.util.List;

import static io.github.some_example_name.Main.PPM;

public class Level1_screen implements Screen {
    private Main game;
    private Stage stage;
    private Texture mainmenu;
    private World world;

   // private CollisionHandler collisionHandler;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;

    // Game objects
    private redbird red;
    private blackbird black;
    private yellowbird yellow;
    private wood wood, wood_2, wood_3, wood_4, wood_5, wood_6;
    private pig pig_1, pig_3, pig_5;
    private slingshot slingshot;
    private setting_stage setting;
    private Hud hud;

    private List<Body> birds = new ArrayList<>();
    private ContactListener contactListener;

    public Level1_screen(Main game) {
        this.game = game;
        camera = new OrthographicCamera(800f / 100f, 600f / 100f);
        camera.position.set(400f / 100f, 300f / 100f, 0);

        // Create world with gravity
        world = new World(new Vector2(0, -9.8f), true);


        // Create debug renderer
        debugRenderer = new Box2DDebugRenderer();

        // Create ground
        createGround();


        contactListener = new CollisionHandler(world);

        // Set the contact listener for the world
        world.setContactListener(contactListener);


        // Create stage
        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);

        hud = new Hud(game.batch);

        // Load background
        mainmenu = new Texture("level.jpeg");

        // Initialize game objects
        {
            // Initialize birds
            red = new redbird(game, 119F, 83F, "red", world);
            yellow = new yellowbird(game, 66F, 83.999985F, "yellow", world);
            black = new blackbird(game, 10F, 82F, "black", world);

            birds.add(red.body);
            birds.add(yellow.body);
            birds.add(black.body);

            // Initialize slingshot with world and birds
            slingshot = new slingshot(game, world, birds, 161.00002F, 84.999985F, 45, 80);

            // Initialize setting button
            setting = new setting_stage(game, 730, 532.5F, 70, 70);

            // Initialize wood blocks and pigs
            wood = new wood(game, 578, 206, 85, 25, 100, "horizontal_wood", world);
            wood_2 = new wood(game, 607, 73, 25, 150, 100, "straight_wood", world);
            pig_1 = new pig(game, 589, 228, 50, 50, 100, world);

            wood_3 = new wood(game, 719F, 125.999985F, 50, 15, 100, "horizontal_wood", world);
            wood_4 = new wood(game, 731, 82, 25, 50, 100, "straight_wood", world);
            pig_3 = new pig(game, 726, 137.00002F, 35, 35, 100, world);

            wood_5 = new wood(game, 480F, 124.999985F, 50, 15, 100, "horizontal_wood", world);
            wood_6 = new wood(game, 492, 81, 25, 50, 100, "straight_wood", world);
            pig_5 = new pig(game, 487, 136.00002F, 35, 35, 100, world);
        }

        // Stop music
        game.music.stop();

        // Add actors to the stage
        stage.addActor(slingshot);
        stage.addActor(yellow);
        stage.addActor(black);
        stage.addActor(red);
        stage.addActor(wood);
        stage.addActor(wood_2);
        stage.addActor(pig_1);
        stage.addActor(wood_3);
        stage.addActor(wood_4);
        stage.addActor(pig_3);
        stage.addActor(wood_5);
        stage.addActor(wood_6);
        stage.addActor(pig_5);
        stage.addActor(setting);
        stage.addActor(hud.scoreLabel);

    }

    @Override
    public void show() {
        // Create camera

    }

    @Override
    public void render(float delta) {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Step the physics simulation
        world.step(1 / 60f, 6, 2);
        debugRenderer.render(world, camera.combined);
        //collisionHandler.cleanupBodies(world);

        // Render the main menu background
        game.batch.begin();
        game.batch.draw(mainmenu, 0, 0, 800, 600);
        game.batch.end();

        // Update and render the stage
        stage.act(delta);
        stage.draw();

        // Render the HUD (score and other UI elements)
        hud.stage.act(delta); // Update HUD if needed
        hud.stage.draw(); // Render the score label and other HUD components

        // Render debug physics
        camera.update();
        debugRenderer.render(world, camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
        mainmenu.dispose();
        game.batch.dispose();
        world.dispose();
        debugRenderer.dispose();
    }

    private void createGround() {
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.position.set(400f , 60f); //divide by angrybirds PPM
        groundBodyDef.type = BodyDef.BodyType.StaticBody;

        Body groundBody = world.createBody(groundBodyDef);

        PolygonShape groundShape = new PolygonShape();
        groundShape.setAsBox(400f, 10f );

        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.shape = groundShape;
        groundFixtureDef.friction = 0.7f;
        groundFixtureDef.restitution = 0.1f;

        groundBody.createFixture(groundFixtureDef);
        groundBody.setUserData("ground");

        groundShape.dispose();
    }
}
