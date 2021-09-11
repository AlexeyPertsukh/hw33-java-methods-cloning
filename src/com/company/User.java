package com.company;
//}
//	"projectName":"FaceBook",
//	"developer":
//		{
//		   "firstName": "Иван",
//		   "lastName": "Иванов",
//		   "address": {
//			   "streetAddress": "Московское ш., 101, кв.101",
//			   "city": "Ленинград",
//			   "postalCode": 101101
//		   },
//		   "phoneNumbers": [
//			   "812 123-1234",
//			   "916 123-4567"
//		    ]
//		}
//}
//Создать класс для этого json.
//Объект этого класса(Project).
//Создать копию(5-тю способами).

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Cloneable, Serializable {
    private String firstName;
    private String lastName;
    private Address address;
    private List<String> phoneNumbers;

    public User() {
    }

    public User(String firstName, String lastName, Address address, List<String> phoneNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

    public User(User from) {
        this.firstName = from.firstName;
        this.lastName = from.lastName;
        this.address = new Address(from.address);
        this.phoneNumbers = new ArrayList<>(from.phoneNumbers);
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.address = address.clone();
        user.phoneNumbers = new ArrayList<>();
        user.phoneNumbers.addAll(phoneNumbers);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }

}
