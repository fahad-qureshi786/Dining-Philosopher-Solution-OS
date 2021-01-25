package com.i2p.pk;

public class Main {

    public static void main(String[] args) {
        Philosopher[] philosopher = new Philosopher[10];
        Object[] nodes = new Object[10];
        for (int i = 0; i < philosopher.length; i++) {
            nodes[i] = new Object();
        }
        for (int i = 0; i < philosopher.length; i++) {
            Object leftNode = nodes[i];
            Object rightNode = nodes[(i+1)%10];
            if (i == philosopher.length-1) {
                philosopher[i] = new Philosopher(leftNode, rightNode);
            }else{
                philosopher[i] = new Philosopher(rightNode,leftNode);
            }
            Runnable target;
            Thread  thread = new Thread(philosopher[i], " Philosopher "+(i+1));
            thread.start();
        }
    }
}
