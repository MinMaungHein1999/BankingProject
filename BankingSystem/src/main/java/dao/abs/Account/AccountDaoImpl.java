package dao.abs.Account;

import model.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDaoImpl extends AccountDao{
    @Override
    public String getTableName() {
        return "";
    }

    @Override
    public Account converToObject(ResultSet resultset) {
        return null;
    }

    @Override
    public String getInsertQuery() {
        return "";
    }

    @Override
    public String getUpdateQuery() {
        return "";
    }

    @Override
    public String getDeleteQuery() {
        return "";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Account object) {

    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Account object) {

    }
}
