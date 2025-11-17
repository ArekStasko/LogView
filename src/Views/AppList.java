package Views;

import Services.FileService;

import javax.swing.*;
import java.awt.*;

public class AppList {
    private JFrame frame;
    private JPanel wrapper;
    private FileService fileService;

    public AppList(FileService fileService, JFrame frame) {
        this.fileService = fileService;
        this.frame = frame;
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
            var openButton = BuildButton("Open");
            openButton.addActionListener(e -> new AppLogs(fileService, file, frame));
            var panel = element.getPanel();
            panel.add(openButton);
            wrapper.add(panel);
        }
    }

    private JButton BuildButton(String actionName){
        var button = new JButton(actionName);
        button.setBackground(Color.decode("#1f1e1d"));
        button.setFocusable(true);
        button.requestFocusInWindow();
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#3f403e")));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Arial", Font.BOLD, 8));
        return button;
    }
}
