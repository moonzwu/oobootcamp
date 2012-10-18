package org.tw.oobootcamp;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ParkingBoyTest {

    @Test
    public void given_1_car_when_parkingBoy_park_then_should_return_a_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLots(1));
        Ticket ticket = parkingBoy.receiveACar();
        assertNotNull(ticket);
    }

    @Test
    public void given_full_parking_slots_and_come_a_new_car_when_parkingBoy_park_then_reject() throws Exception {
        ParkingLots parkingLots = new ParkingLots(1);
        parkingLots.enterACar();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        try {
            parkingBoy.receiveACar();
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("ParkingSlots no available slots"));
        }
    }

    @Test
    public void given_a_parked_car_when_parkingBoy_unpark_then_return_the_same_car() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLots(1));

        Car car = parkingBoy.returnACar();
        assertThat(car.getIdNumber(), is(1111));
    }

    @Test
    public void given_two_parked_cars_when_parkingBoy_unpark_by_ticket_then_return_the_same_car() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLots(2));
        parkingBoy.receiveACar(new Car(1111));
        parkingBoy.receiveACar(new Car(2222));
        Ticket ticket = new Ticket(1111);
        Car car = parkingBoy.returnACar(ticket);
        assertThat(car.getIdNumber(), is(1111));
    }

    @Test
    public void given_2_parkinglots_and_1_car_when_park_then_second_parkinglots_has_no_car() throws Exception {
        ArrayList<ParkingLots> parkingLots = new ArrayList<ParkingLots>();
        ParkingLots firstParkingLot = new ParkingLots(3);
        ParkingLots secondParkingLot = new ParkingLots(5);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.receiveACar(new Car(1111));

        parkingBoy.receiveACar(new Car(1111));

        assertThat(firstParkingLot.getAvailableSlots(), is(1));
        assertThat(secondParkingLot.getAvailableSlots(), is(5));
    }

    @Test
    public void given_2_parkinglots_and_first_is_full_when_park_then_second_parkinglots_has_1_car() throws Exception {
        ArrayList<ParkingLots> parkingLots = new ArrayList<ParkingLots>();
        ParkingLots firstParkingLot = new ParkingLots(1);
        ParkingLots secondParkingLot = new ParkingLots(5);
        parkingLots.add(firstParkingLot);
        parkingLots.add(secondParkingLot);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        parkingBoy.receiveACar(new Car(1111));

        parkingBoy.receiveACar(new Car(1111));

        assertThat(firstParkingLot.getAvailableSlots(), is(0));
        assertThat(secondParkingLot.getAvailableSlots(), is(4));
    }


    @Test
    public void given_2_full_parkinglots_when_park_then_should_fail() throws Exception {
        ArrayList<ParkingLots> parkingLotsList = new ArrayList<ParkingLots>();
        parkingLotsList.add(new ParkingLots(1));
        parkingLotsList.add(new ParkingLots(1));

        ParkingBoy parkingBoy = new ParkingBoy(parkingLotsList);
        parkingBoy.receiveACar(new Car(1111));
        parkingBoy.receiveACar(new Car(2222));

        try {
            parkingBoy.receiveACar(new Car(3333));
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("ParkingSlots no available slots"));
        }

    }




}
