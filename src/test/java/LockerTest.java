import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {

    @Test
    void should_return_receipt_when_save_bag_given_available_locker() {
        Bag bag = new Bag();
        Locker locker = new Locker(20);
        Receipt receipt = locker.save(bag);
        assertNotNull(receipt);
    }

    @Test
    void should_throw_exception_when_save_bag_given_locker_full() {
        Bag bag = new Bag();
        Locker locker = new Locker(1);
        locker.save(new Bag());
        Exception exception = assertThrows(Exception.class, () -> locker.save(bag));
        assertEquals("locker full", exception.getMessage());

    }

    @Test
    void should_return_one_bag_when_retrieve_bag_given_valid_receipt() {
        Locker locker = new Locker(20);
        Bag expectedBag = new Bag();
        Receipt receipt = locker.save(expectedBag);
        Bag actualBag = locker.retrieve(receipt);
        assertEquals(expectedBag, actualBag);
    }

    @Test
    void should_throw_exception_when_retrieve_bag_given_fake_receipt() {
        Locker locker = new Locker(20);
        Receipt receipt = new Receipt();
        Exception exception = assertThrows(Exception.class, () -> locker.retrieve(receipt), "invalid receipt");
    }

    @Test
    void should_throw_exception_when_retrieve_bag_given_used_receipt() {
        Locker locker = new Locker(20);
        Receipt receipt = locker.save(new Bag());
        locker.retrieve(receipt);

        Exception exception = assertThrows(Exception.class, () -> locker.retrieve(receipt), "invalid receipt");
    }
}
