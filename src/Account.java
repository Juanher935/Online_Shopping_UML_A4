import java.util.Date;

public class Account {
    private String id;
    private Address billing_address;
    private boolean is_closed;
    private Date open;
    private Date closed;

    private shoppingCart cart;
    private Order[] orders;

    private int orderSize = 0;
    private static long idCounter = 0;

    private static synchronized String createID(){
        return String.valueOf(idCounter++);
    }

    //Create an account
    public Account(){
        id = createID();
        is_closed = false;
        open = new Date();
        cart = new shoppingCart();
        orders = new Order[100];
        if (Main.whitebox) System.out.println("Empty Account: " + this);
    }

    //Create an account with web user info
    public Account(String webuser_login_id) {
        id = webuser_login_id;
        is_closed = false;
        open = new Date();
        cart = new shoppingCart();
        orders = new Order[100];
        if(Main.whitebox) System.out.println("Account WebUser info: " + this);
    }

    //Create an account with address parameter
    public Account(Address a) {
        id = createID();
        billing_address = a;
        is_closed = false;
        open = new Date();
        cart = new shoppingCart();
        orders = new Order[100];
        if(Main.whitebox) System.out.println("Account Address Info: " + this);
    }

    //return ID
    public String getId(){
        return id;
    }

    //list orders from account
    public Order[] getOrders(){
        return orders;
    }

    //Return shopping Cart
    public shoppingCart getCart() {
        return cart;
    }

    //Set ID
    public void setId(String i) {
        id = i;
    }

    //set Address
    public void setBilling_address(Address a) {
        billing_address = a;
    }

    //get the number of orders in the account
    public int getOrderSize() {
        return orderSize;
    }

    //Create a new order
    public Order createOrder() {
        Order order = new Order();
        order.convertCartToOrder(this);
        orders[orderSize] = order;
        orderSize++;
        return order;
    }

    //Return address set as billing address
    public Address getBillingAddress() {
        return billing_address;
    }

    //Close Account
    public void closeAccount() {
        closed = new Date();
        is_closed = true;
    }

    public String toString() {
        if(is_closed)
            return "Account " + id + " (" + billing_address + ", " + orderSize + " orders, " + " opened " + open + ", closed " + closed + ")";
        return "Account " + id + " (" + billing_address + ", " + orderSize + " orders, " + " opened " + open + ")";
    }
}
