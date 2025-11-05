package Views;

import javax.swing.*;
import java.awt.*;

public class Sidebar {
    private JPanel wrapper;

    public Sidebar() {
        wrapper = new JPanel();
        wrapper.setBackground(Color.decode("#252624"));
        JButton sourceButton = BuildSourceButton();
        wrapper.add(sourceButton);
    }

    public JPanel GetSidebar() {
        return wrapper;
    }

    private JButton BuildSourceButton(){
        JButton button = BuildButtonStyles(new JButton("Source +"));
        return button;
    }

    private JButton BuildButtonStyles(JButton button)
    {
        button.setBackground(Color.decode("#1f1e1d"));
        button.setFocusable(true);
        button.requestFocusInWindow();
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#3f403e")));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);

        button.setPreferredSize(new Dimension(120, 40));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }
}
