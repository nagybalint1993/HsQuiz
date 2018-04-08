package hu.bme.bgyn.hsquiz.interactor;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public HSCardIteractor provideAccount() {
        return new HSCardIteractor();
    }

    @Provides
    public ResultIteractor provideRequirement() {
        return new ResultIteractor();
    }
}
