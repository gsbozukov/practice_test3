package season7_test3.port;
import season7_test3.Boat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Dock {
    private int id;
    private BlockingQueue<Boat> queue = new LinkedBlockingQueue<>(5);


    public Dock(int id) {
        this.id = id;
        //add this to queue and remove from queue
    }
    public void addBoat(Boat boat){
        try {
            queue.put(boat);
            System.out.println("Adding boat "+ boat.getName()+ " to dock "+this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Boat unloadBoat (){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("WTFFFFFFFFFFFFFFFF DOCK IS BROCKEN "+this.id);
        }
        //if something went wrong return null
        return null;
    }
    public boolean isEmpty (){
        return this.queue.isEmpty();
    }
}
