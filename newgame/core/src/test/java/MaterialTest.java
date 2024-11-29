import com.badlogic.gdx.physics.box2d.World;
import io.github.some_example_name.Main;
import io.github.some_example_name.wood;
import io.github.some_example_name.blackbird;
import io.github.some_example_name.redbird;
import io.github.some_example_name.yellowbird;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class MaterialTest {
    Main game;
    World world;
    wood wood;

    @Test
    public void wood_test() {
        wood = new wood(game, 492, 81, 25, 50, 100, "straight_wood", world);
        assertNotEquals(wood, null);
    }
}

