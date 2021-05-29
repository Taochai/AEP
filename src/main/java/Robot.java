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
        return null;
    }
}
