package hu.bme.bgyn.hsquiz.ui.localresult;

import java.util.ArrayList;
import java.util.List;

import hu.bme.bgyn.hsquiz.Repository.GameRepository;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class LocalResultPresenter extends BasePresenter<LocalResultScreen>{

    GameRepository repository;

    public LocalResultPresenter(){
        repository= new GameRepository();
    }

    @Override
    public void attachScreen(LocalResultScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void refreshResults() {
        List<Result> results= new ArrayList<Result>();
        results.add(new Result("Bálint",100));
        screen.showResults(results);
    }
}
