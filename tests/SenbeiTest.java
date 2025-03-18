package tests;

import app.Senbei;
import org.junit.Test;
import static org.junit.Assert.*;

public class SenbeiTest {
    @Test
    public void testInvent() {
        Senbei senbei = new Senbei("Senbei Norimaki", 70);
        senbei.invent();
        assertEquals(85, senbei.getIntelligence());
    }
}