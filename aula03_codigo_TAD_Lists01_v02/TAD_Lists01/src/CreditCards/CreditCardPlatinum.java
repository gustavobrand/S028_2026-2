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
public class CreditCardPlatinum extends S028_aula01_creditcard_v02 {
    protected double pontos;
            
    public CreditCardPlatinum(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros, double ptos) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
        pontos = ptos;
    }
    
    public CreditCardPlatinum(String cust, String bk, String acnt) {
        this(cust, bk, acnt, 5000, 0.0, 5, 0);
    }
    
    @Override
    public void makePayment(double amount) {
        super.makePayment(amount); 
        double ptos = amount * 0.7;
        pontos += ptos;
    }

    @Override
    public void printSummary() {
        super.printSummary(); //To change body of generated methods, choose Tools | Templates.        
        System.out.println("Pontos disponíveis no seu cartão Platinum: " + pontos);
    }

}
