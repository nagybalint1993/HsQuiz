package hu.bme.bgyn.hsquiz.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.bgyn.hsquiz.network.api.CardsApi;
import hu.bme.bgyn.hsquiz.network.api.ResultApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public CardsApi provideCardssApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.CARDSAPI_ENDPOINT_ADDRESS).build().create(CardsApi.class);
    }


    @Provides
    @Singleton
    public ResultApi provideTokenApi(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(NetworkConfig.RESULTAPI_ENDPOINT_ADDRESS).build().create(ResultApi.class);
    }
}
