package Views;

import javax.swing.*;
import java.awt.*;

public class AppList {
    private JPanel wrapper;

    public AppList() {
        wrapper = new JPanel();
        wrapper.setBackground(Color.decode("#1f1e1d"));
    }

    public JPanel GetAppList(){
        BuildAppList();
        return wrapper;
    }

    private void BuildAppList(){
        var element = new AppElement();
        wrapper.add(element.getPanel());
    }
}
