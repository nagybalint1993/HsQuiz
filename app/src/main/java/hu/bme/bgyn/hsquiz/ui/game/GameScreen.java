package hu.bme.bgyn.hsquiz.ui.game;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Card;

public interface GameScreen {

    public void setImageView(Drawable drawable);

    public void showNetworkError(String errorMsg);

    public void setButtons(List<Card> names);

    public void setImageView(Bitmap bitmap);

    public void refreshPoints(int points);
}
