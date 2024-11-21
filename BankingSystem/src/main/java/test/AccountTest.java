package test;

import dao.abs.transaction.AccountTransactionDao;
import dao.abs.transaction.AccountTransactionDaoImpl;
import model.*;

public class AccountTest {

    public static void main(String[] args){



        Branch testBranch = new Branch();
        testBranch.setId(1);
        testBranch.setName("TESTING BANK");
        testBranch.setAddress("TESTING PLACE");
        testBranch.setPhone_number("55-555555");

        UsersRole testRole = new UsersRole();
        testRole.setId(1);
        testRole.setName("Admin");
        testRole.setDescription("You are an admin.");

        Employee testEmployee = new Employee();
        testEmployee.setId(1);
        testEmployee.setBranch(testBranch);
        testEmployee.setUsersRole(testRole);

        Customer testCustomer = new Customer();
        testCustomer.setId(1);
        testCustomer.setCreatedBy(testEmployee);


        Account testAccount = new Account();
        testAccount.setId(1);
        testAccount.setAccountNumber("555555555");
        testAccount.setAccountType(1);
        testAccount.setBalance(5000);
        testAccount.setStatus(AccountStatus.ACTIVE);
        testAccount.setCurrency("THB");
        testAccount.setCreatedBy(testEmployee);
        testAccount.setUpdatedBy(testEmployee);
        testAccount.setCustomer(testCustomer);
        System.out.println(testAccount.getCustomer().getId());

//        AccountDao accountDao = new AccountDaoImpl();
//        accountDao.create(testAccount);

        AccountTransaction transaction = new AccountTransaction();
        transaction.setAccountId(testAccount);
        transaction.setDescription("Testing");
        transaction.setType(TransactionType.DEPOSIT);
        transaction.setAmount(1000);
        AccountTransactionDao accountTransactionDao= new AccountTransactionDaoImpl();
        accountTransactionDao.create(transaction);


    }
}
