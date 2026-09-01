import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {

    // Trata a pilha vazia com excessao (pop lanca EmptyStackException)
    static Integer popComExcecao(Stack<Integer> pilha) {
        try {
            return pilha.pop();
        } catch (Exception e) {
            System.out.println("Problema encontrado na pilha com pop!");
            return null;
        }
    }

    // Trata a pilha vazia sem excessao, retornando null (estilo poll)
    static Integer popSemExcecao(Stack<Integer> pilha) {
        if (pilha.isEmpty()) {
            return null;
        }
        return pilha.pop();
    }

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
        //System.out.println(e.getMessage());
        //e.printStackTrace();
    }
    
    // Como tratar um erro com o pool e sem excessoes
    fila.offer(5);
    fila.offer(10);
    fila.offer(8);
    fila.offer(7);
    while (!fila.isEmpty()) {
        System.out.println(fila.poll());
    }
    if (fila.poll() == null) {
        System.out.println("Problema encontrado na fila com poll!");
    }

    // LIFO - usando as duas funcoes da Stack
    Stack<Integer> pilha = new Stack<>();
    pilha.push(5);
    pilha.push(10);
    pilha.push(8);
    pilha.push(7);
    while (!pilha.isEmpty()) {
        System.out.println(popComExcecao(pilha));
    }
    popComExcecao(pilha);

    pilha.push(5);
    pilha.push(10);
    pilha.push(8);
    pilha.push(7);
    while (!pilha.isEmpty()) {
        System.out.println(popSemExcecao(pilha));
    }
    if (popSemExcecao(pilha) == null) {
        System.out.println("Problema encontrado na pilha com pop sem excessao!");
    }
    }
}
