package Controller;

import Model.Person;
import Model.PersonWrapper;

public class PersonController {
    public static void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
        int n = persons.length;

        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i] = new PersonWrapper(persons[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (listPersonWrapper[i].p.salary > listPersonWrapper[j].p.salary) {
                    swap(listPersonWrapper[i], listPersonWrapper[j]);
                }
            }
        }
        System.err.println("Sort sussess.");
        return;
    }
    
    public static void swap(PersonWrapper person1, PersonWrapper person2){
        Person temp = person1.p;
        person1.p = person2.p;
        person2.p = temp;
    }
}
