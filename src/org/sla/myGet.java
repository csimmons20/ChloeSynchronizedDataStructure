package org.sla;

public class myGet implements Runnable{
   MyQueueSychronized ShareMyQueue;
   int DID;
   int gets;

   myGet(MyQueueSychronized myqueue, int howMany){
       ShareMyQueue = myqueue;
       gets = howMany;
   }

       @Override
    public void run() {
       //remove 100 spaces
        for(int i = 0; i < gets; i ++) {
            Object obj = ShareMyQueue.get();

            while (obj == null){
                Thread.currentThread().yield();
                obj = ShareMyQueue.get();
            }
            System.out.println(obj);
        }
      }
}
