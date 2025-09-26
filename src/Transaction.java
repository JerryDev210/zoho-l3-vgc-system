import java.util.Objects;

public class Transaction {
    static int transactions = 1;
    private final int txnNo;
    private final int cardNo;
    private final int amount;
    public Transaction(int cardNo, int amount){
        this.txnNo= transactions++;
        this.cardNo=cardNo;
        this.amount=amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(txnNo);
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override
    public String toString() {
        return String.format("%5d %5d %10d",txnNo,cardNo, amount);
    }
}
