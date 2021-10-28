package com.pegasus;

import java.util.function.IntConsumer;

/***
 * https://leetcode-cn.com/problems/print-zero-even-odd
 */
public class ZeroEvenOdd {
    private int n;
    private volatile int state = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (state % 2 != 0) {
                Thread.yield();
            }
            printNumber.accept(0);
            state++;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n ; i += 2) {
            while (state % 4 != 3) {
                Thread.yield();
            }
            printNumber.accept(i );
            System.out.print(printNumber);
            state++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n; i += 2) {
            while (state % 4 != 1) {
                Thread.yield();
            }
            printNumber.accept(i );
            System.out.print(printNumber);
            state++;
        }
    }

    public static void main(String[] args) {
        System.out.println("dada ");
//        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                zeroEvenOdd.zero(new IntConsumer() {
//                    @Override
//                    public void accept(int value) {
//                        System.out.print(value);
//                    }
//                });
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                zeroEvenOdd.zero();
//            }
//        });
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                zeroEvenOdd.zero();
//            }
//        });
    }

}
