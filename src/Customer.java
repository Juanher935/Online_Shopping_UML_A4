import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Customer extends Account {
    private Address address;
    private String phone;
    private String email;

    //Create empty Customer instance
    public Customer(){
        super();
        address = super.getBillingAddress();
    }

    //Create Customer instance
    public Customer(String p, String e){
        super();
        address = super.getBillingAddress();
        phone = p;
        email = e;
    }

    //Create web user customer
    public Customer(String webuser_login_id, String p, String e) {
        super(webuser_login_id);
        address = super.getBillingAddress();
        phone = p;
        email = e;
    }

    public void setShippingAddress(Address a){
        address = a;
    }

    //Register user as a web user
    public webUser registerAsWebUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println(this + ", please enter a username: ");
        String username = scan.nextLine();
        System.out.println(this + ", please enter a password: ");
        String password = scan.nextLine();
        scan.close();
        return new webUser(this, username, password);
    }

    public String toString() {
        return "Customer " + super.getId();
    }

    public String toStringFull() {
        return "Customer " + super.getId() + " (" + address + ", " + phone + ", " + email + ")";
    }
}
