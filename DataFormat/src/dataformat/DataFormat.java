package dataformat;

import Controller.DataController;
import Model.dataModel;
import View.DataView;

public class DataFormat {

    public static void main(String[] args) {
        dataModel model = new dataModel();
        DataView view = new DataView();
        DataController controller = new DataController(model, view);
        System.out.println("====== Validate Program ======");
        controller.getInput();
        String phone = model.getPhone();
        String date = model.getDate();
        String email = model.getEmail();
    }
    
}
