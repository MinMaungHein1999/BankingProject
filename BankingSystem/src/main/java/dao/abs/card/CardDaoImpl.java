package dao.abs.card;

import model.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CardDaoImpl extends CardDao{



    @Override
    public String getTableName() {
        return "cards";
    }

    @Override
    public Card converToObject(ResultSet resultset) {
        Card card = null;
        try{
            int id = resultset.getInt("id");
            String number = resultset.getString("number");
            int cardType = resultset.getInt("card_type");
            Date expireDate = resultset.getDate("expire_date");;
            String secCode = resultset.getString("security_code");
            int acc_id = resultset.getInt("account_id");
        }catch (SQLException e){
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        return card;
    }

    @Override
    public String getInsertQuery() {
        // insert into cards (card_type,expire_date,security_code)
        return "insert into "+this.getTableName()+" (card_type,expire_date,security_code)"+"values (?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "update"+this.getTableName()+" set ";
    }

    @Override
    public String getDeleteQuery() {
        return "delete from "+this.getTableName()+" where id = ?";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Card object) {

    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Card object) {

    }

    @Override
    public void addCard(Card card) {

    }

    @Override
    public Card findCarddByNumber(String cardNumber) {
        Card card = null;
        try{
           String query = "Select id from "+this.getTableName()+" where number like ?";
           Connection connection = connectionFactory.createConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,cardNumber);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               int id = resultSet.getInt("id");
               card = this.getById(id);
           }
        }catch (SQLException e){
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return  card;
    }





    @Override
    public List<Card> getAllCards() {
        return List.of();
    }

    @Override
    public List<Card> getCardByAccountID(int accID) {
        return List.of();
    }

    @Override
    public boolean isCardExists(String cardNumber) {
        return false;
    }

    @Override
    public List<Card> getActiveCards() {
        return List.of();
    }

    @Override
    public List<Card> getCardsByType(String cardType) {
        return List.of();
    }

    @Override
    public List<Card> getCardsExpiringSoon(Date withinDate) {
        return List.of();
    }


}
