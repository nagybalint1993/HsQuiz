package hu.bme.bgyn.hsquiz.interactor;

import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.events.GetHSCardsEvent;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.network.api.CardsApi;
import retrofit2.Call;
import retrofit2.Response;

public class HSCardIteractor {


    @Inject
    CardsApi cardsApi;

    public HSCardIteractor(){
        HsQuizApplication.injector.inject(this);
    }

    public void getCards(){
        GetHSCardsEvent event= new GetHSCardsEvent();
        try{
            Call<List<Card>> cardsCall = cardsApi.cardsGet();

            Response<List<Card>> response = cardsCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCardList(response.body());
            //EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            //EventBus.getDefault().post(event);
        }
    }
}
