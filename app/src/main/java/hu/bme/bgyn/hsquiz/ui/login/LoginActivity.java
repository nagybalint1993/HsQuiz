package hu.bme.bgyn.hsquiz.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.R;
import hu.bme.bgyn.hsquiz.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginScreen {

    EditText nameTV;
    Button signInButton;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        HsQuizApplication.injector.inject(this);

        nameTV= (EditText) findViewById(R.id.nameTextView);
        signInButton= (Button) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.logIn();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    public void logIn(){
        String name= nameTV.getText().toString();
        if(nameTV.getText().toString().isEmpty()){
            Toast.makeText(this, "Please add your username!", Toast.LENGTH_LONG).show();
        }
        else {
            HsQuizApplication.setUserName(nameTV.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    };

}
