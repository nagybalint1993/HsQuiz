package hu.bme.bgyn.hsquiz;

import android.app.Application;
import android.content.Context;

import hu.bme.bgyn.hsquiz.ui.UIModule;

public class HsQuizApplication extends Application {

    public static HsQuizApplicationComponent injector;
    private static Context context;
    private static String userName;

    @Override
    public void onCreate() {
        super.onCreate();
        HsQuizApplication.context= getApplicationContext();
        injector = DaggerHsQuizApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }

    public static Context getAppContext() {
        return HsQuizApplication.context;
    }

    public static void setUserName(String name){
        userName= name;
    }

    public static String getUserName() {
        return userName;
    }
}
