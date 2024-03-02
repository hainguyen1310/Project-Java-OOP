package Controller;

import Model.FilePathAnalyzer;
import View.FileView;

public class FileController {
    private FilePathAnalyzer model;
    private FileView view;
    
    public FileController(FilePathAnalyzer model, FileView view) {
        this.model = model;
        this.view = view;
    }

    public void analyzeFilePath() {
        String filePath = view.getInputPath();
        model = new FilePathAnalyzer(filePath);

        view.displayResult(model.getDisk(), model.getExtension(), model.getFileName(), model.getPath());
    }
}
