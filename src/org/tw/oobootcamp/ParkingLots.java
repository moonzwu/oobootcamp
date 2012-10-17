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

    public ParkingLots(int availableSlots) {
        initWithAvailableSlotsCount(availableSlots);

    }

    private void initWithAvailableSlotsCount(int availableSlots) {
        this.availableSlots =  availableSlots < 0 ? 0 : availableSlots;
    }

    public int getAvailableSlots() {
        return availableSlots;

    }

    public ParkStatus enterACar() {
        if (availableSlots == 0) return ParkStatus.FAIL;
        availableSlots--;
        return ParkStatus.SUCCESS;
    }

    public void unparkACar() {
        availableSlots++;
    }

}
