import javax.swing.*;
import java.awt.*;

public class EmployeeProfileWindow{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Employee Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);


        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        JLabel headerLabel = new JLabel("Employee Registration", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(Color.BLUE);
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(10, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Register Below"));

        formPanel.add(new JLabel("Employee Name:"));
        formPanel.add(new JTextField());

        formPanel.add(new JLabel("Employee Email:"));
        formPanel.add(new JTextField());

        formPanel.add(new JLabel("Employee Password:"));
        formPanel.add(new JPasswordField());

        formPanel.add(new JLabel("Retype again:"));
        formPanel.add(new JPasswordField()); // strong pass compare

        formPanel.add(new JLabel("Phone Number:"));
        formPanel.add(new JTextField());    // ph valid စစ်ဖို့ကျန်

        formPanel.add(new JLabel("Status:"));
        formPanel.add(new JTextField()); // need to be option choice not open input data

        formPanel.add(new JLabel("Department:"));
        formPanel.add(new JTextField());

        formPanel.add(new JLabel("Position:"));
        formPanel.add(new JTextField());  // better if deprt and position match!!!

        formPanel.add(new JLabel("Confirmed At:"));
        formPanel.add(new JTextField()); // bank branch check!!

        formPanel.add(new JLabel("Created By:"));
        formPanel.add(new JTextField());

        mainPanel.add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");


        submitButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Data Submitted!"));
        cancelButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Action Canceled!"));

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

}