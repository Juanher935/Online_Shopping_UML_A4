import java.util.Date;
public class shoppingCart {
    private Date created;
    private int cartSize;
    private lineItem[] line_items;

    //create empty shopping cart
    public shoppingCart() {
        created = new Date();
        line_items = new lineItem[100];
        cartSize = 0;
    }

    //add line items to the cart
    public void addLineItems (lineItem item){
        line_items[cartSize] = item;
        cartSize++;
    }

    //get line items in the cart
    public lineItem[] getItems() {
        return line_items;
    }

    //get amount of items in the cart
    public int getCartSize() {
        return cartSize;
    }

    //Delete items from cart
    public void makeEmpty(){
        cartSize = 0;
        line_items = new lineItem[100];
    }

    public String toString() {
        String out = "";
        for(int i=0; i<cartSize; i++) {
            out += (line_items[i] + "\n");
        }
        return out;
    }

}
