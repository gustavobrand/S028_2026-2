import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static int somadorRecursivo (ArrayList<Integer> a, int pos) {
        if (a.size() == pos) {
            System.out.println("Retornando 0 para o caso base");
            return 0;
        } else {
            System.out.println("Pos = "+pos + ", get: "+a.get(pos));
            int proxPosicao = pos+1;
            return a.get(pos) + somadorRecursivo(a, proxPosicao);
        }
    }

    public static int contadorRecursivo (ArrayList<Integer> a, int pos) {
        if (a.size() == pos) {
            System.out.println("Retornando 0 para o caso base");
            return 0;
        } else {
            System.out.println("Pos = "+pos + ", get: "+a.get(pos));
            int proxPosicao = pos+1;
            return 1 + contadorRecursivo(a, proxPosicao);
        }
    }

    public static void ReverseArray(ArrayList<Integer> vetor, int i, int j) {
        // int temp;
        if (i < j) {
            // temp = vetor.get(i);
            // vetor.set(i, vetor.get(j));
            // vetor.set(j, temp);
            Collections.swap(vetor, i, j);
            
            System.out.println("i="+i+", vetor atual: "+vetor);
            ReverseArray(vetor, i+1, j-1);
        }
        System.out.println("i="+i+". Vou retornar agora");
        return;
    }

    public static void main(String[] args) throws Exception {
        // ArrayList<Integer> lista = new ArrayList<Integer>();
        // lista.add(5);
        // lista.add(4);
        // lista.add(3);
        // int soma = somadorRecursivo(lista, 0);
        // System.out.println("Somatorio da lista: " + soma);
        // int contagem = contadorRecursivo(lista, 0);
        // System.out.println("Contagem da lista: " + contagem);

        ArrayList<Integer> vet = new ArrayList<Integer>();
        vet.add(3);
        vet.add(2);
        vet.add(4);
        vet.add(1);
        vet.add(7);
        vet.add(6);
        vet.add(10);
        vet.add(20);

        System.out.println("Antes da inversao:" + vet);
        ReverseArray(vet, 0, vet.size()-1);
        System.out.println("Depois da inversão:" + vet);
    }
}
