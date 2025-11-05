package Views;

import javax.swing.*;
import java.awt.*;

public class MainPanel {
    JFrame frame;
    JPanel panel;

    public MainPanel() {
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

        Sidebar sidebar = new Sidebar();
        AppList appList = new AppList();

        panel.add(sidebar.GetSidebar(), BorderLayout.WEST);
        panel.add(appList.GetAppList(), BorderLayout.CENTER);

        frame.setContentPane(panel);
    }
}
