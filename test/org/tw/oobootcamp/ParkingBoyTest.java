package org.tw.oobootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ParkingBoyTest {

    @Test
    public void given_1_car_when_parkingBoy_park_then_should_return_a_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLots(1));
        Ticket ticket = parkingBoy.receiveACar(new Car(1111));
        assertNotNull(ticket);
    }

    @Test
    public void given_full_parking_slots_and_come_a_new_car_when_parkingBoy_park_then_reject() throws Exception {
        ParkingLots parkingLots = new ParkingLots(1);
        parkingLots.enterACar();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        try {
            parkingBoy.receiveACar(null);
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("ParkingSlots no available slots"));
        }
    }

    @Test
    public void given_a_parked_car_when_parkingBoy_unpark_then_return_the_same_car() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLots(1));

        Ticket ticket = parkingBoy.receiveACar(new Car(1111));
        Car car = parkingBoy.returnACar(ticket);
        assertThat(car.getIdNumber(), is(1111));
    }

}
