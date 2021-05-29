public class Locker {
    private final int capacity;
    private int availableCapacity;

    public Locker(int capacity) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
    }

    public Receipt save(Bag bag) {
        if (availableCapacity <= 0) {
            throw new RuntimeException("locker full");
        }
        availableCapacity--;
        return new Receipt();
    }

    public Bag retrieve(Receipt receipt) {
        return new Bag();
    }
}
