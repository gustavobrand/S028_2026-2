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
public class CreditCardGratuito extends S028_aula01_creditcard_v02 {
    
    public CreditCardGratuito(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
    }
    
    public CreditCardGratuito(String cust, String bk, String acnt) {
        super(cust, bk, acnt, 500, 0.0, 10.0);               
    }
    
}
