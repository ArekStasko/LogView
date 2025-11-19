package Views;

import Services.SerialPortService;
import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;

public class PortMonitoringDialog {
    private JFrame frame;
    private JDialog dialog;
    private SerialPortService serialPortService;
    private SerialPort port;

    public PortMonitoringDialog(SerialPortService serialPortService, SerialPort port, JFrame frame) {
        this.frame = frame;
        this.serialPortService = serialPortService;
        this.port = port;
        BuildAppLogs();
    }

    private void BuildAppLogs(){
        this.dialog = new JDialog(frame, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 600);
        dialog.setBackground(Color.decode("#1f1e1d"));
        dialog.setTitle(port.getDescriptivePortName());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Logs for " + port.getDescriptivePortName()));
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }
}
