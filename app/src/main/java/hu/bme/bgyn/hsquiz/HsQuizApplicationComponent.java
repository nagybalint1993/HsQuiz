package hu.bme.bgyn.hsquiz;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.bgyn.hsquiz.interactor.HSCardIteractor;
import hu.bme.bgyn.hsquiz.interactor.InteractorModule;
import hu.bme.bgyn.hsquiz.interactor.ResultIteractor;
import hu.bme.bgyn.hsquiz.network.NetworkModule;
import hu.bme.bgyn.hsquiz.ui.UIModule;
import hu.bme.bgyn.hsquiz.ui.game.GameActivity;
import hu.bme.bgyn.hsquiz.ui.game.GamePresenter;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultActivity;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultActivity;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.main.MainActivity;
import hu.bme.bgyn.hsquiz.ui.main.MainPresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface HsQuizApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(ResultIteractor resultInteractor);

    void inject(HSCardIteractor hsCardInteractor);

    void inject(GameActivity gameActivity);

    void inject(GamePresenter gamePresenter);

    void inject(GlobalResultActivity globalResultActivity);

    void inject(GlobalResultPresenter globalResultPresenter);

    void inject(LocalResultActivity localResultActivity);

    void inject(LocalResultPresenter localResultPresenter);
}
