package season7_test3.port;
import season7_test3.Boat;
import java.util.ArrayList;


//singleton Port
public class Port {
    //creating an array for 5 docks
    private Dock [] docks;
    private ArrayList<Package> packageLogs;
    private static final Port instance = new Port();
    public static int packageLimit = 0;

    private Port() {
        docks = new Dock[5];
        for (int i = 0; i < docks.length; i++) {
            //create new docks
            docks[i] = new Dock(i);
        }
        //creating 2 cranes
        Crane crane1 = new Crane("Crane 1");
        crane1.start();
        Crane crane2 = new Crane("Crane 2");
        crane2.start();
        //creating 2 storages

        packageLogs = new ArrayList<>();
    }

    public static Port getInstance() {
        return instance;
    }

    public void getOnDock(Boat boat, int id) {
        if (packageLimit >= 100){
            return;
        }
        System.out.println(id+"IIIIIIIIIIIIIIIIIDDDDDDDDDDDDDDDDD");
        docks[id].addBoat(boat);
    }
}
