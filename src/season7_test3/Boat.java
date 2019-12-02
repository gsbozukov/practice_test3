package season7_test3;

import season7_test3.port.Port;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Boat extends Thread{
    //same port for everyone
    public Port mainPort;
    public static AtomicInteger globalID = new AtomicInteger(0);
    private String name;
    private ArrayList<Package> packages = new ArrayList<>();
    private boolean isUnloaded;

    //create a boat, automatically generates a package

    public Boat() {
        this.name = "Boat"+globalID.incrementAndGet();
        mainPort = Port.getInstance();
        System.out.println("MY PORT IS "+this.mainPort);
        this.isUnloaded = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < (new Random().nextInt(4)+1); i++) {
            Package p = new Package(this);
            packages.add(p);
        }
        Random r = new Random();
        mainPort.getOnDock(this, r.nextInt(5));
        while (!isUnloaded){
            //keep existing
        }
    }

    public ArrayList<Package> getPackages() {
        return packages;
    }

    public void unloadPackages() {
        this.isUnloaded = true;
    }
}
