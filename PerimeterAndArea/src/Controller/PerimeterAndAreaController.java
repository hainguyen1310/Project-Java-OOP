package Controller;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.Utils;

public class PerimeterAndAreaController extends Validation {
    
    public PerimeterAndAreaController() {
    }

    public void calculateCircle(){
        Circle inputCircle = Utils.inputCircle();
        Utils.display(inputCircle);
    }
    
    public void calculateTriangle(){
        Triangle inputTriangle = Utils.inputTriangle();
        Utils.display(inputTriangle);
    }
    
    public void calculateRectangle(){
        Rectangle inputRectangle = Utils.inputRectangle();
        Utils.display(inputRectangle);
    }
}
