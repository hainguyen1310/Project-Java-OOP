package View;

import Libary.Validation;
import Model.Person;

public class PersonInputView {

    public static void displayPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary());
    }

    public static Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = Validation.checkInputString();
        System.out.print("Please input address: ");
        String address = Validation.checkInputString();
        System.out.print("Please input salary: ");
        double salary = Validation.checkInputSalary();
        return new Person(name, address, salary);
    }
}
