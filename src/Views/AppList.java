package Views;

import Services.SerialPortService;

import javax.swing.*;
import java.awt.*;

public class AppList {
    private JFrame frame;
    private JPanel wrapper;
    private SerialPortService serialPortService;

    public AppList(SerialPortService serialPortService, JFrame frame) {
        this.serialPortService = serialPortService;
        this.frame = frame;
        wrapper = new JPanel();
        wrapper.setBackground(Color.decode("#1f1e1d"));
    }

    public JPanel GetAppList() {
        return wrapper;
    }

    public void RenderFiles(){
        BuildPortsList();
    }

    private void BuildPortsList(){
        var ports = serialPortService.GetComPorts();
        if(ports == null) return;
        for(int i = 0; i < ports.length; i++){
            var port = ports[i];
            var element = new PortElement(port.getSystemPortName(), port.getDescriptivePortName());
            var monitorButton = BuildButton("Monitor");
            monitorButton.addActionListener(e -> new PortMonitoringDialog(serialPortService, port, frame));
            var panel = element.getPanel();
            panel.add(monitorButton);
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
