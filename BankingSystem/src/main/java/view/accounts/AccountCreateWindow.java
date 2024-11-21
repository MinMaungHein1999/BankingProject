package view.accounts;

import dto.AccountDto;
import exception.AccountCreateException;
import model.AccountType;
import service.AccountService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreateWindow extends JFrame {

    private AccountService accountService;

    private JLabel accountNumberLabel;
    private JLabel accountTypeLabel;
    private JLabel currencyLabel;
    private JLabel amountLabel;
    private JLabel customerIdLabel;

    private JTextField accountNumberInput;
    private JTextField amountInput;
    private JTextField customerIdInput;

    private JComboBox<AccountType> accountTypeCombo;
    private JComboBox<String> currencyCombo;

    private JButton saveButton;
    private JButton clearButton;

    public AccountCreateWindow(){
        this.accountService = new AccountService();
        initializeComponents();
        layoutComponents();
    }

    private void initializeComponents(){
        this.setTitle("Create Account");

        String[] currencyList = new String[]{"MMK", "THB", "USD", "JPY"};

        this.accountNumberLabel =  new JLabel("Account number:");
        this.accountTypeLabel = new JLabel("Account type:");
        this.currencyLabel =  new JLabel("Currency");
        this.amountLabel = new JLabel("Amount:");
        this.customerIdLabel = new JLabel("Customer ID:");

        this.accountNumberInput =  new JTextField(20);
        this.amountInput =new JTextField(20);
        this.customerIdInput = new JTextField(20);

        this.accountTypeCombo = new JComboBox<>(AccountType.values());
        this.currencyCombo = new JComboBox<>(currencyList);

        this.saveButton = new JButton("Save");
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSaveClick();
            }
        });

        this.clearButton = new JButton("Clear");
        this.clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClearClick();
            }
        });

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


    private void handleSaveClick()  {
        try {
            AccountDto accountDto = new AccountDto();
            accountDto.setAccountType((AccountType) this.accountTypeCombo.getSelectedItem());
            accountDto.setAccountNumber(this.accountNumberInput.getText());
            accountDto.setCurrency((String) this.currencyCombo.getSelectedItem());
            accountDto.setCustomerId(Integer.parseInt(this.customerIdInput.getText()));
            accountDto.setAmount(Double.parseDouble(this.amountInput.getText()));
            this.accountService.createAccount(accountDto);
        }catch (AccountCreateException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            JOptionPane.showMessageDialog(this, "Account created successfully.");
        }
    }

    private void handleClearClick(){
        this.accountNumberInput.setText("");
        this.accountTypeCombo.setSelectedIndex(0);
        this.currencyCombo.setSelectedIndex(0);
        this.amountInput.setText("");
        this.customerIdInput.setText("");
    }


}
