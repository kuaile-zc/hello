package com.zc.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author CoreyChen Zhang
 * @version 2021/3/5 10:04
 * @modified
 */
public class ImplementQueueUsingStacks {

    class MyQueue {

        private Deque<Integer> queue;

        /** Initialize your data structure here. */
        public MyQueue() {
            queue = new LinkedList();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            queue.offerLast(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return queue.poll();
        }

        /** Get the front element. */
        public int peek() {
            return queue.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
