import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        VGCSystem vgcSystem = new VGCSystem();
        Scanner in = new Scanner(System.in);
        vgcSystem.displayAccounts();
        vgcSystem.displayCards();
//        vgcSystem.displayAccounts();
        System.out.println("1.Create Card 2.Purchase 3.Topup 4.Block/UnBlock card 5.Close card 6.View Accounts \n" +
                "7. View Cards 8.View Transactions 9. Create new Customer Account 10.Exit");
        int choice;
        do {
            System.out.print("Enter Option:");
            choice=in.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter Customer ID:");
                    int id = in.nextInt();
                    System.out.print("Enter Pin:");
                    int pin = in.nextInt();
                    System.out.print("Enter Initial Amount:");
                    int amount = in.nextInt();
                    vgcSystem.addCard(vgcSystem.accounts.get(id),amount,pin );
                    break;
                case 2:
                    System.out.print("Enter Card ID:");
                    int cardID = in.nextInt();
                    System.out.print("Enter Card PIN:");
                    pin = in.nextInt();
                    System.out.print("Enter Amount:");
                    amount=in.nextInt();
                    vgcSystem.purchase(cardID,amount,pin);
                    break;
                case 3:
                    System.out.print("Enter Card ID:");
                     cardID = in.nextInt();
                    System.out.print("Enter Card PIN:");
                    pin = in.nextInt();
                    System.out.print("Enter Amount:");
                    amount=in.nextInt();
                    vgcSystem.topUpCard(cardID,amount,pin);
                    break;
                case 4:
                    System.out.print("Enter Card ID to Block:");
                    cardID = in.nextInt();
                    vgcSystem.blockOrUnblock(cardID);
                    break;
                case 5:
                    System.out.print("Enter Card ID to Close:");
                    cardID = in.nextInt();
                    vgcSystem.closeCard(cardID);
                    break;
                case 6:
                    vgcSystem.displayAccounts();break;
                case 7:
                    vgcSystem.displayCards();break;
                case 8:
                    vgcSystem.displayTransactions();break;
                case 9:
                    System.out.print("Enter the Amount for new Customer:");
                    amount=in.nextInt();
                    vgcSystem.newAccount(amount);
            }
        }while(choice!=10);
    }
}
