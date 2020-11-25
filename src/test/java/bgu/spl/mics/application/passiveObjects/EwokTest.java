package bgu.spl.mics.application.passiveObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EwokTest {
    Ewok wookie1;
    Ewok wookie2;
    @BeforeEach
    void setUp() {
        wookie1 = new Ewok(1312311,true);
        wookie2 = new Ewok(1542131,false);
    }

    @Test
    void acquire() {
        assertTrue(wookie1.getAvailable());
        assertFalse(wookie2.getAvailable());
        wookie1.setAvailable(false);
        assertFalse(wookie1.getAvailable());
    }

    @Test
    void release() {
        wookie1.setAvailable(false);
        assertFalse(wookie1.getAvailable());
        wookie1.setAvailable(true);
        assertTrue(wookie1.getAvailable());
    }
}