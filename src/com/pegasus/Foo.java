package com.pegasus;

import java.util.concurrent.locks.LockSupport;

class Foo {
    volatile int number = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        number++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (number != 1) {

        }
        printSecond.run();
        number++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (number != 2) {

        }
        printThird.run();
    }
}