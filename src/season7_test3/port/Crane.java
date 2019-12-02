package season7_test3.port;

import season7_test3.Boat;
import season7_test3.Package;

import java.util.ArrayList;

public class Crane extends Thread{
    private String craneID;
    public Port port;

    public Crane(String craneID) {
        this.craneID = craneID;
        port = Port.getInstance();
    }

    @Override
    public void run() {
        while (true){
            if (port.packageLimit.get()>=100){
                return;
            }
            //unloading boat
            //todo ASK KRASI WHY ON EARTH DO I HAVE A NULL POINTER EXCEPTION IF THE PORT CREATES THE CRANES???????????????????????????????????
            Boat boat = this.port.unloadDocks(this);
            //if boat is not null
            if (boat != null){
                //how much time should i sleed
                try {
                    System.out.println("----- Crane "+this.craneID+" is unloading "+ boat);
                    ArrayList<Package> packages = boat.getPackages();
                    Storage.addToStorage(packages);
                    boat.unloadPackages();
                    System.out.println(port.packageLimit.get()+"=======================================================");
                    Thread.sleep(boat.getPackages().size()*2*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
