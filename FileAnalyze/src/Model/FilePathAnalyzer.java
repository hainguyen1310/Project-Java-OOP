package Model;

import java.io.File;

public class FilePathAnalyzer {

    private String filePath;

    public FilePathAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        int fromDisk = filePath.indexOf(File.separator);
        int toNameFile = filePath.lastIndexOf(File.separator);
        return filePath.substring(fromDisk + 1, toNameFile);
    }

    public String getFileName() {
        int positionFrom = filePath.lastIndexOf(File.separator);
        int positionTo = filePath.lastIndexOf(".");
        return filePath.substring(positionFrom + 1, positionTo);
    }

    public String getExtension() {
        int positionDot = filePath.lastIndexOf(".");
        return filePath.substring(positionDot, filePath.length());
    }

    public String getDisk() {
        int positionColon = filePath.indexOf(":");
        return (positionColon != -1) ? filePath.substring(0, positionColon + 1) : "";
    }

    public String getForder() {
        int positionColon = filePath.indexOf(":");
        int positionDot = filePath.lastIndexOf(File.separator);
        if (positionColon != -1 && positionDot != -1) {
            String path = filePath.substring(positionColon + 1, positionDot);
            String[] splitFile = path.split(File.separator);
            return (splitFile.length > 0) ? splitFile[splitFile.length - 1] : "";
        }
        return "";
    }
}

