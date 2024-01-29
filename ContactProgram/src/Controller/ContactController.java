package Controller;

import Model.ContactModel;
import java.util.ArrayList;

public class ContactController {
    private static int lastId = 0;
    private ArrayList<ContactModel> contactList = new ArrayList<>();
    
    public void addContact(String name, String group, String address, String phone){
        if (!isValidPhoneNumber(phone)) {
            System.out.println("Invalid Phone. Enter again!!!");
            return;
        }
        ContactModel newContact = new ContactModel();
        newContact.setId(++lastId);
        newContact.setFullName(name);
        newContact.setGroup(group);
        newContact.setAddress(address);
        newContact.setPhone(phone);

        contactList.add(newContact);

    }
    
    private boolean isValidPhoneNumber(String phone) {
            String phoneRegex = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4})( x\\d{1,4}| ext\\d{1,4})?$";
            return phone.matches(phoneRegex);
    }
    
    public void displayAll() {
        if (contactList.isEmpty()) {
            System.out.println("Empty Contact");
            return;
        }

        System.out.println("------------ Display all Contact ------------");
        System.out.println("ID\tName\t\t\tFirst Name\tLast Name\tGroup\t\tAddress\t\t\t\tPhone");
        for (ContactModel contact : contactList) {
            System.out.println(contact);
        }
    }
    
    public boolean deleteContact(int deleteId) {
        if (contactList.isEmpty()) {
            System.out.println("Empty Contact.");
            return false;
        }

        boolean contactDeleted = false;
        for (ContactModel contact : contactList) {
            if (contact.getId() == deleteId) {
                contactList.remove(contact);
                contactDeleted = true;
                System.out.println("Successful");
                break;
            }
        }

        if (!contactDeleted) {
            System.out.println("ID not found: " + deleteId);
            return false;
        }

        return true;
    }
}
