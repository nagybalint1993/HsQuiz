package hu.bme.bgyn.hsquiz.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public GameRepository provideGameRepository(){return new GameRepository();}
}
