import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> fila = new LinkedList<>();

        try {
            // FIFO
            fila.add(5);
            fila.add(10);
            fila.add(8);
            fila.add(7);
            while (!fila.isEmpty()) {
                System.out.println(fila.remove());
            }
            fila.remove();
        } catch (Exception e) {
            System.out.println("Problema encontrado na fila!");
            // System.out.println(e.getMessage());
            // e.printStackTrace();
        }

        // Como tratar um erro com o pool e sem excessoes
        // fila.offer(5);
        // fila.offer(10);
        // fila.offer(8);
        // fila.offer(7);
        // while (!fila.isEmpty()) {
        //     System.out.println(fila.poll());
        // }
        // if (fila.poll() == null) {
        //     System.out.println("Problema encontrado na fila com poll!");
        // }
    }
}
