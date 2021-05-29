import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LockerTest {

    @Test
    void should_return_receipt_when_save_bag_given_available_locker() {
        Bag bag = new Bag();
        Locker locker = new Locker();
        Receipt receipt = locker.save(bag);

        assertNotNull(receipt);
    }
}
