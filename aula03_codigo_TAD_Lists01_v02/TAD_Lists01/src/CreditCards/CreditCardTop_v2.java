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
public class CreditCardTop_v2 extends CreditCardPontosGenerico {

    public CreditCardTop_v2(String cust, String bk, String acnt, int lim, 
            double initialBal, double taxaJuros, double ptos, 
            double conversaoPtos, String cat) {
        
        super(cust, bk, acnt, lim, initialBal, taxaJuros, ptos, conversaoPtos, cat);
    }
    
    public CreditCardTop_v2(String cust, String bk, String acnt) {
        this(cust, bk, acnt, 10000, 0.0, 2, 0, 1.5, "Top");
    }
    
}
