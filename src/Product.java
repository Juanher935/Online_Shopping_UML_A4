public class Product {
    private String id;
    private String name;
    private String supplier;

    private static long idCounter = 0;

    private static synchronized String createID() {
        return String.valueOf(idCounter++);
    }

    //Create product
    public Product(String n, String s) {
        id = createID();
        name = n;
        supplier = s;
    }

    public String toString() {
        return "Product " + id + " (" + name + " from " + supplier + ")";
    }
}
