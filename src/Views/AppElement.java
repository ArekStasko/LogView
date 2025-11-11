package Views;

import javax.swing.*;
import java.awt.*;

public class AppElement {
    private JPanel mainPanel;

    public AppElement(){
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#3f403e")));
        mainPanel.setBackground(Color.decode("#252624"));
        mainPanel.setPreferredSize(new Dimension(220, 140));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("App Element title"));
        mainPanel.add(new JLabel("App Element date"));
    }

    public JPanel getPanel(){
        return mainPanel;
    }
}
