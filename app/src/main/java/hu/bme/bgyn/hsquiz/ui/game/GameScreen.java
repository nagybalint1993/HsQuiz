package hu.bme.bgyn.hsquiz.ui.game;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

public interface GameScreen {

    public void setImageView(Drawable drawable);

    public void showNetworkError(String errorMsg);

    public void setButtons(List<String> names);

    public void setImageView(Bitmap bitmap);

    public void refreshPoints(int points);
}
