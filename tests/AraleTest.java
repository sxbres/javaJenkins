package tests;

import app.Arale;
import org.junit.Test;
import static org.junit.Assert.*;

public class AraleTest {
    @Test
    public void testEatNcha() {
        Arale arale = new Arale("Arale Norimaki", 50);
        arale.eatNcha();
        assertEquals(60, arale.getEnergy());
    }
}