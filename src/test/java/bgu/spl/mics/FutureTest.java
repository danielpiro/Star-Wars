package bgu.spl.mics;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;


public class FutureTest {

    private Future<String> future;

    @BeforeEach
    public void setUp(){
        future = new Future<>();
    }

    @Test
    public void testGet()
    {
        assertFalse(future.isDone());
        future.resolve("");
        future.get();
        assertTrue(future.isDone());
    }

    @Test
    public void testResolve(){
        String str = "someResult";
        future.resolve(str);
        assertTrue(future.isDone());
        assertEquals(future.get(), str);
    }

    @Test
    public void testIsDone(){
        String str = "Result";
        assertFalse(future.isDone());
        future.resolve(str);
        assertTrue(future.isDone());
    }

    @Test
    public void testGetWithTimeOut() throws InterruptedException
    {
        try {
            assertFalse(future.isDone());
            future.get(100, TimeUnit.MILLISECONDS);
            assertFalse(future.isDone());
            future.resolve("test");
            assertEquals(future.get(100, TimeUnit.MILLISECONDS), "test");
        }
        catch (Exception ex){
            throw new InterruptedException("connection timeout");
        }
    }
}
