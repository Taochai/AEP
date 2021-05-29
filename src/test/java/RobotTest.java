import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class RobotTest {

    @Test
    void should_return_receipt_when_saving_bag_given_available_locker() {
        Bag bag = new Bag();
        Robot robot = new Robot(Arrays.asList(new Locker(2), new Locker(2)));
        Receipt receipt = robot.save(bag);

        assertNotNull(receipt);
    }
}
