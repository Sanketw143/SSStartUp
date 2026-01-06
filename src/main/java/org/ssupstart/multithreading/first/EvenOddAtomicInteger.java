package org.ssupstart.multithreading.first;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddAtomicInteger {
    private final AtomicInteger counter = new AtomicInteger(0);
    public int limit;

    public EvenOddAtomicInteger(int limit) {
        this.limit = limit;
    }

    public void even() {
        while (counter.get()<=limit) {
            while (counter.get() % 2 == 0) {
                System.out.println("even " + counter.get());
                counter.getAndIncrement();
            }
        }
    }

    public void odd() {
        while (counter.get()<=limit) {
            while (counter.get() % 2 != 0) {
                System.out.println("odd " + counter.get());
                counter.getAndIncrement();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddAtomicInteger obj = new EvenOddAtomicInteger(20);
        Thread tEven = new Thread(obj::even);
        Thread tOdd = new Thread(obj::odd);
        tEven.start();
        tOdd.start();
    }
}
