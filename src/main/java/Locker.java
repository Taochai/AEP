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
        if (!lockerInfo.containsKey(receipt)) {
            throw new RuntimeException("invalid receipt");
        }
        availableCapacity++;
        return lockerInfo.remove(receipt);
    }

    public boolean isFull() {
        return availableCapacity == 0;
    }

    public boolean hasReceipt(Receipt receipt) {
        return lockerInfo.containsKey(receipt);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public Map<Receipt, Bag> getLockerInfo() {
        return lockerInfo;
    }

    public void setLockerInfo(Map<Receipt, Bag> lockerInfo) {
        this.lockerInfo = lockerInfo;
    }
}
