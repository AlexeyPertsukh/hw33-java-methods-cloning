import java.io.Serializable;

public class Address implements Cloneable, Serializable {
    private final String streetAddress;
    private final String city;
    private final int postalCode;

    public Address(String streetAddress, String city, int postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Address(Address from) {
        this.streetAddress = from.streetAddress;
        this.city = from.city;
        this.postalCode = from.postalCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
