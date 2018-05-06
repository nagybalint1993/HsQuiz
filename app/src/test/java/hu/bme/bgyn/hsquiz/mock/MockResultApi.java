package hu.bme.bgyn.hsquiz.mock;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.InlineResponse200;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.network.api.ResultApi;
import retrofit2.Call;

public class MockResultApi implements ResultApi {
    @Override
    public Call<List<Result>> resultsGet() {
        return null;
    }

    @Override
    public Call<Result> resultsPost(Result data) {
        return null;
    }

    @Override
    public Call<InlineResponse200> resultsIdDelete(String id) {
        return null;
    }
}
