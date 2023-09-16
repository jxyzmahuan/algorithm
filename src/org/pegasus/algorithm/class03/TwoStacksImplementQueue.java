package org.pegasus.algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoStacksImplementQueue {
    public static class TwoStacksQueue<T> {
        private Stack<T> stackPush;
        private Stack<T> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        /**
         * push栈向pop倒入数据
         */
        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(T value) {
            stackPush.push(value);
            pushToPop();
        }

        public T poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public T peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        int testDataLength = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            TwoStacksQueue<Integer> myQueue = new TwoStacksQueue<Integer>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < testDataLength; j++) {
                int num = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.add(num);
                    queue.offer(num);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.add(num);
                        queue.offer(num);
                    } else {
                        if (!DoubleEndQueue.isEqual(queue.poll(), myQueue.poll())) {
                            System.out.println("oops!!!");
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("finish!!!");
    }
}
