package hu.bme.bgyn.hsquiz.mock;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.network.api.CardsApi;
import retrofit2.Call;

public class MockCardsApi implements CardsApi {
    @Override
    public Call<List<Card>> cardsGet(String pageSize, String offset) {
        return null;
    }
}
