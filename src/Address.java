public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    /**
     * Create empty instance of Address
     */
    public Address() {
        street = "";
        city = "";
        state = "";
        zipcode = "";
        country = "";
    }


    public Address(String streetName, String cityName, String stateName, String zipcodeNum, String countryName) {
        street = streetName;
        city = cityName;
        state = stateName;
        zipcode = zipcodeNum;
        country = countryName;
    }

    public String toString() {
        if(street == "")
            return "[No Address]";
        return street + ", " + city + ", " + state + ", " + zipcode + ", " + country;
    }
}