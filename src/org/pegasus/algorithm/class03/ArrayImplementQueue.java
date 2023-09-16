package org.pegasus.algorithm.class03;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 数组实现队列
 */
public class ArrayImplementQueue {
    private int[] arr;
    private int pushI;
    private int pollI;
    private int size;
    private int limit;

    public ArrayImplementQueue(int limit) {
        arr = new int[limit];
        pushI = 0;
        pollI = 0;
        size = 0;
        this.limit = limit;
    }

    private int nextIndex(int i) {
        return i < limit - 1 ? i + 1 : 0;
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("队列满了");
        }
        size++;
        arr[pushI] = value;
        pushI = nextIndex(pushI);
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("队列空了");
        }
        size--;
        int result = arr[pollI];
        pollI = nextIndex(pollI);
        return result;
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
            ArrayImplementQueue myQueue = new ArrayImplementQueue(testDataLength);
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < testDataLength; j++) {
                int num = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(num);
                    queue.offer(num);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(num);
                        queue.offer(num);
                    } else {
                        if (!isEqual(queue.poll(), myQueue.poll())) {
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
