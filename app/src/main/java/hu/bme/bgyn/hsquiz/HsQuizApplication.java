package hu.bme.bgyn.hsquiz;

import android.app.Application;
import android.content.Context;

import hu.bme.bgyn.hsquiz.ui.UIModule;

public class HsQuizApplication extends Application {

    public static HsQuizApplicationComponent injector;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        HsQuizApplication.context= getApplicationContext();
        injector = DaggerHsQuizApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }

    public static Context getAppContext() {
        return HsQuizApplication.context;
    }
}
