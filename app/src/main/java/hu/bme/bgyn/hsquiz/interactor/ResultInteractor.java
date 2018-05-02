package hu.bme.bgyn.hsquiz.interactor;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.events.GetResultEvent;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.network.api.ResultApi;
import retrofit2.Call;
import retrofit2.Response;

public class ResultInteractor {

    @Inject
    ResultApi resultApi;

    public ResultInteractor(){
        HsQuizApplication.injector.inject(this);
    }

    public void getResults(){
        GetResultEvent event= new GetResultEvent();
        Call<List<Result>> resultCall= resultApi.resultsGet();
        try{
            Response<List<Result>> response= resultCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setResultstList(response.body());
            EventBus.getDefault().post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }
}
