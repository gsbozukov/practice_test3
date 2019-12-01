package season7_test3;
import season7_test3.port.Crane;
import season7_test3.port.Dock;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Package {
    public static AtomicInteger globalID = new AtomicInteger(0);
    private int id;
    private Dock dock;
    private Boat boat;
    private Crane crane;
    private LocalTime unloadTime;

    public Package(Boat boat) {
        this.id = globalID.getAndIncrement();
        //comes from boat
        this.boat = boat;
    }
    public void unloadPackage (Dock dock, Crane crane, LocalTime time){
        //comes from port when crane is unloading
        this.dock = dock;
        this.crane = crane;
        this.unloadTime = time;
    }

    @Override
    public String toString() {
        return "Package{" +
                "ID=" + id +
                ", dock=" + dock +
                ", boat=" + boat +
                ", crane=" + crane +
                ", unloadTime=" + unloadTime +
                '}';
    }
}
