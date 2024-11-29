package io.github.some_example_name;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Hud {

    public Stage stage;
    private Viewport viewport;
    private Integer score;

    Label scoreLabel;

    public Hud(SpriteBatch sb){
        score = 0;  // Set the initial score to 0
        viewport = new FitViewport(800, 600, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();  // Align the table to the top of the screen
        table.padTop(20);  // Adjust padding from the top

        // Create a bigger font (increasing font size here)
        BitmapFont font = new BitmapFont();
        font.getData().setScale(2);  // Increase font size

        // Update the label text to "Score: 000"
        scoreLabel = new Label("Score: " + String.format("%03d", score), new Label.LabelStyle(font, Color.WHITE));

        // Add the scoreLabel to the table and align it to the left
        table.add(scoreLabel).expandX().left().padTop(10);

        stage.addActor(table);
    }

    // Method to update the score and refresh the label text
    public void updateScore(int newScore) {
        score = newScore;
        scoreLabel.setText("Score: " + String.format("%03d", score));
    }
}
