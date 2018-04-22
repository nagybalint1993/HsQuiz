package hu.bme.bgyn.hsquiz.interactor;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.interactor.events.GetResultEvent;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.network.api.ResultApi;
import retrofit2.Call;
import retrofit2.Response;

public class ResultIteractor {

    @Inject
    ResultApi resultApi;

    public ResultIteractor(){
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

        } catch (Exception e) {
            event.setThrowable(e);
        }
    }
}
