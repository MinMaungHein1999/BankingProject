package view.employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeListing extends JFrame {

    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private String[] columns = {"Id", "Username", "Email", "Password", "Phone Number", "Status", "Position", "Department",
            "Confirmed at", "Created at", "Updated at", "User Roles Id", "Branch Id", "Created by", "Updated by"};
    private JPanel buttonPanel;
    private JButton createButton;
    private JButton updateButton;


    public EmployeeListing() {
        initializeComponents();
        designFrame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.setTitle("Employee List Window");
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());

        this.tableModel = new DefaultTableModel(null, this.columns);
        this.employeeTable = new JTable(this.tableModel);

        TableColumn column = this.employeeTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(100);

        this.scrollPane = new JScrollPane(this.employeeTable);

        this.buttonPanel = new JPanel();
        this.createButton = new JButton("Create");
        this.updateButton = new JButton("Update");
        addCreateButtonAction();
        addUpdateButtonAction();
    }

    private void designFrame() {
        this.add(scrollPane, BorderLayout.CENTER);
        this.buttonPanel.setLayout(new GridLayout(1, 2));
        this.buttonPanel.add(createButton);
        this.buttonPanel.add(updateButton);

        this.add(scrollPane);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addCreateButtonAction() {
        this.createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeCreateWindow();
            }
        });
    }

    private void addUpdateButtonAction() {
        this.updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeUpdateWindow();
            }
        });
    }

}
