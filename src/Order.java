import java.util.Date;

enum OrderStatus{
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED
}

public class Order {
    private String number;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private double total;
    private lineItem[] line_items;
    private int orderSize;
    private Payment[] payments;
    private int paymentsSize;

    //Create Unique ID
    private static long idCounter = 0;
    private static synchronized String createID() {
        return String.valueOf(idCounter++);
    }

    //Create Order
    public Order() {
        number = createID();
        ordered = new Date();
        status = OrderStatus.NEW;
        orderSize = 0;
        line_items = new lineItem[100];
        payments = new Payment[100];
    }

    //Add line item to order
    public void addLineItem (lineItem item){
        line_items[orderSize] = item;
        orderSize++;
        total += item.getTotal();
    }

    //Add payment to order
    public void addPayment (Payment payment) {
        payments[paymentsSize] = payment;
        paymentsSize++;
    }

    //Add items from cart to order
    public void convertCartToOrder(Account account) {
        shoppingCart cart = account.getCart();
        ship_to = account.getBillingAddress();
        for(int i=0; i<cart.getCartSize(); i++) {
            addLineItem(cart.getItems()[i]);
        }
        cart.makeEmpty();
    }

    //get order number
    public String getNumber(){
        return number;
    }

    //Get order status

    public OrderStatus getStatus() {
        return status;
    }

    public void setClosed() {

        status = OrderStatus.CLOSED;
    }

    public void setDelivered() {

        status = OrderStatus.DELIVERED;
    }

    public void setHold() {

        status = OrderStatus.HOLD;
    }

    public void setShipped() {

        status = OrderStatus.SHIPPED;
    }


    public String toString() {
        String out = "Order Number " + number + "\nStatus: " + status + "\nShpping Address: " + ship_to + "\nTotal: " + total + "\n";
        for(int i=0; i<orderSize; i++) {
            out += (line_items[i] + "\n");
        }
        out += "Payments: \n";
        if(paymentsSize == 0)
            out += "None. \n";

        for(int i=0; i<paymentsSize; i++) {
            out += (payments[i] + "\n");
        }
        return out;
    }
}
