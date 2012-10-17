import org.junit.Test;
import org.tw.oobootcamp.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/16/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLotsTest {
    @Test
    public void given_3_slots_when_park_then_2_slots_left() {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.enterACar();
        assertThat(parkingLots.getAvailableSlots(), is(2));
    }

    @Test
    public void given_0_slots_when_park_then_should_fail() {
        ParkingLots parkingLots = new ParkingLots(0);
        ParkStatus parkStatus = parkingLots.enterACar();
        assertThat(parkStatus, is(ParkStatus.FAIL));
        assertThat(parkingLots.getAvailableSlots(), is(0));
    }

    @Test
    public void given_illegal_number_as_available_slots_should_create_an_empty_parking_slots() {
        ParkingLots parkingLots = new ParkingLots(-1);
        assertThat(parkingLots.getAvailableSlots(), is(0));
    }

    @Test
    public void given_3_slots_when_no_park_then_should_left_3_slots() {
        ParkingLots parkingLots = new ParkingLots(3);
        assertThat(parkingLots.getAvailableSlots(), is(3));
    }

    @Test
    public void given_3_slots_when_unpark_then_4_slots_left() {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.unparkACar();
        assertThat(parkingLots.getAvailableSlots(), is(4));
    }

    @Test
    public void given_3_slots_when_no_unpark_then_not_4_slots_left() {
        ParkingLots parkingLots = new ParkingLots(3);
        assertThat(parkingLots.getAvailableSlots(), not(4));
    }

    @Test
    public void given_a_car_when_give_to_parking_boy_then_get_ticket() {
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.receive(car);
        assertNotNull(ticket);
    }


}
