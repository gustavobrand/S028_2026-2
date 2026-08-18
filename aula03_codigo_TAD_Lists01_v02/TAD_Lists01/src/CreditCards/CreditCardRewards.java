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
public class CreditCardRewards extends S028_aula01_creditcard_v02 {
            
    public CreditCardRewards(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
    }
    
    public CreditCardRewards(String cust, String bk, String acnt) {
        super(cust, bk, acnt, 1000, 0.0, 8);
    }
    
    @Override
    public void makePayment(double amount) {
        super.makePayment(amount); 
        double cashback = amount * (1.5/100);
        balance -= cashback;
    }

}
