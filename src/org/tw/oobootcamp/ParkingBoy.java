package org.tw.oobootcamp;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/17/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {


    private ParkingLots parkingLots;
    private List<ParkingLots> parkingLotsList;

    public ParkingBoy(ParkingLots parkingLots) {
        parkingLotsList = new ArrayList<ParkingLots>();
        parkingLotsList.add(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingBoy(List<ParkingLots> parkingLots) {
        parkingLotsList = parkingLots;
    }

    public Ticket receiveACar() throws Exception {
        parkingLots.enterACar();
        return new Ticket();
    }

    public Car returnACar() {

        return new Car(1111);
    }

    public void receiveACar(Car car) throws Exception {
        for (ParkingLots managedParkingLots : parkingLotsList) {
            if (managedParkingLots.getAvailableSlots() == 0) {
                continue;
            }
            managedParkingLots.enterACar();
            return;
        }
        throw new Exception("ParkingSlots no available slots");
    }

    public Car returnACar(Ticket ticket) {
        return new Car(ticket.getCarId());
    }
}
