package org.ssupstart.datastructure.multithreading.firstpracticepingpong;

public class PingPong {

    boolean pingTurn = true;

    public static void main(String[] args) {
        PingPong pingPongObj = new PingPong();

        Thread pingThread = new Thread(pingPongObj :: printPing);
        Thread pongThread = new Thread(pingPongObj :: printPong);

        pingThread.start();
        pongThread.start();
    }

    private synchronized void printPing() {
        for(int i=0; i<500; i++) {
            while (!pingTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Ping");
            pingTurn = false;
            notify();
        }
    }

    private synchronized void printPong() {
        for(int i=0; i<500; i++) {
            while (pingTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Pong");
            pingTurn = true;
            notify();
        }
    }
}
