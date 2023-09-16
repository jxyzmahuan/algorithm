package org.pegasus.algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoQueueImplementStack {
    public static class TwoQueuesStack<T> {
        private Queue<T> data;
        private Queue<T> help;

        public TwoQueuesStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        /**
         * 交换data和help引用
         */
        private void swap() {
            Queue temp = data;
            data = help;
            help = temp;
        }

        public void push(T value) {
            data.offer(value);
        }

        public T pop() {
            while (data.size() > 1) {
                help.offer(data.poll());
            }
            T result = data.poll();
            swap();
            return result;
        }

        public T peek() {
            while (data.size() > 1) {
                help.offer(data.poll());
            }
            T result = data.poll();
            help.offer(result);
            swap();
            return result;
        }
    }

    public static void main(String[] args) {
        int testDataLength = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            TwoQueuesStack<Integer> myStack = new TwoQueuesStack<Integer>();
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < testDataLength; j++) {
                int num = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(num);
                    stack.push(num);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(num);
                        stack.push(num);
                    } else {
                        if (!DoubleEndQueue.isEqual(stack.pop(), myStack.pop())) {
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
