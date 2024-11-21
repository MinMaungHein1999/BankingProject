package dao.abs.card;
import java.util.Date;
import dao.AbstractDao;
import model.Card;

public abstract class CardDao extends AbstractDao<Card> {

    public abstract Card getCardByAccountID(int accID);
    public abstract boolean isCardExists(String cardNumber);
    public abstract String getCardExpire(Date withinDate);



}
