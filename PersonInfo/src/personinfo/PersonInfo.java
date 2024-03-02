package personinfo;

import Controller.PersonController;
import Libary.Validation;
import Model.Person;
import Model.PersonWrapper;
import View.PersonInputView;

public class PersonInfo {

    public static void main(String[] args) {
        int n = Validation.checkInputNumberStudent();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = PersonInputView.inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        PersonController.sortBySalary(persons, listPersonWrapper);
        for (int i = 0; i < persons.length; i++) {
            PersonInputView.displayPersonInfo(listPersonWrapper[i].p);
        }
    }
    
}
