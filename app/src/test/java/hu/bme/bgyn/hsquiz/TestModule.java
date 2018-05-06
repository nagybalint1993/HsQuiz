package hu.bme.bgyn.hsquiz;

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.bgyn.hsquiz.Repository.GameRepository;
import hu.bme.bgyn.hsquiz.network.Network;
import hu.bme.bgyn.hsquiz.ui.game.GamePresenter;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultActivity;
import hu.bme.bgyn.hsquiz.ui.localresult.LocalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.login.LoginPresenter;
import hu.bme.bgyn.hsquiz.ui.main.MainActivity;
import hu.bme.bgyn.hsquiz.ui.main.MainPresenter;
import hu.bme.bgyn.hsquiz.utils.UiExecutor;

@Module
public class TestModule {

	private Context context;

	public TestModule(Context context) {
		this.context = context;
	}

	@Provides
	public Context provideContext() {
		return context;
	}

	@Provides
	@Singleton
	public LocalResultPresenter provideLocalResultPresenter() {
		return new LocalResultPresenter();
	}

	@Provides
	@Singleton
	public GlobalResultPresenter provideGlobalResultPresenter() {
		return new GlobalResultPresenter();
	}

	@Provides
	@Singleton
	public GamePresenter provideGamePresenter() {
		return new GamePresenter();
	}

	@Provides
	@Singleton
	@Network
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}

	@Provides
	@Singleton
	public GameRepository provideGameRepository() {
		return new GameRepository();
	}


	@Provides
	@Singleton
	public LocalResultActivity provideLocalResultActivity() {
		return new LocalResultActivity();
	}

	@Provides
	@Singleton
	public MainPresenter provideMainPresenter() {
		return new MainPresenter();
	}

	@Provides
	@Singleton
	public LoginPresenter provideLoginPresenter() {
		return new LoginPresenter();
	}


}
