package hu.bme.bgyn.hsquiz.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import hu.bme.bgyn.hsquiz.BuildConfig;
import hu.bme.bgyn.hsquiz.model.Result;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultPresenter;
import hu.bme.bgyn.hsquiz.ui.globalresult.GlobalResultScreen;


import static hu.bme.bgyn.hsquiz.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class GlobalResultTest {
    private GlobalResultPresenter globalResultPresenter;
    private GlobalResultScreen globalResultScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        globalResultScreen = mock(GlobalResultScreen.class);
        globalResultPresenter = new GlobalResultPresenter();
        globalResultPresenter.attachScreen(globalResultScreen);
    }

    @Test
    public void testShowResults(){
        List<Result> results= new ArrayList<Result>();
        results.add(new Result("Balint", 100));
        results.add(new Result("Balint", 120));
        verify(globalResultScreen).showResults(results);
    }

    @After
    public void tearDown() {
        globalResultPresenter.detachScreen();
    }

}

