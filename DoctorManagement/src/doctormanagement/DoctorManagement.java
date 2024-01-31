package doctormanagement;

import Controller.DoctorController;
import View.Menu;
import View.Utils;

public class DoctorManagement extends Menu{
    private DoctorController dc;
    private static String[] mc = {"Add doctor", "Update doctor","Delete doctor","Search doctor", "Exit"};
    
    public DoctorManagement() {
        super("\nDoctor Program",mc);
        this.dc = new DoctorController();
    }
    
    public static void main(String[] args) {
        new DoctorManagement().run();
    }
    
    @Override
        public void execute(int n) {
            switch (n) {
                case 1:
                    String code = Utils.getString("Enter Doctor's Code");
                    String name = Utils.getString("Enter Doctor's Name");
                    String specialization = Utils.getString("Enter Doctor's specialization");
                    int availability = Utils.getInt("Enter Availability");
                    dc.processAddDoctor(code, name, specialization, availability);
                    break;
                case 2:
                    String code1 = Utils.getString("Enter Doctor Code to update");
                    String newName = Utils.getString("Enter new Doctor Name (Press Enter to keep the same)");
                    String newSpecialization = Utils.getString("Enter new Doctor Specialization (Press Enter to keep the same)");
                    String newAvailability = Utils.getString("Enter new Doctor Availability (Press Enter to keep the same)");
                    dc.processUpdateDoctor(code1, newName, newSpecialization, newAvailability);
                    break;
                case 3:
                    String code2 = Utils.getString("Enter Doctor Code to delete");
                    dc.processDeleteDoctor(code2);
                    break;
                case 4:
                    String searchInput = Utils.getString("Enter Doctor's Name");
                    dc.processSearchDoctor(searchInput);
                    break;
                default:
                    System.out.println("See you again, Goodbye!!!");
                    System.exit(0);
                    break;
            }
        }
}
