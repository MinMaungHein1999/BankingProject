package dao.abs.card;
<<<<<<< HEAD

import java.util.Date;
import java.util.List;
=======
import java.util.Date;
>>>>>>> 65a422576e8bc6dfa3d2f98159a51b3788699a91
import dao.AbstractDao;
import model.Card;

public abstract class CardDao extends AbstractDao<Card> {
<<<<<<< HEAD
=======

>>>>>>> 65a422576e8bc6dfa3d2f98159a51b3788699a91
    public abstract Card getCardByAccountID(int accID);
    public abstract boolean isCardExists(String cardNumber);
    public abstract String getCardExpire(Date withinDate);

<<<<<<< HEAD
=======

>>>>>>> 65a422576e8bc6dfa3d2f98159a51b3788699a91

}
