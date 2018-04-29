package hu.bme.bgyn.hsquiz.ui.globalresult;

import java.util.ArrayList;
import java.util.List;

import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class GlobalResultPresenter extends BasePresenter<GlobalResultScreen> {

    @Override
    public void attachScreen(GlobalResultScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void refreshResults() {
        List<Result> resultList= new ArrayList<>();
        screen.showResults(resultList);
    }
}
