public class Main {

    public static boolean whitebox = false;
    public static void main(String[] args)
    {
        System.out.println("Beginning the Black Box test: ");
        blackBoxTest();
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

    public static void blackBoxTest() {
        System.out.println("Creating some accounts: ");
        Customer[] customers = new Customer[3];

        for (int i = 0; i < customers.length; i++){
            customers[i] = new Customer("(925) 535-5266", "yes@gmail.com");
            System.out.println(customers[i] + " Customer number: " + i + "\n");
        }

        Product[] products = new Product[2];
        products[0] = new Product("One plus 8", "OnePlus");
        products[1] = new Product("Playstation 5", "Sony");

        for (Product product : products) {
            System.out.println(product + "\n");
        }

        Customer testCustomer = customers[0];

        testCustomer.getCart().addLineItems(new lineItem(1, products[1], new Price(499.99)));
        testCustomer.getCart().addLineItems(new lineItem(1, products[0], new Price(899.99)));
        System.out.println("The Customer has add " + products[0] + " and " + products[1] + " to their cart.");
        System.out.println("Here is their cart: ");
        System.out.println(testCustomer.getCart());

        testCustomer.setBilling_address(new Address("3999 Hayward St.", "Hayward","CA", "94555", "USA"));
        testCustomer.setShippingAddress(testCustomer.getBillingAddress());
        System.out.println("The customers Address Information: ");
        System.out.println(testCustomer.getBillingAddress());

        System.out.println("Now we empty the cart and close the account: ");

        testCustomer.getCart().makeEmpty();
        testCustomer.closeAccount();

        System.out.println("There Account is now closed and empty \n");
    }


}