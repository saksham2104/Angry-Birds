
import com.badlogic.gdx.physics.box2d.World;
import io.github.some_example_name.Main;
import io.github.some_example_name.blackbird;
import io.github.some_example_name.redbird;
import io.github.some_example_name.yellowbird;
import org.junit.Test;
//import org.junit.Assert;
//import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BirdTest {
    Main game;
    World world;
    redbird bird1;
    yellowbird bird2;
    blackbird bird3;

    //test for bird1
    @Test
    public void testredbird(){
        bird1 = new redbird(game, 119F, 83F, "red", world);
        assertNotEquals(bird1,null);
    }

    //test for bird2
    @Test
    public void testyellowbird(){
        bird2 = new yellowbird(game, 66F, 83.999985F, "yellow", world);
        assertNotEquals(bird2,null);
    }

    //test for bird3
    @Test
    public void testblackbird(){
        bird3 = new blackbird(game, 10F, 82F, "black", world);
        assertNotEquals(bird3,null);
    }
}
