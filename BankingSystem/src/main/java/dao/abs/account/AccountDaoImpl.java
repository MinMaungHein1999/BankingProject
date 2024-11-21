package dao.abs.account;

import model.Account;
import model.AccountStatus;
import model.Employee;

import java.sql.*;

public class AccountDaoImpl extends AccountDao {
    @Override
    public String getTableName() {
        return "accounts";
    }

    @Override
    public Account converToObject(ResultSet resultset) {
        try {
            Account resultAccount = new Account();
            resultAccount.setId(resultset.getInt("id"));
            resultAccount.setAccountNumber(resultset.getString("account_number"));
            resultAccount.setAccountType(resultset.getInt("account_type"));
            resultAccount.setBalance(resultset.getDouble("balance"));
            resultAccount.setCurrency(resultset.getString("currency"));
            resultAccount.setStatus(AccountStatus.fromInt(resultset.getInt("status")));
            resultAccount.setCratedAt(resultset.getDate("created_at"));
            resultAccount.setUpdatedAt(resultset.getDate("updated_at"));
//            private Employee CreatedBy;
//            private Employee updatedBy;

            return resultAccount;
        } catch (SQLException e) {
            System.out.println("Error getting client.");
        }
        return null;
    }

    @Override
    public String getInsertQuery() {
        String queryString = "insert into %s (account_number, account_type, balance, status, currency, created_at, updated_at, created_by, updated_by, customer_id) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return String.format(queryString, getTableName());
    }

    @Override
    public String getUpdateQuery() {
        return "";
    }

    @Override
    public String getUpdateBalanceQuery(){
        String queryString = "update %s set balance = ? where id = ?;";
        return String.format(queryString, getTableName());
    }

    @Override
    public String getDeleteQuery() {
        String queryString = "delete from %s where id = ?;";
        return String.format(queryString, getTableName());
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Account object) {
        String queryString = "insert into %s (account_number, account_type, balance, status, currency, created_at, updated_at, created_by, updated_by, customer_id) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            preparedStatement.setString(1, object.getAccountNumber());
            preparedStatement.setInt(2, object.getAccountType());
            preparedStatement.setDouble(3, object.getBalance());
            preparedStatement.setInt(4, object.getStatus().getValue());
            preparedStatement.setString(5, object.getCurrency());
            preparedStatement.setDate(6, object.getCratedAt());
            preparedStatement.setDate(7, object.getUpdatedAt());
            preparedStatement.setInt(8, object.getCreatedBy().getId());
            preparedStatement.setInt(9, object.getUpdatedBy().getId());
            preparedStatement.setInt(10, object.getCustomer().getId());
        } catch (SQLException e){
            System.out.println("Error setting up prepared statement.");
        }
    }

    @Override
    public void prepareParamForUpdateBalance(PreparedStatement prepStatement, Account account){
        try {
            prepStatement.setDouble(1, account.getBalance());
            prepStatement.setInt(2, account.getId());
        }catch (SQLException e){
            System.err.println("Error setting up prepared statement.");
        }
    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Account object) {

    }

    @Override
    public void updateBalance(Account account){
        try {
            String query = this.getUpdateBalanceQuery();
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            this.prepareParamForUpdateBalance(preparedStatement, account);
            preparedStatement.executeUpdate();
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }finally {
            this.connectionFactory.closeConnection();
        }
    }

}
