package hu.bme.bgyn.hsquiz.Repository;

import android.content.Context;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.model.Result;

public interface Repository {

    void open(Context context);
    void close();

    void createResult(Result result);

    List<Result> getAllResult();

    void clearAllResult();

    List<Result> getTopTenResult();

    List<Card> getAllCard();

    void saveCardList(List<Card> list);

    void clearCard(String currentCardName);

    Card getCard(String name);
}
