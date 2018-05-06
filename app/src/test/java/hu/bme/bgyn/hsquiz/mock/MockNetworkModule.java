package hu.bme.bgyn.hsquiz.mock;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.bgyn.hsquiz.network.api.CardsApi;
import hu.bme.bgyn.hsquiz.network.api.ResultApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public CardsApi provideCardsApi(Retrofit.Builder retrofitBuilder) {
        return new MockCardsApi();
    }


    @Provides
    @Singleton
    public ResultApi provideResultApi(Retrofit.Builder retrofitBuilder) {
        return new MockResultApi();
    }

}
