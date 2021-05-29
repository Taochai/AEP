import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LockerTest {

    @Test
    void should_return_receipt_when_save_bag_given_available_locker() {
        Bag bag = new Bag();
        Locker locker = new Locker();
        Receipt receipt = locker.save(bag);

        assertNotNull(receipt);
    }

    @Test
    void should_throw_exception_when_save_bag_given_locker_full(){
        Bag bag = new Bag();
        Locker locker = new Locker();

        assertThrows(Exception.class, () -> locker.save(bag));
        assertEquals(new Exception("Locker Full"), locker.save(bag));
    }
}
