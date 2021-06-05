import java.util.List;

public class SmartRobot extends Robot {

    public SmartRobot(List<Locker> managedLockers) {
        super(managedLockers);
    }

    @Override
    public Receipt save(Bag bag) {

        managedLockers.sort((locker1, locker2) -> locker2.getAvailableCapacity() - locker1.getAvailableCapacity());
        return managedLockers.get(0).save(bag);

    }
}
