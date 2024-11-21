package view.customer;

import javax.swing.*;
import java.awt.*;

public class CustomerCreatePage extends JFrame{
    private JPanel registerPanel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel dateOfBirthLabel;
    private JLabel nrcLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;

    private JTextField firstnameTextField;
    private JTextField lastnameTextField;
    private JTextField dateOfBirthTextField; //ask
    private JTextField nrcTextField;
    private JTextField phoneTextField;
    private JTextField emailTextField;
    private JTextField addressTextField;

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JButton getCreateBtn() {
        return createBtn;
    }

    private JButton createBtn,cancelBtn;

    public CustomerCreatePage(){
        initializeComponent();
        initializeTableComponent();

    }

    private void initializeTableComponent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Customer Registeration Window");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        this.registerPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(8,2);
        this.registerPanel.setLayout(gridLayout);

        this.registerPanel.add(firstNameLabel);
        this.registerPanel.add(firstnameTextField);

        this.registerPanel.add(lastNameLabel);
        this.registerPanel.add(lastnameTextField);

        this.registerPanel.add(dateOfBirthLabel);
        this.registerPanel.add(dateOfBirthTextField);

        this.registerPanel.add(nrcLabel);
        this.registerPanel.add(nrcTextField);

        this.registerPanel.add(phoneLabel);
        this.registerPanel.add(phoneTextField);

        this.registerPanel.add(emailLabel);
        this.registerPanel.add(emailTextField);

        this.registerPanel.add(addressLabel);
        this.registerPanel.add(addressTextField);

        this.registerPanel.add(createBtn);
        this.registerPanel.add(cancelBtn);

        this.add(registerPanel,BorderLayout.NORTH);
        this.setVisible(true);
    }

    private void initializeComponent() {
        this.firstNameLabel = new JLabel("First Name : ");
        this.firstnameTextField = new JTextField();

        this.lastNameLabel = new JLabel("Last Name : ");
        this.lastnameTextField = new JTextField();

        this.dateOfBirthLabel = new JLabel("Date Of Birth : ");
        this.dateOfBirthTextField = new JTextField();

        this.nrcLabel = new JLabel("NRC Card : ");
        this.nrcTextField = new JTextField();

        this.phoneLabel = new JLabel("Phone Number : ");
        this.phoneTextField = new JTextField();

        this.emailLabel = new JLabel("Email : ");
        this.emailTextField = new JTextField();

        this.addressLabel = new JLabel("Address : ");
        this.addressTextField = new JTextField();

        this.createBtn = new JButton("Create");
        this.cancelBtn = new JButton("Cancel");

    }

}
