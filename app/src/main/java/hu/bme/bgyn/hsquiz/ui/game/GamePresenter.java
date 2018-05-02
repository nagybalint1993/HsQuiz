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
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class GamePresenter extends BasePresenter<GameScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    HSCardInteractor hSCardInteractor;

    private String currentCardName;
    private int currentPoint;

    @Override
    public void attachScreen(GameScreen screen) {
        super.attachScreen(screen);
        HsQuizApplication.injector.inject(this);
        EventBus.getDefault().register(this);
        currentPoint=0;
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
        networkExecutor.execute(new Runnable() {

            @Override
            public void run() {
                hSCardInteractor.getCards();
            }
        });


        /*
        try {
            Drawable drawable= DownloadDrawable("http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_008.png","Blessing of mindes");
            screen.setImageView(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
            if (screen != null) {
                List<Card> cards= event.getCarsList();
                List<String> list= new ArrayList<>();
                for (Card c: cards) {
                    list.add(c.getName());
                }

                screen.setButtons(list);

                int current= new Random().nextInt(4);
                currentCardName= list.get(current);
                final String url= cards.get(current).getImg();
                networkExecutor.execute(new Runnable() {

                    @Override
                    public void run() {
                        hSCardInteractor.getImage(url);
                    }
                });
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetImageEvent event) {
        screen.setImageView(event.getImage());
    }


}
