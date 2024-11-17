package view.accounts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AccountListWindow extends JFrame {

    private final String[] COLUMN_NAMES = {"Account Number", "Customer Name","Account Type", "Currency", "Amount"};
    private JTable accountTable;
    private JScrollPane scrollPane;

    public AccountListWindow(){
        initializeComponents();
    }

    private void initializeComponents(){
        this.setTitle("Account List");
        DefaultTableModel tableModel = new DefaultTableModel(new String[][]{}, this.COLUMN_NAMES);
        this.accountTable = new JTable(tableModel);
        this.scrollPane = new JScrollPane(this.accountTable);
        this.add(this.scrollPane);
        this.setSize(600, 400);
        this.setVisible(true);
    }



}
