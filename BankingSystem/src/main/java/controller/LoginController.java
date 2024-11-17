package controller;

import view.login.LoginWindow;

import javax.swing.*;

public class LoginController {
    private LoginWindow window;
    public LoginController(){
        this.window = new LoginWindow();
        this.window.getLoginBtn().addActionListener(e-> handleLoginBtnAction());
        this.window.getSignupBtn().addActionListener(e-> handleSignUpBtnAction());
    }

    public void handleLoginBtnAction(){

    }

    public void handleSignUpBtnAction(){
        new EmployeeCreateController();
    }


}
