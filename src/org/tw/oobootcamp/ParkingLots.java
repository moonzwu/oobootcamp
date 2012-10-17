package org.tw.oobootcamp;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/16/12
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLots {
    private int availableSlots;
    private int capacity;

    public ParkingLots(int capacity) {
        availableSlots = capacity;
        this.capacity = capacity;
    }

    public void enterACar() throws Exception {
        if (availableSlots == 0) throw new Exception("ParkingSlots no available slots");
        availableSlots--;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void unparkACar() throws Exception {
        if (availableSlots >= capacity ) throw new Exception("no more cars in parkingSlots");
        availableSlots++;
    }
}
