package bgu.spl.mics.application.passiveObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EwokTest {
    Ewok wookie1;
    Ewok wookie2;
    @BeforeEach
    public void setUp(){ //initialize
        wookie1 = new Ewok(1312311,true);
        wookie2 = new Ewok(1542131,false);
    }

    @Test
    void acquire() {
        assertTrue(wookie1.getAvailable()); //pass test
        assertTrue(wookie2.getAvailable()); //fail test
        wookie1.setAvailable(false);
        assertTrue(wookie1.getAvailable()); //fail test
    }

    @Test
    void release() {
        wookie1.setAvailable(false);
        assertFalse(wookie1.getAvailable()); //pass test
        wookie1.setAvailable(true);
        assertTrue(wookie1.getAvailable()); //fail test

    }
}