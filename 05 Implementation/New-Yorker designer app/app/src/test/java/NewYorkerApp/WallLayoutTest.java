package NewYorkerApp;

import org.junit.Test;

import Logic.WallLayout;

import static org.junit.Assert.*;

public class WallLayoutTest {

    WallLayout wall = new WallLayout();

    @Test
    public void createNewOffer() {

        assertFalse(wall.height==300);
        assertFalse(wall.height == -100);
        assertFalse(wall.width == 200);
    }

    @Test
    public void calculatePane() {

        assertEquals(4, wall.calculatePane(200));

    }

    @Test
    public void calculateFrame() {
        assertEquals(2, wall.calculateFrame(80));
    }
}