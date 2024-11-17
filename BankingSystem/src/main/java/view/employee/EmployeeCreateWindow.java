package view.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeCreateWindow extends JFrame {

    private JLabel userName;
    private JLabel email;
    private JLabel password;
    private JLabel phoneNumber;
    private JLabel status;
    private JLabel position;
    private JLabel department;
    private JLabel confirmedAt;
    private JLabel createdBy;
    private JTextField userNameTF;
    private JTextField emailTF;
    private JTextField passwordTF;
    private JTextField phoneNumberTF;
    private JTextField statusTF;
    private JTextField positionTF;
    private JTextField departmentTF;
    private JTextField confirmedAtTF;
    private JTextField createdByTF;

    private JButton createButton;
    private JButton cancelButton;

    public EmployeeCreateWindow() {
        initializeComponents();
        addComponentsToUI();

    }

    private void initializeComponents() {
        this.setTitle("Employee Create Window");
        this.setSize(300, 400);
        this.setLayout(new GridLayout(10, 2,10,10));

        this.userName = new JLabel("Username: ");
        this.userNameTF = new JTextField();

        this.email = new JLabel("Email: ");
        this.emailTF = new JTextField();

        this.password = new JLabel("Password: ");
        this.passwordTF = new JTextField();

        this.phoneNumber = new JLabel("Phone Number: ");
        this.phoneNumberTF = new JTextField();

        this.status = new JLabel("Status: ");
        this.statusTF = new JTextField();

        this.position = new JLabel("Position: ");
        this.positionTF = new JTextField();

        this.department = new JLabel("Department: ");
        this.departmentTF = new JTextField();

        this.confirmedAt = new JLabel("Confirmed At: ");
        this.confirmedAtTF = new JTextField();

        this.createdBy = new JLabel("Created By: ");
        this.createdByTF = new JTextField();

        this.createButton = new JButton("Create");
        this.cancelButton = new JButton("Cancel");
        addCreateButtonAction();
        addCancelButtonAction();

    }

    private void addComponentsToUI() {
        this.add(userName);
        this.add(userNameTF);

        this.add(email);
        this.add(emailTF);

        this.add(password);
        this.add(passwordTF);

        this.add(phoneNumber);
        this.add(phoneNumberTF);

        this.add(status);
        this.add(statusTF);

        this.add(position);
        this.add(positionTF);

        this.add(department);
        this.add(departmentTF);

        this.add(confirmedAt);
        this.add(confirmedAtTF);

        this.add(createdBy);
        this.add(createdByTF);

        this.add(createButton);
        this.add(cancelButton);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

    }

    private void addCreateButtonAction() {
        this.createButton.addActionListener(new ActionListener() {
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
