package Views;

import Services.FileService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPanel {
    FileService fileService;
    Sidebar sidebar;
    AppList appList;
    JFrame frame;
    JPanel panel;

    public MainPanel() {
        this.fileService = new FileService();
        frame = new JFrame();
        frame.setTitle("LogView");
        frame.setSize(800, 600);

        Build();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void Build(){
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);

        appList = new AppList(this.fileService, frame);
        sidebar = new Sidebar(
                this.fileService,
                () -> {
                    this.appList.RenderFiles();
                    frame.revalidate();
                    frame.repaint();
                }
        );
        panel.add(sidebar.GetSidebar(), BorderLayout.WEST);
        panel.add(appList.GetAppList(), BorderLayout.CENTER);

        frame.setContentPane(panel);
    }
}
