package hu.bme.bgyn.hsquiz;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.bgyn.hsquiz.interactor.InteractorModule;
import hu.bme.bgyn.hsquiz.mock.MockNetworkModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class , InteractorModule.class})
public interface TestComponent extends HsQuizApplicationComponent {
}
