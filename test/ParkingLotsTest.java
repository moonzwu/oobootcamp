import org.junit.Test;
import org.tw.oobootcamp.ParkingLots;

import static org.hamcrest.core.Is.is;
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
    public void given_3_slots_when_park_then_2_slots_left() {
        ParkingLots parkingLots = new ParkingLots();
        parkingLots.setSlots(3);
        parkingLots.park();
        assertThat(parkingLots.getAvailableSlots(), is(2));
    }

    @Test
    public void given_0_slots_when_park_then_should_fail() {
        ParkingLots parkingLots = new ParkingLots();
        parkingLots.setSlots(0);
        try {
            parkingLots.park();
            fail();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("No available slots!"));
        }
    }
}
