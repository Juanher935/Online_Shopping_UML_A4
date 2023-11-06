public class lineItem {
    private int quantity;
    private Price price;
    private Product product;

    public lineItem (int q, Product pr, Price p) {
        quantity = q;
        product = pr;
        price = p;
    }

    //get Total
    public double getTotal(){
        return price.getAmount() * quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public Price getPrice() {
        return price;
    }

    public String toString() {
        return quantity + "x " + product +  " at " + price + ", total: " + getTotal() + " USD";
    }
}
