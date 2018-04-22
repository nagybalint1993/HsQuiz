package hu.bme.bgyn.hsquiz.Repository;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Result;

public class ResultRepository implements Repository {
    @Override
    public void createResult(Result result) {
        result.save();
    }

    @Override
    public List<Result> getAllResult() {
        return Result.listAll(Result.class);
    }

    @Override
    public void clearAllResult() {
        Result.deleteAll(Result.class);
    }

    @Override
    public List<Result> getTopTenResult() {
        return Result.findWithQuery(Result.class, "Select * FROM Result ORDER BY point DESC limit 10");
    }
}
