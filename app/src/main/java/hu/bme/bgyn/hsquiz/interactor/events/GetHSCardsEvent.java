package hu.bme.bgyn.hsquiz.interactor.events;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Card;

public class GetHSCardsEvent {
    private List<Card> cardsList;
    private Throwable throwable;

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public List<Card> getCarsList() {
        return cardsList;
    }

    public void setCardList(List<Card> cardsList) {
        this.cardsList = cardsList;
    }
}
