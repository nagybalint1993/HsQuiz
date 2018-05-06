package hu.bme.bgyn.hsquiz.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import hu.bme.bgyn.hsquiz.BuildConfig;
import hu.bme.bgyn.hsquiz.ui.main.MainPresenter;
import hu.bme.bgyn.hsquiz.ui.main.MainScreen;

import static hu.bme.bgyn.hsquiz.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testGameButton() {
        verify(mainScreen).startGame();
    }

    @Test
    public void testLocalResult() {
        verify(mainScreen).showLocalResult();
    }

    @Test
    public void testGlobalResult() {
        verify(mainScreen).showGlobalResult();
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}