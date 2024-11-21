package dao.abs.account;

import dao.AbstractDao;
import model.Account;

import java.sql.PreparedStatement;

public abstract class AccountDao extends AbstractDao<Account> {
    public abstract String getUpdateBalanceQuery();
    public abstract void prepareParamForUpdateBalance(PreparedStatement prepStatement, Account object);
    public abstract void updateBalance(Account account);

}
