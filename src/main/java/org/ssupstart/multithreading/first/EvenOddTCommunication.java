package org.ssupstart.multithreading.first;

public class EvenOddTCommunication {
    public int counter = 0;
    public int limit;
    public Object lock = new Object();

    public EvenOddTCommunication(int limit) {
        this.limit = limit;
    }

    public void even() {
        synchronized (lock) {
            while (counter<=limit) {
                if(counter%2 == 0) {
                    System.out.println("even " + counter);
                    counter++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public void odd() {
        synchronized (lock) {
            while (counter<=limit) {
                if(counter%2 != 0) {
                    System.out.println("odd " + counter);
                    counter++;
                    notify();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        EvenOddTCommunication obj = new EvenOddTCommunication(20);
        Thread tEven = new Thread(obj::even);
        Thread tOdd = new Thread(obj::odd);

        tEven.start();
        tOdd.start();
    }
}
