package fileanalyze;

import Controller.FileController;
import Model.FilePathAnalyzer;
import View.FileView;

public class FileAnalyze {

    public static void main(String[] args) {
        FilePathAnalyzer model = new FilePathAnalyzer("");
        FileView view = new FileView();
        FileController controller = new FileController(model, view);

        controller.analyzeFilePath();
    }
    
}
