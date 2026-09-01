/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dsaj.stacks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import net.datastructures.Stack;
import net.datastructures.LinkedStack;

/* Ordem: LIFO (Last in, first out)
 * Exemplo passo a passo:
 * 
 * funcao teste(String x) {
 * 		if (a[5] == b[3]) {
 * 			return;
 * 		}
 * }
 * 
 * Momentos da execucao:
 * ao encontrar 1o "(". pilha: (
 * ao encontrar 1o ")". pilha: 
 * ao encontrar 1o "{". pilha: {
 * ao encontrar 2o "(". pilha: {,(
 * ao encontrar 1o "[". pilha: {,(,[
 * ao encontrar 1o "]". pilha: {,(
 * ao encontrar 2o "[". pilha: {,(,[
 * ao encontrar 2o "]". pilha: {,(
 * ao encontrar 2o ")". pilha: {
 * ao encontrar 2o "{". pilha: {,{
 * ao encontrar 1o "}". pilha: {
 * ao encontrar 2o "}". pilha: 
 * 
 * */

/** Simplified test of matching delimiters in a string. */
public class MatchDelimiters {

  /** Tests if delimiters in the given expression are properly matched. */
  public static boolean isMatched(String expression) {
    final String opening = "({[<"; // opening delimiters
    final String closing = ")}]>"; // respective closing delimiters
    int closingElemIdx, openingElemIdx, count = 0;

    Stack<Character> buffer = new LinkedStack<Character>();
    for (char c : expression.toCharArray()) {
      if (opening.indexOf(c) != -1) { // this is a left delimiter
        buffer.push(c);
        System.out.println("Adicionado na stack = " + buffer.toString());

      } else {
        closingElemIdx = closing.indexOf(c);
        if (closingElemIdx != -1) { // this is a right delimiter
          System.out.println("Index of closing element: " + closingElemIdx + " = " + closing.charAt(closingElemIdx));
          if (buffer.isEmpty()) { // nothing to match with
            System.out.println("Erro 1");
            return false;
          } else {
            openingElemIdx = opening.indexOf(buffer.top());
            System.out.println("Current closing delim = " + c);
            System.out.println("Index of opening element: " + openingElemIdx + " = " + opening.charAt(openingElemIdx));
          }

          if (openingElemIdx == closingElemIdx) {
            buffer.pop();
            System.out.println("Removido elemento da stack = " + buffer.toString());
          } else {
            // if (closing.indexOf(c) != opening.indexOf(buffer.pop())
            System.out.println("Current char count: " + count);
            System.out.println("Erro 2");
            return false; // mismatched delimiter
          }
        }
        count++;
        // System.out.printf("%c", c);
      }
    }
    if (!buffer.isEmpty()) {
      System.out.println("Erro 3");
    }
    return buffer.isEmpty(); // were all opening delimiters matched?
  }

  public static void main(String[] args) throws IOException {
    // String fpath = "temp2.java";
    String fpath = "test.txt";
    BufferedReader br = new BufferedReader(new FileReader(fpath));
    String codigo;
    try {
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();
      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
      }
      codigo = sb.toString();
    } finally {
      br.close();
    }
    // int line = 0;
    // String codigo = "{([])}[]()";
    // String codigo = "{([])}[]()erro1)"; // erro 1: faltou alguma abertura
    // String codigo = "{([])}[}erro2()"; // erro 2: houve mismatch entre
    // abert/fechamento.
    // String codigo = "{erro3{([])}[]()"; // erro 3: faltou algum fechamento
    System.out.println("String analisada: " + codigo);
    if (isMatched(codigo)) {
      System.out.println("Tudo ok!");
    } else {
      System.out.println("Erro");
    }
  }
}
