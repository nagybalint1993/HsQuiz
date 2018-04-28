package hu.bme.bgyn.hsquiz;

import android.app.Application;

import hu.bme.bgyn.hsquiz.ui.UIModule;

public class HsQuizApplication extends Application {

    public static HsQuizApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerHsQuizApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
