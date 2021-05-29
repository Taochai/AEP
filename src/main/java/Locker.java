import java.util.HashMap;
import java.util.Map;

public class Locker {
    private final int capacity;
    private int availableCapacity;
    private Map<Receipt, Bag> lockerInfo;

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
        this.lockerInfo = new HashMap<>();
    }

    public Receipt save(Bag bag) {
        if (availableCapacity <= 0) {
            throw new RuntimeException("locker full");
        }
        availableCapacity--;

        Receipt receipt = new Receipt();
        lockerInfo.put(receipt, bag);
        return receipt;
    }

    public Bag retrieve(Receipt receipt) {
        if (receipt instanceof FakeReceipt) {
            throw new RuntimeException("fake receipt");
        }
        if (!lockerInfo.containsKey(receipt)) {
            throw new RuntimeException("used receipt");
        }
        Bag bag = lockerInfo.get(receipt);
        lockerInfo.remove(receipt);
        return bag;
    }
}
