package view.login;

import view.customer.CustomerCreatePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame  {
    private JLabel branchlabel ,usernamelabel ,passwordlabel ;
    private JTextField usernameTF ;
    private JPasswordField passwordTF ;
    private JButton signupBtn;

    private JButton loginBtn;
    //private JComboBox<> branchComboBox;
    private JFrame frame;

    public LoginWindow(){
        initializationComponents();
        initializationTableComponents();

        setupLoginBtnAction();
        setupSignupBtnAction();
    }

    private void setupSignupBtnAction() {
        this.signupBtn.addActionListener(e -> signupBtnAction());
    }

    private void signupBtnAction() {
        // create employee form
        new CustomerCreatePage();
    }

    private void setupLoginBtnAction() {
        this.loginBtn.addActionListener(e -> loginBtnAction());
    }

    private void loginBtnAction() {
        // home page

    }

    private void initializationTableComponents(){
        this.setTitle("Login Window");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(350, 200);
        this.frame.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(1, 1, 1, 1);

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(this.branchlabel, constraints);

        constraints.gridx = 1;
      //  frame.add(this.branchComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(this.usernamelabel, constraints);

        constraints.gridx = 1;
        frame.add(this.usernameTF, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(this.passwordlabel, constraints);

        constraints.gridx = 1;
        frame.add(this.passwordTF, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        frame.add(this.loginBtn, constraints);

        constraints.gridx = 1;
        frame.add(this.signupBtn, constraints);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initializationComponents(){
        this.frame = new JFrame("Login Window");

        this.branchlabel = new JLabel(" Branches : ");
       // List<Branch> branchList= this.branchDao.getAll();
        //this.branchComboBox = new JComboBox<>(String["Editor","Moderator",]);

        this.usernamelabel = new JLabel(" Username : ");
        this.usernameTF = new JTextField(15);

        this.passwordlabel = new JLabel(" Password : ");
        this.passwordTF = new JPasswordField(15);

        this.loginBtn = new JButton(" Login ");
        this.signupBtn = new JButton(" Sign Up ");

    }


    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getSignupBtn() {
        return signupBtn;
    }


}
