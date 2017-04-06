package person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private String id;
    private String phone;
    private Address address;
    private static int idNumber = 0;

    private int type;

    public Person(String firstName, String lastName, String phone, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;

        File file = new File("id.txt");
        try {
            Scanner in = new Scanner(file);
            idNumber = in.nextInt();
            in.close();
        } catch (FileNotFoundException e) {
        }

        // super.setId("S" + String.valueOf(idNumber++));
        id = String.valueOf(idNumber++);

        try {
            PrintWriter pw = new PrintWriter("id.txt");
            pw.print(idNumber);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setType(int i){
        type = i;
    }
    public int getType(){
        return type;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", phone=" + phone
                + ", address=" + address + "]";
    }

}