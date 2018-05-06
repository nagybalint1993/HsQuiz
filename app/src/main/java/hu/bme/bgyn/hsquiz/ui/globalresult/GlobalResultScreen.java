package hu.bme.bgyn.hsquiz.ui.globalresult;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Result;

public interface GlobalResultScreen {
    public void showResults(List<Result> resultList);

    public void showNetworkError(String errorMsg);
}
