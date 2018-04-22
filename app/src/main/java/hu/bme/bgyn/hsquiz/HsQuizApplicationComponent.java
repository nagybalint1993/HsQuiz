package hu.bme.bgyn.hsquiz;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.bgyn.hsquiz.interactor.HSCardIteractor;
import hu.bme.bgyn.hsquiz.interactor.InteractorModule;
import hu.bme.bgyn.hsquiz.interactor.ResultIteractor;
import hu.bme.bgyn.hsquiz.network.NetworkModule;
import hu.bme.bgyn.hsquiz.ui.UIModule;
import hu.bme.bgyn.hsquiz.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface HsQuizApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ResultIteractor resultInteractor);

    void inject(HSCardIteractor hsCardInteractor);
}
