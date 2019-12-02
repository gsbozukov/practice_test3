package season7_test3.port;
import season7_test3.Boat;
import season7_test3.Package;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


//singleton Port
public class Port {
    //creating an array for 5 docks
    private Dock [] docks;
    private ArrayList<Package> packageLogs;
    private static final Port instance = new Port();
    public AtomicInteger packageLimit = new AtomicInteger(0);

    private Port() {
        docks = new Dock[5];
        for (int i = 0; i < docks.length; i++) {
            //create new docks
            docks[i] = new Dock(i);
        }
        //creating 2 storages

        packageLogs = new ArrayList<>();
    }

    public static Port getInstance() {
        return instance;
    }

    public void getOnDock(Boat boat, int id) {
        if (packageLimit.get() >= 100){
            return;
        }
        System.out.println(id+"IIIIIIIIIIIIIIIIIDDDDDDDDDDDDDDDDD");
        docks[id].addBoat(boat);
    }

    public Boat unloadDocks (Crane crane){
        for (Dock dock : docks){
            if (!dock.isEmpty()){
                Boat boat = dock.unloadBoat();
                ArrayList<Package> packages = boat.getPackages();
                //get packages and stamp them w/ dock, crane and time
                for (Package p : packages){
                    packageLimit.incrementAndGet();
                    packageLogs.add(p);
                    p.unloadPackage(dock, crane, LocalTime.now());
                }
                return boat;
            }
        }
        return null;
    }
}
