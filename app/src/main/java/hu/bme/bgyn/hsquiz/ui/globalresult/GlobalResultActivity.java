package hu.bme.bgyn.hsquiz.ui.globalresult;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.results.ResultsAdapter;

public class GlobalResultActivity extends AppCompatActivity implements GlobalResultScreen {

    @Inject
    GlobalResultPresenter globalResultPresenter;

    private RecyclerView recyclerViewResults;
    private List<Result> resultList;
    private ResultsAdapter resultsAdapter;
    private SwipeRefreshLayout swipeRefreshLayoutResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_result);

        HsQuizApplication.injector.inject(this);

        recyclerViewResults = (RecyclerView) findViewById(R.id.recyclerViewGlobalResults);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewResults.setLayoutManager(llm);

        resultList = new ArrayList<>();
        resultsAdapter = new ResultsAdapter(this, resultList);
        recyclerViewResults.setAdapter(resultsAdapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        globalResultPresenter.detachScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
        globalResultPresenter.attachScreen(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        globalResultPresenter.refreshResults();
    }

    @Override
    public void showResults(List<Result> results) {
        resultList.clear();
        resultList.addAll(results);

        resultsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }
}
