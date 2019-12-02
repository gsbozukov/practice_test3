package season7_test3;

import season7_test3.port.Crane;
import season7_test3.port.Port;

public class Demo {
    public static void main(String[] args) {
        Port port = Port.getInstance();
        //creating 2 cranes
        Crane crane1 = new Crane("Crane 1");
        crane1.start();
        Crane crane2 = new Crane("Crane 2");
        crane2.start();
        //sending ships non stop every 1 sec, until we fill 100 packages
        while (port.packageLimit.get()<=100){
            for (int i = 0; i < 5; i++) {
                Boat boat = new Boat();
                boat.start();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
