package dao.abs.card;

import java.util.Date;
import java.util.List;
import dao.AbstractDao;
import model.Card;

public abstract class CardDao extends AbstractDao<Card> {
    public abstract void addCard(Card card);
    public abstract Card findCarddByNumber(String cardNumber);
    public abstract List<Card> getAllCards();

    public abstract List<Card> getCardByAccountID(int accID);
    public abstract boolean isCardExists(String cardNumber);
    public abstract List<Card> getActiveCards();
    public abstract List<Card> getCardsByType(String cardType);
    public abstract List<Card> getCardsExpiringSoon(Date withinDate);



}
