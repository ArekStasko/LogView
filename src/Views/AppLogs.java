package Views;

import Services.SerialPortService;

import javax.swing.*;
import java.awt.*;

public class AppLogs {
    private JFrame frame;
    private JDialog dialog;
    private SerialPortService serialPortService;
    private String fileName;

    public AppLogs(SerialPortService serialPortService, String fileName, JFrame frame) {
        this.frame = frame;
        this.serialPortService = serialPortService;
        this.fileName = fileName;
        BuildAppLogs();
    }

    private void BuildAppLogs(){
        this.dialog = new JDialog(frame, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(800, 600);
        dialog.setBackground(Color.decode("#1f1e1d"));
        dialog.setTitle("Logs for " + fileName);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Logs for " + fileName));
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void DisplayLogs(){
        var data = serialPortService.GetLogs(fileName);
    }
}
