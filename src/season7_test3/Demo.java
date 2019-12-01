package season7_test3;

import season7_test3.port.Port;

public class Demo {
    public static void main(String[] args) {

        //sending ships non stop every 1 sec, until we fill 100 packages
        while (Port.packageLimit<=100){
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
