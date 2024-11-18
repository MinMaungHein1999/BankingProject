package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeUpdateWindow extends JFrame {

    private JButton updateButton;
    private JButton cancelButton;

    public EmployeeUpdateWindow() {
        initializeComponents();
        addComponentsToUI();
    }

    private void initializeComponents() {
        this.setLayout(new FlowLayout());
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.updateButton = new JButton("Update");
        this.cancelButton = new JButton("Cancel");
        addUpdateButtonAction();
        addCancelButtonAction();
    }

    private void addComponentsToUI() {
        this.add(updateButton);
        this.add(cancelButton);

        this.setVisible(true);
    }

    private void addUpdateButtonAction() {
        this.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void addCancelButtonAction() {
        this.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });
    }

    private void closeWindow() {
        this.dispose();
    }


}
