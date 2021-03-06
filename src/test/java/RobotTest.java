import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RobotTest {

    @Test
    void should_return_receipt_when_saving_bag_given_available_locker() {
        Bag bag = new Bag();
        Robot robot = new Robot(Arrays.asList(new Locker(2), new Locker(2)));
        Receipt receipt = robot.save(bag);

        assertNotNull(receipt);
    }

    @Test
    void should_return_receipt_from_second_locker_when_saving_bag_given_first_locker_full() {
        Bag bag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(2);

        Robot robot = new Robot(Arrays.asList(firstLocker, secondLocker));
        robot.save(new Bag());
        Receipt receipt = robot.save(bag);

        assertNotNull(receipt);
        assertTrue(secondLocker.hasReceipt(receipt));
    }

    @Test
    void should_throw_exception_when_saving_bag_given_all_lockers_full() {
        Bag bag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);

        Robot robot = new Robot(Arrays.asList(firstLocker, secondLocker));
        robot.save(new Bag());
        robot.save(new Bag());

        assertThrows(Exception.class, () -> robot.save(bag), "all lockers full");
    }

    @Test
    void should_return_correct_bag_when_retrieving_bag_given_valid_receipt() {
        Bag expectedBag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);

        Robot robot = new Robot(Arrays.asList(firstLocker, secondLocker));
        Receipt receipt = robot.save(expectedBag);

        assertEquals(expectedBag, robot.retrieve(receipt));
    }

    @Test
    void should_throw_exception_when_retrieving_given_fake_receipt() {
        Bag expectedBag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);

        Robot robot = new Robot(Arrays.asList(firstLocker, secondLocker));
        robot.save(expectedBag);

        assertThrows(Exception.class, () -> robot.retrieve(new Receipt()), "invalid receipt");
    }

    @Test
    void should_throw_exception_when_retrieving_given_used_receipt() {
        Bag expectedBag = new Bag();
        Locker firstLocker = new Locker(1);
        Locker secondLocker = new Locker(1);

        Robot robot = new Robot(Arrays.asList(firstLocker, secondLocker));
        Receipt receipt = robot.save(expectedBag);
        robot.retrieve(receipt);

        assertThrows(Exception.class, () -> robot.retrieve(receipt), "invalid receipt");
    }
}
