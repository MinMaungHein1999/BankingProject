package service;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import dao.abs.transaction.AccountTransactionDao;
import dao.abs.transaction.AccountTransactionDaoImpl;
import dto.AccountTransactionDto;
import model.AccountTransaction;

public class TransactionManager {

    private final AccountDao accountDao;
    private final AccountTransactionDao accTranDao;

    public TransactionManager(){
        this.accountDao =  new AccountDaoImpl();
        this.accTranDao =  new AccountTransactionDaoImpl();
    }

    public void saveTransaction(AccountTransactionDto accTransDto){
        var accTran = new AccountTransaction();
        var account = this.accountDao.getById(Integer.parseInt(accTransDto.getAccountNumber()));
        account.setBalance(accTransDto.getTransactionType().getValue() == 1 ? account.getBalance()+Double.parseDouble(accTransDto.getAmount()):
                account.getBalance()-Double.parseDouble(accTransDto.getAmount()));
        accTran.setAccountId(account);
        accTran.setType(accTransDto.getTransactionType());
        accTran.setAmount(Double.parseDouble(accTransDto.getAmount()));
        accTran.setDescription(accTransDto.getDescription());
        this.accTranDao.create(accTran);

        this.accountDao.updateBalance(account);
    }
}
