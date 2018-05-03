package hu.bme.bgyn.hsquiz.ui.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.HSCardInteractor;
import hu.bme.bgyn.hsquiz.interactor.events.GetHSCardsEvent;
import hu.bme.bgyn.hsquiz.interactor.events.GetImageEvent;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.network.Network;
import hu.bme.bgyn.hsquiz.network.NetworkConfig;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class GamePresenter extends BasePresenter<GameScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    HSCardInteractor hSCardInteractor;

    private String currentCardName;
    private int currentPoint;

    List<Card> cardsList;

    boolean inited= false;

    @Override
    public void attachScreen(GameScreen screen) {
        super.attachScreen(screen);
        HsQuizApplication.injector.inject(this);
        EventBus.getDefault().register(this);
        currentPoint=0;
        if(cardsList== null){
            cardsList= new ArrayList<Card>();
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void gameButtonPressed(int i, String s) {
        if(s == currentCardName){
            currentPoint = currentPoint + 10;
            refreshPoints();
        }

    }

    private void refreshPoints() {
        screen.refreshPoints(currentPoint);
    }

    public void initGame(){
        if(!inited){
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i= 0; i< NetworkConfig.CARDSCOUNT/100; i++){
                        hSCardInteractor.getCards(100,i*100);
                    }
                }
            });
        }
    }

    Drawable DownloadDrawable(String url, String src_name) throws java.io.IOException {
        return Drawable.createFromStream(((java.io.InputStream) new java.net.URL(url).getContent()), src_name);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetHSCardsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            cardsList.addAll(event.getCarsList());
            if(!inited){
                setGameButtons();
                inited= true;
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetImageEvent event) {
        screen.setImageView(event.getImage());
    }

    public void setGameButtons(){
        List<Card> list= new ArrayList<>();
        Random r= new Random();
        int length= cardsList.size();
        int[] cards = {r.nextInt(length),
                r.nextInt(length),
                r.nextInt(length),
                r.nextInt(length)};


        for(int i= 0; i<4; i++){
            list.add(cardsList.get(cards[i]));
        }
        screen.setButtons(list);

        int current= new Random().nextInt(4);
        currentCardName= list.get(current).getName();
        final String url= list.get(current).getImg();
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                hSCardInteractor.getImage(url);
            }
        });
    }


}
