package Views;

import Services.FileService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AppList {
    private JPanel wrapper;
    private FileService fileService;

    public AppList(FileService fileService) {
        this.fileService = fileService;
        wrapper = new JPanel();
        wrapper.setBackground(Color.decode("#1f1e1d"));
    }

    public JPanel GetAppList() {
        return wrapper;
    }

    public void RenderFiles(){
        BuildAppList();
    }

    private void BuildAppList(){
        var files = fileService.GetFileNamesIterator();
        if(files == null) return;
        while(files.hasNext()){
            var file = files.next();
            var element = new AppElement(file, "");
            wrapper.add(element.getPanel());
        }
    }
}
