package view.accounts;

import javax.swing.*;
import java.awt.*;

public class AccountCreateWindow extends JFrame {

    private JLabel accountNumberLabel;
    private JLabel accountTypeLabel;
    private JLabel currencyLabel;
    private JLabel amountLabel;
    private JLabel customerIdLabel;

    private JTextField accountNumberInput;
    private JTextField amountInput;
    private JTextField customerIdInput;

    private JComboBox<Object> accountTypeCombo;
    private JComboBox<Object> currencyCombo;

    private JButton saveButton;
    private JButton clearButton;

    public AccountCreateWindow(){
        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents(){
        this.setTitle("Create Account");

        this.accountNumberLabel =  new JLabel("Account number:");
        this.accountTypeLabel = new JLabel("Account type:");
        this.currencyLabel =  new JLabel("Currency");
        this.amountLabel = new JLabel("Amount:");
        this.customerIdLabel = new JLabel("Customer ID:");

        this.accountNumberInput =  new JTextField(20);
        this.amountInput =new JTextField(20);
        this.customerIdInput = new JTextField(20);

        this.accountTypeCombo = new JComboBox<>();
        this.currencyCombo = new JComboBox<>();

        this.saveButton = new JButton("Save");
        this.clearButton = new JButton("Clear");

        this.setSize(450, 350);
        this.setVisible(true);

    }

    private void layoutComponents(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        this.setLayout(layout);
        constraints.insets = new Insets(5,5,5,5);
        constraints.anchor = GridBagConstraints.WEST;



        //fill the first column
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.add(this.accountNumberLabel, constraints);

        constraints.gridy = 1;
        this.add(this.accountTypeLabel, constraints);

        constraints.gridy = 2;
        this.add(this.currencyLabel, constraints);

        constraints.gridy = 3;
        this.add(this.amountLabel, constraints);

        constraints.gridy = 4;
        this.add(this.customerIdLabel, constraints);

        constraints.gridy = 5;
        this.add(this.saveButton, constraints);

        //fill the second column
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.add(this.accountNumberInput, constraints);

        constraints.gridy = 1;
        this.add(this.accountTypeCombo, constraints);

        constraints.gridy = 2;
        this.add(this.currencyCombo, constraints);

        constraints.gridy = 3;
        this.add(this.amountInput, constraints);

        constraints.gridy = 4;
        this.add(this.customerIdInput, constraints);

        constraints.gridy = 5;
        this.add(this.clearButton, constraints);
    }


}
