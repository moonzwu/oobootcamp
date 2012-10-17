import org.junit.Test;
import org.tw.oobootcamp.ParkingLots;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/16/12
 * Time: 1:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingLotsTest {
    @Test
    public void given_3_slots_capacity_when_park_then_2_available_slots_left() throws Exception {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.enterACar();
        assertThat(parkingLots.getAvailableSlots(), is(2));
    }

    @Test
    public void given_3_slots_capacity_when_no_park_then_available_slots_not_2() {
        ParkingLots parkingLots = new ParkingLots(3);
        assertThat(parkingLots.getAvailableSlots(), not(2));
    }

    @Test
    public void given_3_slots_capacity_when_park_fully_then_0_available_slots_left() throws Exception {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.enterACar();
        parkingLots.enterACar();
        parkingLots.enterACar();

        assertThat(parkingLots.getAvailableSlots(), is(0));
    }

    @Test
    public void given_3_slots_capacity_when_park_4_cars_then_fail() throws Exception {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.enterACar();
        parkingLots.enterACar();
        parkingLots.enterACar();
        try {
            parkingLots.enterACar();
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("ParkingSlots no available slots"));
        }
    }

    @Test
    public void given_3_slots_capacity_and_have_1_car_when_unpack_then_3_available_slots_left() throws Exception {
        ParkingLots parkingLots = new ParkingLots(3);
        parkingLots.enterACar();
        parkingLots.unparkACar();
        assertThat(parkingLots.getAvailableSlots(), is(3));
    }

    @Test
    public void given_3_slots_capacity_and_no_car_in_parking_slots_when_unpark_then_failed() {
        ParkingLots parkingLots = new ParkingLots(3);
        try {
            parkingLots.unparkACar();
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("no more cars in parkingSlots"));
        }
    }



}