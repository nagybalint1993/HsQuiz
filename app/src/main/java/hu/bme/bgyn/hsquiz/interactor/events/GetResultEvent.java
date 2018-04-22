package hu.bme.bgyn.hsquiz.interactor.events;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Result;

public class GetResultEvent {
    private List<Result> resultsList;
    private Throwable throwable;


    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public List<Result> getResultsList() {
        return resultsList;
    }

    public void setResultstList(List<Result> resultsList) {
        this.resultsList = resultsList;
    }

}
