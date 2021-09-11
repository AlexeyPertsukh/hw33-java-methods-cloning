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


import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int KEY_SIMPLE = 1;
    private static final int KEY_CONSTRUCTOR = 2;
    private static final int KEY_CLONE = 3;
    private static final int KEY_SERIALIZABLE = 4;
    private static final int KEY_JSON = 5;

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    User user1;
    User user2;
    int command;

    private void start(){
        System.out.println("Клонирование объекта разными способами");
        createUsers();
        printUsers();

        System.out.println();

        inputCommand();
        executeCommand();

//        user1.addPhoneNumber("1111");
//        printUsers();

    }

    private void createUsers() {
        Address address = new Address("Московское ш., 101, кв.101", "Ленинград", 101101 );
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("812 123-1234");
        phoneNumbers.add("916 123-4567");

        user1 = new User("Иван","Иванов", address, phoneNumbers);
        user2 = new User();
    }

    private void inputCommand() {
        System.out.println(KEY_SIMPLE +" - простое клонирование");
        System.out.println(KEY_CONSTRUCTOR +" - клонировать через конструктор");
        System.out.println(KEY_CLONE + " - клонировать через clone()");
        System.out.println(KEY_SERIALIZABLE + " - клонировать через Serializable");
        System.out.println(KEY_JSON + " - клонировать через Json");

        command = Util.nextInt("Введите команду: ", 1,5);
        System.out.println();

    }

    private void executeCommand() {
        if(command == KEY_SIMPLE) {
            cloneSimple();
        } else if(command == KEY_CONSTRUCTOR) {
            cloneFromConstructor();
        } else if(command == KEY_CLONE) {
            cloneFromMethodClone();
        } else if(command == KEY_SERIALIZABLE) {
            cloneFromSerializable();
        }  else if(command == KEY_JSON) {
            cloneFromJson();
        }

    }


    private void cloneSimple() {
        System.out.println("простое клонирование");

        String firstName1 = user1.getFirstName();
        String lastName1 = user1.getLastName();

        List<String> phoneNumbers2 = new ArrayList<>(user1.getPhoneNumbers());

        Address address1 = user1.getAddress();
        String streetAddress1 = address1.getStreetAddress();
        String city1 = address1.getCity();
        int postalCode1 = address1.getPostalCode();

        Address address2 = new Address(streetAddress1, city1, postalCode1);
        user2 = new User(firstName1, lastName1, address2, phoneNumbers2);

        printUsers();
    }

    private void cloneFromConstructor() {
        System.out.println("Клонирование через конструктор");
        user2 = new User(user1);
        printUsers();
    }

    private void cloneFromMethodClone() {
        System.out.println("Клонирование через clone()");
        try {
            user2 = user1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        printUsers();
    }

    private void cloneFromSerializable() {
        System.out.println("Клонирование через сериализацию");
        try {
            user2 = cloneSerializable(user1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printUsers();
    }

    private void cloneFromJson() {
        System.out.println("Клонирование через json");
        Gson gson = new Gson();
        String jsonString = gson.toJson(user1);

        user2 = gson.fromJson(jsonString, User.class);

        printUsers();
    }




    private void printUsers() {
        System.out.println("user1: " + user1);
        System.out.println("user2: " + user2);
    }

    public User cloneSerializable(User from) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        ous.writeObject(from);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (User)ois.readObject();
    }




}
