package hu.bme.bgyn.hsquiz.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.network.Network;
import hu.bme.bgyn.hsquiz.ui.game.GamePresenter;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.login.LoginPresenter;
import hu.bme.bgyn.hsquiz.ui.main.MainPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context= context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public GamePresenter provideGamePresenter() {
        return new GamePresenter();
    }

    @Provides
    @Singleton
    public GlobalResultPresenter provideGlobalResultPresenter() { return new GlobalResultPresenter(); }

    @Provides
    @Singleton
    public LocalResultPresenter provideLocalResultPresenter() {
        return new LocalResultPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter(){return  new LoginPresenter();}


    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
