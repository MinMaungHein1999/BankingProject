package main.java.view.branch;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BranchingListingPage extends JFrame implements ActionListener{
	
	private JTable tabel;
	private DefaultTableModel tabelModel;
	private JScrollPane scrollPane;
	private JButton selectBtn,updateBtn,createBtn;
	private String [] columns = {"Id","Name","Address","Phone Number"};
		
	public BranchingListingPage() {
		initializeComponent();
		addToPanel();
		this.setLocation(200,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addToPanel() {
		JPanel tablePanel = new JPanel();
		tablePanel.add(scrollPane);
		this.add(tablePanel,BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(1,3,5,5));
		btnPanel.add(selectBtn);
		btnPanel.add(createBtn);
		btnPanel.add(updateBtn);
		this.add(btnPanel,BorderLayout.SOUTH);
		
	}

	private void initializeComponent() {
		this.setTitle("Branching Listing Page");
		this.setSize(500,400);
		this.tabelModel = new DefaultTableModel(null,this.columns);
		this.tabel = new JTable(this.tabelModel);
		this.scrollPane = new JScrollPane(tabel);
		this.selectBtn = new JButton("Select");
		this.updateBtn = new JButton("Update");
		this.createBtn = new JButton("Create");
		
	    updateBtn.addActionListener(this);
	    createBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateBtn) {
			new main.java.view.branch.UpdateBranchPage();
		}else if (e.getSource() == createBtn) {
			new main.java.view.branch.CreateBranchPage();
		}
		
	}

}
