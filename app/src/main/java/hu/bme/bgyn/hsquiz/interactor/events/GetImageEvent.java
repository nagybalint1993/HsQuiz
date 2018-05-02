package hu.bme.bgyn.hsquiz.interactor.events;

import android.graphics.Bitmap;

import java.util.List;

import hu.bme.bgyn.hsquiz.model.Card;

public class GetImageEvent {
    private Bitmap image;
    private Throwable throwable;

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
