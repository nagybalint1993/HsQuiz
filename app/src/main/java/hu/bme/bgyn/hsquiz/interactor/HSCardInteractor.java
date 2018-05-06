package hu.bme.bgyn.hsquiz.interactor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.events.GetHSCardsEvent;
import hu.bme.bgyn.hsquiz.interactor.events.GetImageEvent;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.network.NetworkConfig;
import hu.bme.bgyn.hsquiz.network.api.CardsApi;
import retrofit2.Call;
import retrofit2.Response;

public class HSCardInteractor {

    @Inject
    CardsApi cardsApi;

    public HSCardInteractor(){
        HsQuizApplication.injector.inject(this);
    }

    public void getCards(int pageSize, int offset){
        GetHSCardsEvent event= new GetHSCardsEvent();
        try{
            Call<List<Card>> cardsCall = cardsApi.cardsGet(String.valueOf(pageSize), String.valueOf(offset));

            Response<List<Card>> response = cardsCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCardList(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getImage(String url){
        GetImageEvent event= new GetImageEvent();
        try {
            //Generate Bitmap from URL
            URL url_value = new URL(url);
            Bitmap image = BitmapFactory.decodeStream(url_value.openConnection().getInputStream());
            event.setImage(image);
            EventBus.getDefault().post(event);
        }
        catch (Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

}
