package org.sla;

public class myGet implements Runnable{
   MyQueueSychronized ShareMyQueue;
   int DID;
   int gets;

   myGet(MyQueueSychronized myqueue, int ID, int howMany){
       ShareMyQueue = myqueue;
       DID = ID;
       gets = howMany;
   }

       @Override
    public void run() {
       //remove 100 spaces
        for(int j = 0; j < gets; j ++) {
            boolean getSuccess = ShareMyQueue.get(DID);

            while (!getSuccess){
                Thread.currentThread().yield();
                getSuccess = ShareMyQueue.get(DID);
            }
            Object NewQueue = ShareMyQueue.get(DID);
            System.out.println(NewQueue);
        }
      }
}
