import java.util.Date;

enum OrderStatus{
    NEW, HOLD, SHIPPED, DELIVERED, CLOSED
}

public class Order {
    ID number;
    Date ordered;
    Date shipped;
    Address shipTo;
    OrderStatus status;
    float total;
}
