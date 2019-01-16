package org.sla;


public class MyQueueSychronized {
    int PositionGet;
    int PositionPut;
    Object[] AllData;
    int amountData;


    //Create the data for the queue
    MyQueueSychronized() {
        AllData = new Object[100];
    }


    //allow put() if space in data
    synchronized boolean put(Object NewData) {

        //ADD DATA
        AllData[PositionPut] = NewData;
        amountData = amountData + 1;

        if (PositionPut < 99) {
         PositionPut = PositionPut + 1;
         return true;
        } else {
            PositionPut = 0;
        }

        if (amountData >= 100) {
            System.out.println("Error: Can't put in anymore data! Please get()");
        }
        return false;
    }


    //allow get() if no more space for data
    synchronized boolean get(int DID) {
        if(amountData <= 0 ){
            System.out.println("Error: No more data! Please put().");
        }

        //REMOVE DATA
        int originalPositionGet = PositionGet;
        amountData = amountData - 1;

        if (PositionGet < 99) {
            PositionGet = PositionGet + 1;
            return true;
        } else {
            PositionGet = 0;
        }
        //return AllData[originalPositionGet];

        return false;
    }
}

