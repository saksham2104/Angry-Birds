
import com.badlogic.gdx.physics.box2d.World;
import io.github.some_example_name.Main;
import io.github.some_example_name.pig;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class PigTest {
    Main game;
    World world;
    pig pig_1;
    @Test
    public void test() {
        pig_1 = new pig(game, 589, 228, 50, 50, 100, world);
        assertNotEquals(pig_1,null);
    }
}
