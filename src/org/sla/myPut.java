package org.sla;

public class myPut implements Runnable{
    MyQueueSychronized ShareMyQueue;
    int puts;

    myPut(MyQueueSychronized myqueue, int howMany){
        ShareMyQueue = myqueue;
        puts = howMany;
    }

    @Override
    public void run() {
        //remove 100 spaces
        for(int i = 0; i < puts; i ++) {
            boolean putSuccess = ShareMyQueue.put(i);
            while(!putSuccess){
                Thread.currentThread().yield();
                putSuccess = ShareMyQueue.put(i);
            }
        }
    }

}
