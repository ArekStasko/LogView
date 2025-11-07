package Services;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    Set<String> fileNames;
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
            GetLogFiles();
        }
    }

    public void GetFileNames(){
        fileNames.forEach(System.out::println);
    }

    private void GetLogFiles(){
        var listFiles = selectedFolder.listFiles();
        if(listFiles == null) return;

        fileNames = Stream.of(listFiles)
                .filter(file -> !file.isDirectory())
                .map(file -> {
                    String fileName = file.getName();
                    if(fileName.contains("log")) return fileName;
                    return null;
                })
                .collect(Collectors.toSet());
    }
}
