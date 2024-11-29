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

public class level2_screen implements Screen {
    private Main game;
    private Stage stage;
    private Texture mainmenu;
    private World world;
    //private Array<Body> bodiesToRemove;
    // private CollisionHandler collisionHandler;
    private Box2DDebugRenderer debugRenderer;
    private OrthographicCamera camera;
    private Hud hud;

    // Game objects
    private redbird red;
    private blackbird black;
    private yellowbird yellow;
    private wood wood, wood_2, wood_3, wood_4, wood_5;
    private pig pig_1, pig_3, pig_5;
    private slingshot slingshot;
    private setting_stage setting;

    private List<Body> birds = new ArrayList<>();

    public level2_screen(Main game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Create camera
        camera = new OrthographicCamera(800f / 100f, 600f / 100f);
        camera.position.set(400f / 100f, 300f / 100f, 0);

        // Create world with gravity
        world = new World(new Vector2(0, -9.8f), true);
        // bodiesToRemove = new Array<>();

        // Create debug renderer
        debugRenderer = new Box2DDebugRenderer();

        // Create ground
        createGround();

        // Attach collision handler to the world
//        collisionHandler = new CollisionHandler();
//        world.setContactListener(collisionHandler);
        hud = new Hud(game.batch);
        // Create stage
        stage = new Stage(game.viewport);
        Gdx.input.setInputProcessor(stage);

        // Load background
        mainmenu = new Texture("level.jpeg");

        // Initialize game objects
        initializeGameObjects();

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
        //stage.addActor(wood_6);
      //  stage.addActor(pig_5);
        stage.addActor(setting);
        stage.addActor(hud.scoreLabel);
    }


private void initializeGameObjects() {
    // Initialize birds
    red = new redbird(game, 119F, 83F, "red", world);
    yellow = new yellowbird(game, 66F, 83.999985F, "yellow", world);
    black = new blackbird(game, 10F, 82F, "black", world);

    birds.add(red.body);
    birds.add(yellow.body);
    birds.add(black.body);


    slingshot = new slingshot(game, this.world,birds,161.00002F, 84.999985F, 45, 80);


    setting = new setting_stage(game, 730, 532.5F, 70, 70);


    wood = new wood(game, 520, 150, 85, 25, 45, "horizontal_wood", world);  // Angled wood as roof
    wood_2 = new wood(game, 520, 80, 25, 85, 0, "straight_wood", world);      // Left wall
    wood_3 = new wood(game, 580, 80, 25, 85, 0, "straight_wood", world);      // Right wall
    pig_1 = new pig(game, 550, 170, 40, 40, 100, world);                       // Pig inside triangle


    wood_4 = new wood(game, 700, 330, 100, 25, 0, "horizontal_wood", world);  // Platform
    pig_3 = new pig(game, 750, 350, 35, 35, 100, world);                      // Pig on platform
    wood_5 = new wood(game, 750, 70, 25, 300, 0, "straight_wood", world);     // Support pillar

}

@Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        world.step(1 / 60f, 6, 2);



        game.batch.begin();
        game.batch.draw(mainmenu, 0, 0, 800, 600);
        game.batch.end();

        // Update and render the stage
        stage.act(delta);
        stage.draw();

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
        groundBodyDef.position.set(400f / 100f, 60f / 100f);
        groundBodyDef.type = BodyDef.BodyType.StaticBody;

        Body groundBody = world.createBody(groundBodyDef);

        PolygonShape groundShape = new PolygonShape();
        groundShape.setAsBox(400f / 100f, 10f / 100f);

        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.shape = groundShape;
        groundFixtureDef.friction = 0.7f;
        groundFixtureDef.restitution = 0.1f;

        groundBody.createFixture(groundFixtureDef);
        groundBody.setUserData("ground");

        groundShape.dispose();
    }
}
