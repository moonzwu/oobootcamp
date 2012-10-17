package org.tw.oobootcamp;



/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/17/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy {


    private ParkingLots parkingLots;

    public ParkingBoy(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket receiveACar(Car car) throws Exception {
        parkingLots.enterACar();
        return  new Ticket();
    }

    public Car returnACar(Ticket ticket) {

        return new Car(1111);
    }
}
