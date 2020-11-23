package bgu.spl.mics.application.passiveObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EwokTest {
    Ewok woki1;
    Ewok woki2;
    @BeforeEach
    public void setUp(){
        woki1 = new Ewok(1312311,true);
        woki2 = new Ewok(1542131,false);
    }

    @Test
    void acquire() {
        assertTrue(woki1.getAvailable());
        assertTrue(woki2.getAvailable());
    }

    @Test
    void release() {
        woki1.setAvailable(false);
        assertFalse(woki1.getAvailable());

    }
}