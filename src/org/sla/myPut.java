package org.sla;

public class myPut implements Runnable{
    MyQueueSychronized ShareMyQueue;
    int putID;
    int puts;

    myPut(MyQueueSychronized myqueue, int id, int howMany){
        ShareMyQueue = myqueue;
        putID = id;
        puts = howMany;
    }

    @Override
    public void run() {
        //remove 100 spaces
        for(int i = 0; i < puts; i ++) {
            boolean putSuccess = ShareMyQueue.put(putID);
            while(!putSuccess){
                Thread.currentThread().yield();
                putSuccess = ShareMyQueue.put(putID);
            }
            ShareMyQueue.put(i);
        }
    }

}
