import java.util.*;

public class Account {
    private static int customers=1;
    private final int customerID;
    private int balance;
    private final List<GiftCard> giftCards;

    public Account(int balance){
        this.customerID=customers++;
        this.balance=balance;
        this.giftCards=new ArrayList<>();
    }

    public String toString(){
        return String.format("%11d %10d",customerID,balance);
    }
    public void withrawal(int amount){
        balance-=amount;
    }
    public void credit(int amount){
        balance+=amount;
    }
    public int getCustomerID() {
        return customerID;
    }

    public int getBalance() {
        return balance;
    }

    public void addCard(GiftCard card){
        giftCards.add(card);
    }
    public List<GiftCard> getGiftCards(){
        return giftCards;
    }
}
