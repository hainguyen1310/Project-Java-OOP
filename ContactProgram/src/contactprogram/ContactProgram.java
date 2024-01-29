package contactprogram;

import Controller.ContactController;
import View.Menu;
import View.Utils;


public class ContactProgram extends Menu {
    private ContactController cc;
    private static String[] mc = {"Add a Contact", "Display all Contact","Delete a Contact", "Exit"};

    public ContactProgram() {
        super("\nContact Program",mc);
        this.cc = new ContactController();
        Contacts();
    }

    private void Contacts() {
        cc.addContact("Nguyen Dinh Hai", "SE18B06", "59 Le Lai", "0905210101");
        cc.addContact("Tran Duc Hieu", "SE18B06", "16 Nguyen Thi Minh Khai", "2854145398");
        cc.addContact("La An Thien", "SE18B06", "88 Hai Phong", "9996664587");
        cc.addContact("Pham Tran Minh Tri", "SE18B06", "99 Le Do", "4446663215");
        cc.addContact("Nguyen Lan Nhi", "SE18B06", "99 Hai Phong", "0905210101");
    }

    public static void main(String[] args) {
        new ContactProgram().run();
    }
        
        @Override
        public void execute(int n) {
            switch (n) {
                case 1:
                    String name = Utils.getString("Enter Name");
                    String group = Utils.getString("Enter Group");
                    String address = Utils.getString("Enter Address");
                    String phone = Utils.getString("Enter Phone");
                    cc.addContact(name, group, address, phone);
                    System.out.println("Successful");
                    break;
                case 2:
                    cc.displayAll();
                    break;
                case 3:
                    int deleteID = Utils.getInt("Enter ID");
                    cc.deleteContact(deleteID);
                    break;
                default:
                    System.out.println("See you again, Goodbye!!!");
                    System.exit(0);
                    break;
            }
        }
}
