package org.ssupstart.datastructure.multithreading.firstpracticepingpong;

import java.util.concurrent.atomic.AtomicInteger;

public class PingPongV2 {

    boolean pingTurn = true;
    AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        PingPongV2 pingPongObj = new PingPongV2();

        Thread pingThread = new Thread(pingPongObj :: pingThread);
        Thread pongThread = new Thread(pingPongObj :: pongThread);

        pingThread.start();
        pongThread.start();
    }

    private synchronized void pingThread() {
        for(int i=0 ; i<500; i++) {
            while (!pingTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Ping " + counter.incrementAndGet());
            pingTurn = false;
            notify();
        }
    }

    private synchronized void pongThread() {
        for(int i=0; i<500; i++) {
            while(pingTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Pong " + counter.incrementAndGet());
            pingTurn = true;
            notify();
        }
    }

}
