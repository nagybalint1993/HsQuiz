package hu.bme.bgyn.hsquiz.ui.main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.Repository.GameRepository;
import hu.bme.bgyn.hsquiz.interactor.HSCardInteractor;
import hu.bme.bgyn.hsquiz.interactor.events.GetHSCardsEvent;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.network.Network;
import hu.bme.bgyn.hsquiz.network.NetworkConfig;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class MainPresenter extends BasePresenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    HSCardInteractor hSCardInteractor;

    GameRepository gameRepository;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        HsQuizApplication.injector.inject(this);
        gameRepository= new GameRepository();
        gameRepository.open(HsQuizApplication.getAppContext());
        if(gameRepository.getAllCard().size() < 100 ){
            EventBus.getDefault().register(this);
            networkExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i< NetworkConfig.CARDSCOUNT/100; i++){
                        hSCardInteractor.getCards(100,i*100);
                    }
                }
            });
        }
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
        EventBus.getDefault().unregister(this);
    }

    public void onStartButtonPressed(){
        screen.startGame();
    }

    public void onLocalResultButtonPressed() {
        screen.showLocalResult();
    }

    public void onGlobalResultButtonPressed() {
        screen.showGlobalResult();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetHSCardsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            List<Card> cardsList = new ArrayList<>();
            cardsList.addAll(event.getCarsList());
            for (int i= 0; i< cardsList.size(); i++){
                if(cardsList.get(i).getImg() == null){
                    cardsList.remove(i);
                    i--;
                }
            }
            gameRepository.saveCardList(cardsList);

        }
    }
}
