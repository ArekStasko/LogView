package Views;

import javax.swing.*;
import java.awt.*;

public class PortElement {
    private JPanel mainPanel;

    public PortElement(String title, String date){
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#3f403e")));
        mainPanel.setBackground(Color.decode("#252624"));
        mainPanel.setPreferredSize(new Dimension(220, 140));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(GetLabel(title));
        mainPanel.add(GetLabel(date));
    }

    public JPanel getPanel(){
        return mainPanel;
    }

    private JLabel GetLabel(String text){
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        return label;
    }
}
