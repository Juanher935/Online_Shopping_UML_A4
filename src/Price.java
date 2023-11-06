public class Price {
    private double amount;

    //Create price
    public Price(double a) {
        amount = a;
    }

    //get the price
    public double getAmount(){
        return amount;
    }

    public String toString() {
        return amount + " " ;
    }
}
