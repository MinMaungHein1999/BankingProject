package main.java.view.branch;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateBranchPage extends JFrame{

	private JButton updateBtn, cancleBtn;
	private JTextField userTextField, addressTextField, phTextField;
	private JLabel userLabel, addressLabel, phLabel;
	private JPanel panel;

	public UpdateBranchPage() {
		initializeComponent();
		addToPanel();
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void initializeComponent() {
		this.setTitle(" Update Branch Page ");
		this.setSize(400, 300);
		this.setLayout(new BorderLayout(10,10));
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout(4, 2,10,10));
		this.panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		this.userLabel = new JLabel("Name :");
		this.userTextField = new JTextField(15);

		this.addressLabel = new JLabel("Address :");
		this.addressTextField = new JTextField(15);

		this.phLabel = new JLabel("Phone Number :");
		this.phTextField = new JTextField(15);

		this.updateBtn = new JButton("Update");
		this.cancleBtn = new JButton("Cancle");
	}

	private void addToPanel() {
		this.panel.add(userLabel);
		this.panel.add(userTextField);
		this.panel.add(addressLabel);
		this.panel.add(addressTextField);
		this.panel.add(phLabel);
		this.panel.add(phTextField);
		this.panel.add(updateBtn);
		this.panel.add(cancleBtn);
		this.add(panel,BorderLayout.CENTER);
	}
}

