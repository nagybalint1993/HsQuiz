package hu.bme.bgyn.hsquiz.ui.localresult;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.results.ResultsAdapter;

import static java.security.AccessController.getContext;

public class LocalResultActivity extends AppCompatActivity implements LocalResultScreen{

    @Inject
    LocalResultPresenter localResultPresenter;

    private RecyclerView recyclerViewResults;
    private List<Result> resultList;
    private ResultsAdapter resultsAdapter;
    private SwipeRefreshLayout swipeRefreshLayoutResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        HsQuizApplication.injector.inject(this);

        recyclerViewResults = (RecyclerView) findViewById(R.id.recyclerViewResults);
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
        localResultPresenter.detachScreen();
    }

    @Override
    protected void onStart() {
        super.onStart();
        localResultPresenter.attachScreen(this);
        localResultPresenter.refreshResults();
    }

    @Override
    public void showResults(List<Result> results) {
        resultList.clear();
        resultList.addAll(results);

        resultsAdapter.notifyDataSetChanged();
    }
}
