package hu.bme.bgyn.hsquiz;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import hu.bme.bgyn.hsquiz.ui.UIModule;
import io.fabric.sdk.android.Fabric;

public class HsQuizApplication extends Application {

    public static HsQuizApplicationComponent injector;
    private static Context context;
    private static String userName;
    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        HsQuizApplication.context= getApplicationContext();
        injector = DaggerHsQuizApplicationComponent.builder().uIModule(new UIModule(this)).build();

        sAnalytics = GoogleAnalytics.getInstance(this);
        sAnalytics.setLocalDispatchPeriod(15);
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
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
