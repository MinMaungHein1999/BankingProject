package controller;

import view.customer.CustomerCreatePage;

public class CustomerCreateController {

    private CustomerCreatePage page;

    public CustomerCreateController(){
        this.page = new CustomerCreatePage();
        this.page.getCreateBtn().addActionListener(e-> handleCreateBtnAction());
        this.page.getCancelBtn().addActionListener(e-> handleCancelBtnAction());

    }

    private void handleCancelBtnAction() {

    }

    private void handleCreateBtnAction() {

    }
}
