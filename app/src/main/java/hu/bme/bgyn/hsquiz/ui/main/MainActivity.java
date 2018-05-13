package hu.bme.bgyn.hsquiz.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.ui.game.GameActivity;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultActivity;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultActivity;

public class MainActivity extends AppCompatActivity implements MainScreen{

    @Inject
    MainPresenter mainPresenter;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HsQuizApplication.injector.inject(this);

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.onStartButtonPressed();
            }
        });

        Button localResultButton = (Button) findViewById(R.id.localRankingButton);
        localResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.onLocalResultButtonPressed();
            }
        });

        Button globalResultButton = (Button) findViewById(R.id.globalRankingButton);
        globalResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.onGlobalResultButtonPressed();
            }
        });
        HsQuizApplication application = (HsQuizApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name= "MainScreen";
        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("StartGame")
                .build());
    }

    @Override
    public void showLocalResult() {
        Intent intent = new Intent(this, LocalResultActivity.class);
        startActivity(intent);
    }

    @Override
    public void showGlobalResult() {
        Intent intent = new Intent(this, GlobalResultActivity.class);
        startActivity(intent);
    }

    @Override
    public void showNetworkError(String msg) {

    }
}
