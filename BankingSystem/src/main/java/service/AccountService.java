package service;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import dto.AccountDto;
import exception.AccountCreateException;
import model.*;

public class AccountService {

    private AccountDao accountDao;
    //private customerDao cus
    public AccountService(){
        this.accountDao = new AccountDaoImpl();
    }

    public void createAccount(AccountDto accountDto) throws AccountCreateException {

        Employee testEmployee = new Employee();
        testEmployee.setId(1);


        Customer testCustomer = new Customer();
        testCustomer.setId(1);
        testCustomer.setCreatedBy(testEmployee);

        Account account = new Account();
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType().getValue());
        account.setCurrency(accountDto.getCurrency());;
        account.setStatus(AccountStatus.ACTIVE);
        account.setCurrency(accountDto.getCurrency());
        account.setBalance(accountDto.getAmount());
        account.setCreatedBy(testEmployee);
        account.setUpdatedBy(testEmployee);
        account.setCustomer(testCustomer);
        this.accountDao.create(account);
    }

}
