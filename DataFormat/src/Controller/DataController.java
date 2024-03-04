package Controller;

import Model.dataModel;
import View.DataView;

public class DataController {
    private dataModel model;
    private DataView view;

    public DataController(dataModel model, DataView view) {
        this.model = model;
        this.view = view;
    }

    public void getInput() {
        System.out.print("Phone number: ");
        model.setPhone(view.getInputPhone());
        System.out.print("Date: ");
        model.setDate(view.getInputDate());
        System.out.print("Email: ");
        model.setEmail(view.getInputEmail());
    }
}
