package Views;

import Services.FileService;

import javax.swing.*;
import java.awt.*;

public class AppList {
    private JPanel wrapper;
    private FileService fileService;

    public AppList(FileService fileService) {
        this.fileService = fileService;
        wrapper = new JPanel();
        wrapper.setBackground(Color.decode("#1f1e1d"));
    }

    public JPanel GetAppList(){
        BuildAppList();
        return wrapper;
    }

    private void BuildAppList(){
        var files = fileService.GetFileNamesIterator();
        while(files.hasNext()){
            var file = files.next();
            var element = new AppElement(file, "");
            wrapper.add(element.getPanel());
        }
    }
}
