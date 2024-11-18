package dao.abs.card;

import model.Card;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CardDaoImpl extends CardDao{
    @Override
    public String getTableName() {
        return "";
    }

    @Override
    public Card converToObject(ResultSet resultset) {
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
    public void prepareParams(PreparedStatement preparedStatement, Card object) {

    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Card object) {

    }
}
