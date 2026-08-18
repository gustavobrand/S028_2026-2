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
public class CreditCardPontosGenerico extends S028_aula01_creditcard_v02 {
    protected double pontos;
    protected double fatorConversao;
    protected String categoria;
            
    public CreditCardPontosGenerico(String cust, String bk, String acnt, int lim, 
            double initialBal, double taxaJuros, double ptos, double conversaoPtos, 
            String cat) {
        super(cust, bk, acnt, lim, initialBal, taxaJuros);
        pontos = ptos;
        fatorConversao = conversaoPtos;
        categoria = cat;
    }
  
    @Override
    public void makePayment(double amount) {
        super.makePayment(amount); 
        double ptos = amount * fatorConversao;
        pontos += ptos;
    }
    
    @Override
    public void printSummary() {
        super.printSummary(); 
        System.out.println("Pontos disponíveis no seu cartão " + categoria + ": " + pontos);
    }

}
