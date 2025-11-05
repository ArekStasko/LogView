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
        JButton button = new JButton("Source");
        return button;
    }
}
