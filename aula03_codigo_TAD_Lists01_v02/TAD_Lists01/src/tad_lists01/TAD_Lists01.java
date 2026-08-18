/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad_lists01;

// import com.sun.javafx.image.impl.IntArgb;
import net.datastructures.*;

/**
 *
 * @author brandg
 */
public class TAD_Lists01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("\nExemplo com Singly Linked List:");
        SinglyLinkedList<Integer> testsingle = new SinglyLinkedList<Integer>();
        testsingle.addLast(1);
        System.out.println(testsingle);
        testsingle.addLast(2);
        System.out.println(testsingle);
        testsingle.removeFirst();
        System.out.println(testsingle);
        testsingle.addLast(3);
        System.out.println(testsingle);
        testsingle.addFirst(0);
        System.out.println(testsingle);
        testsingle.removeFirst();
        System.out.println(testsingle);
        testsingle.addFirst(-1);
        System.out.println(testsingle);
        
        System.out.println("\nExemplo com Doubly Linked List:");
        DoublyLinkedList<Integer> testdouble = new DoublyLinkedList<Integer>();
        testdouble.addLast(1);
        System.out.println(testdouble);
        testdouble.addLast(2);
        System.out.println(testdouble);
        testdouble.addLast(3);
        System.out.println(testdouble);
        testdouble.addFirst(0);
        System.out.println(testdouble);
        testdouble.addFirst(-1);
        System.out.println(testdouble);
        testdouble.addFirst(-2);
        System.out.println(testdouble);
        testdouble.removeFirst();
        System.out.println(testdouble);
        testdouble.removeLast();
        System.out.println(testdouble);
        
        
    }
    
}
