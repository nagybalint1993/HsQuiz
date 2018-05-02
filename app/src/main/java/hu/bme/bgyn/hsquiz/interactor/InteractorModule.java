package hu.bme.bgyn.hsquiz.interactor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public HSCardInteractor provideHSCardInteractor() {
        return new HSCardInteractor();
    }

    @Provides
    public ResultInteractor provideResultInteractor() {
        return new ResultInteractor();
    }
}
