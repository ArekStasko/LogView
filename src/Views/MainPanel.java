package Views;

import Services.SerialPortService;

import javax.swing.*;
import java.awt.*;

public class MainPanel {
    SerialPortService serialPortService;
    Sidebar sidebar;
    AppList appList;
    JFrame frame;
    JPanel panel;

    public MainPanel() {
        this.serialPortService = new SerialPortService();
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

        appList = new AppList(this.serialPortService, frame);
        sidebar = new Sidebar(
                this.serialPortService,
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
