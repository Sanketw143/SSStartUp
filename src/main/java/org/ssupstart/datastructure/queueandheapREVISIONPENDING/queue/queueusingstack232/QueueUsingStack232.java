package org.ssupstart.datastructure.queueandheapREVISIONPENDING.queue.queueusingstack232;


import java.util.Stack;

//Implement a first in first out (FIFO) queue using only two stacks.
//The implemented queue should support all the functions of a normal queue
//(push, peek, pop, and empty).
//Implement the MyQueue class:
//
//void push(int x) Pushes element x to the back of the queue.
//int pop() Removes the element from the front of the queue and returns it.
//int peek() Returns the element at the front of the queue.
//boolean empty() Returns true if the queue is empty, false otherwise.
public class QueueUsingStack232 {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public QueueUsingStack232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty();
    }
}
