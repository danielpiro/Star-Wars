package bgu.spl.mics;

import bgu.spl.mics.application.messages.AttackEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageBusTest {
    MessageBus msg;
    MicroService micro;
    AttackEvent attackEvent;

    @BeforeEach
    public void setUp(){
        micro = new MicroService("thread 1") {
            @Override
            protected void initialize() { }
        };
        attackEvent = new AttackEvent();
    }


    @Test
    public void subscribeEvent() {
        try {
            msg.subscribeEvent((Class<? extends Event<String>>) micro.getClass(), micro);
        }catch (Exception ex){
            System.out.println("could not subscribe new event");
        }
    }

    @Test
    public void subscribeBroadcast() {
        try {
            msg.subscribeBroadcast((Class<? extends Broadcast>) micro.getClass(), micro);
        }catch (Exception ex){
            System.out.println("could not broadcast the event");
        }
    }

    @Test
    public void complete() {
    }

    @Test
    public void sendBroadcast() {
        try {
            msg.sendBroadcast((Broadcast) attackEvent);
        }catch (Exception ex){
            System.out.println("the attack event was not registered");
        }
    }

    @Test
    public void sendEvent() {
        try {
            msg.sendEvent(attackEvent);
        }catch (Exception ex){
            System.out.println("the requested event didnt reach the micro service");
        }
    }

    @Test
    public void register() {
        msg.register(micro);
        try {
            msg.awaitMessage(micro);
        }
        catch (Exception ex){
            System.out.println("the process was not registered");
        }
    }

    @Test
    public void unregister() {
        msg.unregister(micro);
        try{
            msg.awaitMessage(micro);
        }catch (Exception ex){
            System.out.println("the process was not unregistered ");
        }
    }
    @Test
    public void awaitMessage() throws InterruptedException {
        assertNotNull(msg.awaitMessage(micro));
    }
}