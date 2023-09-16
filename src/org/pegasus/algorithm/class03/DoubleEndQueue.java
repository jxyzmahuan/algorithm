package org.pegasus.algorithm.class03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DoubleEndQueue<T> {
    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
    }

    public Node<T> head;
    public Node<T> tail;

    public void addFromHead(T value) {
        Node<T> cur = new Node<T>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.last = cur;
            head = cur;
        }
    }

    public void addFromTail(T value) {
        Node<T> cur = new Node<T>(value);
        if (head == null) {
            head = cur;
            tail = cur;
        } else {
            cur.last = tail;
            tail.next = cur;
            tail = cur;
        }
    }

    public T popFromHead() {
        if (head == null) {
            return null;
        }
        Node<T> temp = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            temp.next = null;
            head.last = null;
        }
        return temp.value;
    }

    public T popFromTail() {
        if (head == null) {
            return null;
        }
        Node<T> temp = tail;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.last;
            tail.next = null;
            temp.last = null;
        }
        return temp.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static class MyQueue<T> {
        private DoubleEndQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndQueue<T>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyStack<T> {
        private DoubleEndQueue<T> stack;

        public MyStack() {
            stack = new DoubleEndQueue<T>();
        }

        public void push(T value) {
            stack.addFromHead(value);
        }

        public T pop() {
            return stack.popFromHead();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static boolean isEqual(Integer i1, Integer i2) {
        if (i1 == null && i2 != null) {
            return false;
        }
        if (i1 != null && i2 == null) {
            return false;
        }
        if (i1 == null && i2 == null) {
            return true;
        }
        return i1.equals(i2);
    }

    public static void main(String[] args) {
        int testDataLength = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < testDataLength; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }
}
