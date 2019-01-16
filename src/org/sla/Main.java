package org.sla;

public class Main {

    public static void main(String[] args) {
        MyQueueSychronized myqueue = new MyQueueSychronized();

        //Create put/get
        myPut myPutter1 = new myPut(myqueue, 500);
        myPut myPutter2 = new myPut(myqueue,400);
        myGet myGetter1 = new myGet(myqueue, 500);
        myGet myGetter2 = new myGet(myqueue,400);

        //create and start thread
        Thread getThread = new Thread(myGetter1);
        getThread.start();

        Thread getThread2 = new Thread(myGetter2);
        getThread2.start();

        Thread putThread = new Thread(myPutter1);
        putThread.start();

        Thread putThread2 = new Thread(myPutter2);
        putThread2.start();



    }
}
