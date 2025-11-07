package Services;

import javax.swing.*;
import java.io.File;

public class FileService {
    JFileChooser fileChooser;
    File selectedFolder;

    public FileService() {
        fileChooser = new JFileChooser();
    }

    public void GetLogDirectory(){
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            selectedFolder = fileChooser.getSelectedFile();
        }
    }

}
