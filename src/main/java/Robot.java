import java.util.List;

public class Robot {
    private final List<Locker> managedLockers;

    public Robot(List<Locker> managedLockers) {
        this.managedLockers = managedLockers;
    }

    public Receipt save(Bag bag) {
        for (Locker locker : this.managedLockers) {
            if (!locker.isFull()) {
                return locker.save(bag);
            }
        }
        throw new RuntimeException("all lockers full");
    }

    public Bag retrieve(Receipt receipt) {
        for (Locker locker : managedLockers) {
            if (locker.hasReceipt(receipt)) {
                return locker.retrieve(receipt);
            }
        }
        return null;
    }
}
