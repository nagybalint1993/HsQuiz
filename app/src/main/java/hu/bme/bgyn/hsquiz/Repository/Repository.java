package hu.bme.bgyn.hsquiz.Repository;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Result;

public interface Repository {
    void createResult(Result result);

    List<Result> getAllResult();

    void clearAllResult();

    List<Result> getTopTenResult();
}
