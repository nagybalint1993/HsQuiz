package hu.bme.bgyn.hsquiz.test;

import android.graphics.Bitmap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import hu.bme.bgyn.hsquiz.BuildConfig;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.ui.game.GamePresenter;
import hu.bme.bgyn.hsquiz.ui.game.GameScreen;

import static hu.bme.bgyn.hsquiz.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class GameTest {
    private GamePresenter gamePresenter;
    private GameScreen gameScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        gameScreen = mock(GameScreen.class);
        gamePresenter = new GamePresenter();
        gamePresenter.attachScreen(gameScreen);
    }

    @Test
    public void testSetButtons(){
        List<Card> cards= new ArrayList<>();
        cards.add(new Card("test1","-"));
        cards.add(new Card("test2","-"));
        cards.add(new Card("test3","-"));
        cards.add(new Card("test4","-"));
        verify(gameScreen).setButtons(cards);
    }

    @Test
    public void testRefreshPoints(){
      verify(gameScreen).refreshPoints(10);
    }

    @After
    public void tearDown() {
        gamePresenter.detachScreen();
    }
}
