import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class BranchingListingWindow extends JFrame implements ActionListener{
	
	private JTable tabel;
	private JButton selectBtn,updateBtn,createBtn;
	
	public BranchingListingWindow() {
		initializeComponent();
		addToPanel();
		this.setLocation(200,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addToPanel() {
		JPanel tablePanel = new JPanel();
		tablePanel.add(tabel);
		this.add(tablePanel,BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(selectBtn);
		btnPanel.add(createBtn);
		btnPanel.add(updateBtn);
		this.add(btnPanel,BorderLayout.SOUTH);
		
	}

	private void initializeComponent() {
		this.setTitle("Branching Listing Page");
		this.setSize(500,400);
		this.tabel = new JTable();
		this.selectBtn = new JButton("Select");
		this.updateBtn = new JButton("Update");
		this.createBtn = new JButton("Create");
		
	    updateBtn.addActionListener(this);
	    createBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == updateBtn) {
			new UpdateBranchWindow();
		}else if (e.getSource() == createBtn) {
			new CreateBranchWindow();
		}
		
	}

}
