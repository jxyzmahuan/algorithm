package com.pegasus;

public class MajusculeABCCAS {
    //2.有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
//            请补充以下代码
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread ta = new Thread(new ThreadABC(maj, 'A'));
        Thread tb = new Thread(new ThreadABC(maj, 'B'));
        Thread tc = new Thread(new ThreadABC(maj, 'C'));
        ta.start();
        tb.start();
        tc.start();
    }
}

class MajusculeABC {
    volatile char state = 'A';

    //TODO
    public MajusculeABC() {
    }
}

class ThreadABC implements Runnable {
    char character;
    MajusculeABC majusculeABC;

    public ThreadABC(MajusculeABC majusculeABC, Character c) {
        this.character = c;
        this.majusculeABC = majusculeABC;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            while (character != majusculeABC.state) {
            }
            System.out.print(character);
            if (character == 'A') {
                majusculeABC.state = 'B';
            }
            if (character == 'B') {
                majusculeABC.state = 'C';
            }
            if (character == 'C') {
//                System.out.println();
                majusculeABC.state = 'A';
            }
        }
    }
}