package com.i2p.pk;

public class Philosopher extends Thread {
    private Object leftNode;
    private Object rightNode;
    private int leftFood = 10;

    public Philosopher(Object leftNode, Object rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void activityStart(String activity) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"\t"+activity);
        Thread.sleep((int) Math.random()*100);

    }

    @Override
    public void run() {
        try {
            activityStart("Left Food: " + this.leftFood + "\tThinking");
            synchronized (leftNode) {
                activityStart("Left Food: " + this.leftFood + " :Picked up Left Burger");
            }
            synchronized (rightNode) {
                activityStart("Left Food: " + this.leftFood + " :Picked up Right Burger and started eating");
                activityStart("Left Food: " + this.leftFood + " :Stop eating right burger");
                this.leftFood -= 1;
            }
            activityStart ("Left food: " + this.leftFood + "\t: Start thinking stop eating left burgers");
        }catch (Exception e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
