package Services;

import javax.swing.*;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.fazecast.jSerialComm.SerialPort;

public class SerialPortService {
    SerialPort[] serialPorts = SerialPort.getCommPorts();
    Set<String> fileNames;
    JFileChooser fileChooser;
    File selectedFolder;

    public SerialPortService() {
        fileChooser = new JFileChooser();
    }

    public SerialPort[] GetComPorts(){
        return serialPorts;
    }

    public Iterator<String> GetFileNamesIterator(){
        if(fileNames == null) return null;
        return fileNames.iterator();
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

    private void GetLogs(String fileName){
        
    }
}
