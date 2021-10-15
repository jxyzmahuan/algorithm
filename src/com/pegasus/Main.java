package com.pegasus;

public class Main {

    public static void main(String[] args) throws InterruptedException{
	// write your code here
        Foo foo =new Foo();
        Runnable first=new Runnable() {
            @Override
            public void run() {
                System.out.print("first");
            }
        };

        Runnable second=new Runnable() {
            @Override
            public void run() {
                System.out.print("second");
            }
        };
        Runnable third=new Runnable() {
            @Override
            public void run() {
                System.out.print("third");
            }
        };
        foo.first(first);
        foo.third(third);
        foo.second(second);
    }
}
