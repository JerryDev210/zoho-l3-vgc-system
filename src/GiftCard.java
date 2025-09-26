import java.util.ArrayList;
import java.util.List;

public class GiftCard {
    private static int cards = 1;
    private final int cardNo;
    private final Account acc;
    private int pin;
    private int balance;
    private int giftCardPoints;
    private Status status;
    private GiftCardType type;
    List<Transaction> transactions;
    public GiftCard(Account acc, int pin){
        cardNo=cards++;
        this.acc=acc;
        this.pin=pin;
        balance=0;
        giftCardPoints=0;
        status=Status.Active;
        type=GiftCardType.Silver;
        transactions = new ArrayList<>();
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    @Override
    public String toString() {
        return String.format("%7d %7d %4d %10d %10d %7s %7s",cardNo,acc.getCustomerID(),pin,balance,giftCardPoints,type,status);
    }
    public void topUp(int amount){
        balance+=amount;
    }
    public void spend(int amount){
        balance-=amount;
    }
    public int getCardNo() {
        return cardNo;
    }
    public void redeem(int points){
        giftCardPoints-=points;
    }
    public void addPoints(int points){
        giftCardPoints+=points;
        if(giftCardPoints>=200 && GiftCardType.Platinum != type){
            giftCardPoints=0;
            if(type==GiftCardType.Silver)
                type=GiftCardType.Gold;
            else if(type==GiftCardType.Gold)
                type=GiftCardType.Platinum;
        }
    }
    public Account getAcc() {
        return acc;
    }
    public boolean checkPin(int pin){
        return this.pin==pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
