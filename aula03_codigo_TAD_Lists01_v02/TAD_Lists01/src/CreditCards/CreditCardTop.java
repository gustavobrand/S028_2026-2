/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreditCards;

/**
 *
 * @author brandg
 */
public class CreditCardTop extends S028_aula01_creditcard_v02 {
    protected double pontos;
            
    public CreditCardTop(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros, double ptos) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
        pontos = ptos;
    }
    
    public CreditCardTop(String cust, String bk, String acnt) {
        this(cust, bk, acnt, 10000, 0.0, 2, 0);
    }
    
    @Override
    public void makePayment(double amount) {
        super.makePayment(amount); 
        double ptos = amount * 1.5;
        pontos += ptos;
    }
    
    @Override
    public void printSummary() {
        super.printSummary(); //To change body of generated methods, choose Tools | Templates.        
        System.out.println("Pontos disponíveis no seu cartão Top: " + pontos);
    }


}
