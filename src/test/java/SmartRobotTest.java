import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmartRobotTest {

    @Test
    void should_return_receipt_from_second_locker_when_save_bag_given_three_lockers_and_second_is_max_capacity() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        Locker locker3 = new Locker(10);
        locker1.save(new Bag());
        locker3.save(new Bag());

        SmartRobot smartRobot = new SmartRobot(Arrays.asList(locker1, locker2, locker3));

        Receipt receipt = smartRobot.save(bag);

        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(9, locker2.getAvailableCapacity());

    }

    @Test
    void should_return_receipt_from_second_locker_when_save_bag_given_three_lockers_and_there_are_two_lockers_have_same_max_capacity() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(10);
        Locker locker2 = new Locker(10);
        Locker locker3 = new Locker(10);
        locker1.save(new Bag());

        SmartRobot smartRobot = new SmartRobot(Arrays.asList(locker1, locker2, locker3));

        Receipt receipt = smartRobot.save(bag);

        Assertions.assertNotNull(receipt);
        Assertions.assertEquals(9, locker2.getAvailableCapacity());
    }

    @Test
    void should_throw_exception_when_save_bag_given_three_lockers_and_there_are_all_lockers_are_full() {
        Bag bag = new Bag();
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        Locker locker3 = new Locker(1);
        locker1.save(new Bag());
        locker2.save(new Bag());
        locker3.save(new Bag());

        SmartRobot smartRobot = new SmartRobot(Arrays.asList(locker1, locker2, locker3));

        Assertions.assertThrows(RuntimeException.class, () -> smartRobot.save(bag), "all lockers full");

    }
}
