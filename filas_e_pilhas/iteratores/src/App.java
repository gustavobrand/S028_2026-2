import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(5);
        t1.add(15);
        t1.add(25);
        t1.add(35);
        
        LinkedList<Integer> t2 = new LinkedList<>();
        t2.add(10);
        t2.add(20);
        t2.add(30);
        t2.add(40);
        
        HashSet<Integer> t3 = new HashSet<>();
        t3.add(50);
        t3.add(60);
        t3.add(70);
        t3.add(80);

        // Iterator<Integer> it = t1.iterator();
        // System.out.print("Arraylist: ");          
        // Iterator<Integer> it = t2.iterator();
        // System.out.print("LinkedList: ");               
        Iterator<Integer> it = t3.iterator();
        System.out.print("Hastset: ");        
        while (it.hasNext()) {
            System.out.print(it.next());
            if (it.hasNext()) {
                System.out.print(",");
            } else {
                System.out.print("\n");
            }
        }    
    }
}
