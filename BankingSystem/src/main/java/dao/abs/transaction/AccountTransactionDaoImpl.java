package dao.abs.transaction;

import dao.abs.account.AccountDao;
import dao.abs.account.AccountDaoImpl;
import model.AccountTransaction;
import model.TransactionType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTransactionDaoImpl extends AccountTransactionDao {

    private final AccountDao accountDao;

    public AccountTransactionDaoImpl() {
        this.accountDao = new AccountDaoImpl();
    }

    @Override
    public String getTableName() {
        return "accounts_transaction";
    }

    @Override
    public AccountTransaction converToObject(ResultSet resultset) {
        try {
            AccountTransaction resultAccountTransaction = new AccountTransaction();
            resultAccountTransaction.setId(resultset.getInt("id"));
            resultAccountTransaction.setType(TransactionType.fromInt(resultset.getInt("type")));
            resultAccountTransaction.setAmount(resultset.getDouble("amount"));
            resultAccountTransaction.setCreatedAt(resultset.getTime("created_at"));
            resultAccountTransaction.setDescription(resultset.getString("description"));
            resultAccountTransaction.setAccountId(this.accountDao.getById(resultset.getInt("account_id")));
            return resultAccountTransaction;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String getInsertQuery() {
        String queryString= "insert into %s(type, amount, description, account_id) values (?,?,?,?)";
        return String.format(queryString, this.getTableName());
    }

    @Override
    public String getUpdateQuery() {
        return "";
    }

    @Override
    public String getDeleteQuery() {
        String queryString = "delete from %s where id =?";
        return String.format(queryString, this.getTableName());
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, AccountTransaction object) {
        try {
            preparedStatement.setInt(1, object.getType().getValue());
            preparedStatement.setDouble(2, object.getAmount());
            preparedStatement.setString(3, object.getDescription());
            preparedStatement.setInt(4, object.getAccountId().getId());
        } catch (SQLException e){
            System.err.println("Error in prepareParams method.");
        }
    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, AccountTransaction object) {

    }
}
