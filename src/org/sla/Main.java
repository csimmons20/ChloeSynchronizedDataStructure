package org.sla;

public class Main {

    public static void main(String[] args) {
        MyQueueSychronized myqueue = new MyQueueSychronized();

        //Create put/get
        myPut myPutter1 = new myPut(myqueue, 1, 100);
        myGet myGetter1 = new myGet(myqueue, 2, 10);

        //create and start thread
        Thread getThread = new Thread(myGetter1);
        getThread.start();

        Thread putThread = new Thread(myPutter1);
        putThread.start();



    }
}
