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

    public void setSlots(int i) {
        availableSlots = i;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void park() {
        availableSlots--;
    }
}
