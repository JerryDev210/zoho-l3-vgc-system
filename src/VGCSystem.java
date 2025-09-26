import java.util.*;
public class VGCSystem {
    HashMap<Integer,Account> accounts;
    HashMap<Integer,GiftCard> giftCards;
    HashSet<Transaction> transactions;
    public VGCSystem(){
        accounts=new HashMap<>();
        giftCards= new HashMap<>();
        transactions = new LinkedHashSet<>();
        initializeSystem();
    }
    void initializeSystem(){
        for(int i=0;i<3;i++){
            Account account = new Account(6000);
            accounts.put(account.getCustomerID(),account);
//            for(int j=0;j<=i;j++){
                addCard(account,6000/(i+1),1100+(i*10)+1);
//            }
        }
    }
    void newAccount(int amount){
        Account account = new Account(amount);
        accounts.put(account.getCustomerID(),account);
        System.out.println("New Account Created "+account);
    }
    void addCard(Account acc , int amount, int pin){
        if(acc==null){
            System.out.println("Unknown Account id");
            return;
        }
        int accBalance = acc.getBalance();
        if(accBalance>= amount && amount<0){
            GiftCard card = new GiftCard(acc,pin);
            acc.withrawal(amount);
            card.topUp(amount);
            acc.addCard(card);
            giftCards.put(card.getCardNo(), card);
            System.out.println("New Card Added "+card);
        }else{
            System.out.println("Insufficient Balance in Account");
        }
    }
    void topUpCard(int cardId , int amount, int pin){
        GiftCard card = giftCards.get(cardId);
        if(! isCardValid(card,pin)) return;
        Account acc= card.getAcc();
        int accBalance = acc.getBalance();
        if(accBalance>= amount && amount!=0){
            acc.withrawal(amount);
            card.topUp(amount);
//            acc.addCard(card);
//            giftCards.put(card.getCardNo(), card);
            displayCards();
        }else{
            System.out.println("Insufficient Balance in Account");
        }
    }
    void purchase(int cardID, int amount, int pin){
        GiftCard card = giftCards.get(cardID);
        if(!isCardValid(card,pin)) return;
        if(amount<=card.getBalance()){
            Transaction transaction= new Transaction(cardID,amount);
            card.spend(amount);
            card.addPoints((amount/500)*50);
            transactions.add(transaction);
            card.addTransaction(transaction);
            System.out.println(transaction);
        }else {
            System.out.print("InSufficient Balance on Cards");
        }
    }
    private boolean isCardValid(GiftCard card,int pin){

        if(card==null){
            System.out.println("Unknown Gift Card ID");
            return false;
        }
        if (card.getStatus()!=Status.Active){
            System.out.println("Card is "+card.getStatus());
            return false;
        }
        if(!card.checkPin(pin)){
            System.out.println("PIN invalid");
            return false;
        }
        return true;
    }
    public void blockOrUnblock(int cardId){
        GiftCard card = giftCards.get(cardId);
        if(card==null){
            System.out.println("Unknown Gift Card ID");
            return;
        }
        if(card.getStatus()==Status.Closed){
            System.out.print("Card Closed, No Operations Allowed");
            return;
        }
        card.setStatus(card.getStatus()==Status.Blocked ?Status.Active:Status.Blocked);
    }
    public void closeCard(int cardId){
        GiftCard card = giftCards.get(cardId);
        if(card==null){
            System.out.println("Unknown Gift Card ID");
            return;
        }
        card.getAcc().credit(card.getBalance());
        card.spend(card.getBalance());
        card.setStatus(Status.Closed);
    }
    public void displayTransactions(){
        System.out.printf("%5s %5s %10s\n","TXNno","CardNo","Amount");
        for(Transaction transaction : transactions)
            System.out.println(transaction);
    }
    public void displayAccounts(){
        System.out.printf("%11s  %10s","Customer ID","Balance\n");
        for(Account account : accounts.values())
            System.out.println(account);
        System.out.println("================");
    }
    public void displayCards(){
        System.out.printf("%7s %7s %4s %10s %10s %7s %7s\n","Card No","Cust ID","PIN","Balance","Points","Type","Status");
        for(GiftCard giftCard: giftCards.values())
            System.out.println(giftCard);
        System.out.println("================");
    }
}
