package view.accounts_transaction;

import dto.AccountTransactionDto;
import model.TransactionType;
import service.TransactionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountTransactionWindow extends JFrame {

    private TransactionManager transactionManager;
    private JLabel accountNumberLabel;
    private JLabel transactionTypeLabel;
    private JLabel amountLabel;
    private JLabel descriptionLabel;

    private JTextField accountNumberInput;
    private JTextField amountInput;

    private JComboBox<TransactionType> transactionCombo;

    private JTextArea descriptionInput;

    private JButton saveButton;
    private JButton clearButton;

    public AccountTransactionWindow(){
        this.transactionManager = new TransactionManager();
        initiateComponents();
        layoutComponents();
    }

    private void initiateComponents(){
        this.accountNumberLabel =  new JLabel("Account number:");
        this.transactionTypeLabel = new JLabel("Transaction type:");
        this.amountLabel = new JLabel("Amount:");
        this.descriptionLabel = new JLabel("Description");

        this.accountNumberInput = new JTextField(20);
        this.amountInput = new JTextField(20);


        this.transactionCombo = new JComboBox<>(TransactionType.values());

        this.descriptionInput =  new JTextArea(5, 20);

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

        //Fill the first column
        constraints.gridx = 0;

        constraints.gridy = 0;
        this.add(this.accountNumberLabel, constraints);

        constraints.gridy = 1;
        this.add(this.transactionTypeLabel, constraints);

        constraints.gridy = 2;
        this.add(this.amountLabel, constraints);

        constraints.gridy = 3;
        this.add(this.descriptionLabel, constraints);

        constraints.gridy = 4;
        this.add(this.saveButton, constraints);

        //Fill the second column
        constraints.gridx = 1;

        constraints.gridy = 0;
        this.add(this.accountNumberInput, constraints);

        constraints.gridy = 1;
        this.add(this.transactionCombo, constraints);

        constraints.gridy = 2;
        this.add(this.amountInput, constraints);

        constraints.gridy = 3;
        this.add(this.descriptionInput, constraints);

        constraints.gridy = 4;
        this.add(this.clearButton, constraints);


    }

    public void handleSaveClick(){
        var accTransDto = new AccountTransactionDto();
        accTransDto.setAccountNumber(this.accountNumberInput.getText());
        accTransDto.setTransactionType((TransactionType) this.transactionCombo.getSelectedItem());
        accTransDto.setAmount(this.amountInput.getText());
        accTransDto.setDescription(this.descriptionInput.getText());
        this.transactionManager.saveTransaction(accTransDto);
    }

    public void handleClearClick(){
        this.accountNumberInput.setText("");
        this.transactionCombo.setSelectedIndex(0);
        this.amountInput.setText("");
    }

}
