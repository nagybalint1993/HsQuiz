package hu.bme.bgyn.hsquiz.ui.localresult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.Repository.GameRepository;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class LocalResultPresenter extends BasePresenter<LocalResultScreen>{

    @Inject
    GameRepository gameRepository;

    public LocalResultPresenter(){

    }

    @Override
    public void attachScreen(LocalResultScreen screen) {
        super.attachScreen(screen);
        HsQuizApplication.injector.inject(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void refreshResults() {
        List<Result> results= gameRepository.getTopTenResult();

        screen.showResults(results);
    }
}
