package hu.bme.bgyn.hsquiz.ui.game;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.model.Card;

public class GameActivity extends AppCompatActivity implements GameScreen {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ImageView cardView;
    private TextView pointsView;
    private SurfaceView surfaceView;

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
                gamePresenter.gameButtonPressed(1, btn1.getText().toString());
            }
        });

        btn2 = (Button) findViewById(R.id.gamebutton2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(2, btn2.getText().toString());
            }
        });

        btn3 = (Button) findViewById(R.id.gamebutton3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(3, btn3.getText().toString());
            }
        });

        btn4 = (Button) findViewById(R.id.gamebutton4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePresenter.gameButtonPressed(4, btn4.getText().toString());
            }
        });

        cardView = (ImageView) findViewById(R.id.imageView);

        pointsView = (TextView) findViewById(R.id.pointsTextView);
        surfaceView= (SurfaceView) findViewById(R.id.surfaceView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        gamePresenter.attachScreen(this);
        gamePresenter.setGameButtons();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gamePresenter.detachScreen();
    }

    public void disableSurfaceView(){
        surfaceView.setEnabled(false);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                surfaceView.setEnabled(true);
            }
        },2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void setImageView(Drawable drawable) {
        cardView.setImageDrawable(drawable);
    }


    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setButtons(List<Card> names) {
        btn1.setText(names.get(0).getName());
        btn2.setText(names.get(1).getName());
        btn3.setText(names.get(2).getName());
        btn4.setText(names.get(3).getName());
    }

    @Override
    public void setImageView(Bitmap bitmap) {
        cardView.setImageBitmap(bitmap);
    }

    @Override
    public void refreshPoints(int points) {
        pointsView.setText("Points: " + points);
    }

}
