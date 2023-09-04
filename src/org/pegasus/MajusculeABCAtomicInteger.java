package org.pegasus;

public class MajusculeABCAtomicInteger {
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
