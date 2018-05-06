package hu.bme.bgyn.hsquiz.ui.globalresult;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.ResultInteractor;
import hu.bme.bgyn.hsquiz.interactor.events.GetResultEvent;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.network.Network;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class GlobalResultPresenter extends BasePresenter<GlobalResultScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    ResultInteractor resultInteractor;

    @Override
    public void attachScreen(GlobalResultScreen screen) {
        super.attachScreen(screen);
        HsQuizApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void refreshResults() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                resultInteractor.getResults();
            }
        });
        List<Result> resultList= new ArrayList<>();
        screen.showResults(resultList);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetResultEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                List<Result> list= event.getResultsList();
                list.sort(new Comparator<Result>() {
                    @Override
                    public int compare(Result o1, Result o2) {
                        if(o1.getPoint()> o2.getPoint()){
                            return -1;
                        }
                        if(o1.getPoint()< o2.getPoint()){
                            return 1;
                        }
                        return 0;

                    }
                });
                screen.showResults(event.getResultsList());
            }
        }
    }
}
