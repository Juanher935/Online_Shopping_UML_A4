public class Main {

    public static boolean whitebox = false;
    public static void main(String[] args)
    {
        System.out.println("White box test of Account class");
        whitebox = true;
        whiteBoxTest();
    }

    public static void whiteBoxTest() {
        System.out.println("\nCreation of 3 accounts");
        Account account = new Account();
        Account account1 = new Account("chaos115");
        Account account2 = new Account(new Address("303 Yeet", "Hayward", "CA", "94565", "USA"));
        account2.getId();
        account2.getBillingAddress();
        account2.getCart();
        account2.toString();
        account2.createOrder();
        account2.closeAccount();
    }

}