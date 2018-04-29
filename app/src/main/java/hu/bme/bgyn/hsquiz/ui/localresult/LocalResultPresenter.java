package hu.bme.bgyn.hsquiz.ui.localresult;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import hu.bme.bgyn.hsquiz.Repository.Repository;
import hu.bme.bgyn.hsquiz.Repository.ResultRepository;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class LocalResultPresenter extends BasePresenter<LocalResultScreen>{

    ResultRepository repository;

    public LocalResultPresenter(){
        repository= new ResultRepository();
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
