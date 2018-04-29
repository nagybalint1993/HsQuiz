package hu.bme.bgyn.hsquiz.ui.game;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;

public class GameActivity extends AppCompatActivity implements GameScreen {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Inject
    GamePresenter gamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        HsQuizApplication.injector.inject(this);

        btn1 = (Button) findViewById(R.id.gamebutton1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(1);
            }
        });

        btn2 = (Button) findViewById(R.id.gamebutton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(2);
            }
        });

        btn3 = (Button) findViewById(R.id.gamebutton3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(3);
            }
        });

        btn4 = (Button) findViewById(R.id.startButton);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(4);
            }
        });
    }

}
