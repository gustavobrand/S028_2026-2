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
public class S028_aula01_creditcard_v02 {

 // Instance variables:
  private String customer;      // name of the customer (e.g., "John Bowman")
  private String bank;          // name of the bank (e.g., "California Savings")
  private String account;       // account identifier (e.g., "5391 0375 9387 5309")
  private int limit;            // credit limit (measured in dollars)  
  protected double balance;     // current balance (measured in dollars)
  private double taxaJurosMes;  // taxa de juros mensal cobrada em caso de atrasos

  // Constructors:
  /**
   * Constructs a new credit card instance.
   * @param cust        the name of the customer (e.g., "John Bowman")
   * @param bk          the name of the bank (e.g., "California Savings")
   * @param acnt        the account identifier (e.g., "5391 0375 9387 5309")
   * @param lim         the credit limit (measured in dollars)
   * @param initialBal  the initial balance (measured in dollars)
   */
  public S028_aula01_creditcard_v02(String cust, String bk, String acnt, int lim, double initialBal, double taxaJuros) {
    customer = cust;
    bank = bk;
    account = acnt;
    limit = lim;
    balance = initialBal;
    taxaJurosMes = taxaJuros;
  }

  /**
   * Constructs a new credit card instance with default balance of zero.
   * @param cust    the name of the customer (e.g., "John Bowman")
   * @param bk      the name of the bank (e.g., "California Savings")
   * @param acnt    the account identifier (e.g., "5391 0375 9387 5309")
   * @param lim     the credit limit (measured in dollars)
   */
  public S028_aula01_creditcard_v02(String cust, String bk, String acnt, int lim) {
    this(cust, bk, acnt, lim, 0.0, 10.0);               // use a balance of zero as default
  }

  // Accessor methods:
  /** Returns the name of the customer. */
  public String getCustomer() { return customer; }

  /** Returns the name of the bank */
  public String getBank() { return bank; }

  /** Return the account identifier. */
  public String getAccount() { return account; }

  /** Return the credit limit. */
  public int getLimit() { return limit; }

  /** Return the current balance. */
  public double getBalance() { return balance; }

  // Update methods:
  /**
   * Charges the given price to the card, assuming sufficient credit limit.
   * @param price  the amount to be charged
   * @return true  if charge was accepted; false if charge was denied
   */
  public boolean charge(double price) {               // make a charge    
    if (price + balance > limit) {                    // if charge would surpass limit
      System.out.println("Compra de R$" + price + " -- NEGADA");
      return false;                                   // refuse the charge
    } 
    System.out.println("Compra de R$" + price);
    // at this point, the charge is successful
    balance += price;                                 // update the balance
    return true;                                      // announce the good news
  }

  /**
   * Processes customer payment that reduces balance.
   * @param amount  the amount of payment made
   */
  public void makePayment(double amount) {            // make a payment
    System.out.println("Pagamento de R$" + amount);
    balance -= amount;
    
    // Exemplo de resolucao da atividade 01/T1, 1.1
    if (balance > 0) {
        balance *= (1+(taxaJurosMes/100));        
    }    
    
  }

  // Utility method to print a card's information
  public static void printSummary(S028_aula01_creditcard_v02 card) {
    System.out.print("Cliente = " + card.customer);
    //System.out.print(", Bank = " + card.bank);
    //System.out.println("Account = " + card.account);
    System.out.print(", Saldo = " + card.balance);  // implicit cast
    System.out.println(", Limite = " + card.limit);      // implicit cast
  }
  
  // Utility method to print this card's information
  public void printSummary() {
    System.out.print("Cliente = " + customer);
    //System.out.print(", Bank = " + bank);
    //System.out.println("Account = " + account);
    System.out.print(", Saldo = " + balance);  // implicit cast
    System.out.println(", Limite = " + limit);      // implicit cast
  }
  
  public static void main(String[] args) {
    CreditCardTop_v2 cartao01;
    cartao01 = new CreditCardTop_v2("Joao", "California Savings", "5391 0375 9387 5309");
    //wallet2 = new S028_aula01_creditcard_v02("Maria", "California Savings", "5391 0375 9387 5309", 1000, 0, 9.1);
    //wallet3 = new S028_aula01_creditcard_v02("Andre", "California Savings", "5391 0375 9387 5309", 1000, 0, 8.1);
    //wallet4 = new S028_aula01_creditcard_v02("Vicente", "California Savings", "5391 0375 9387 5309", 1000, 0, 7.5);
    //wallet5 = new S028_aula01_creditcard_v02("Luiza", "California Savings", "5391 0375 9387 5309", 1000, 0, 10.5);

    cartao01.charge(500);
    cartao01.printSummary();
    cartao01.charge(300);
    cartao01.printSummary();
    cartao01.charge(400);
    cartao01.printSummary();

    cartao01.makePayment(200);
    cartao01.printSummary();

    
    CreditCardGratuito cartao02 = new CreditCardGratuito("Maria", "California Savings", 
                                                         "abcd 1234 5668 6666");
    cartao02.charge(200);
    cartao02.charge(100);
    cartao02.charge(200);
    S028_aula01_creditcard_v02.printSummary(cartao02);
    cartao02.makePayment(100);
    S028_aula01_creditcard_v02.printSummary(cartao02);

  }
}
