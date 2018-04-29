package hu.bme.bgyn.hsquiz.ui.main;

import hu.bme.bgyn.hsquiz.ui.BasePresenter;

public class MainPresenter extends BasePresenter<MainScreen> {

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void onStartButtonPressed(){
        screen.startGame();
    }

    public void onLocalResultButtonPressed() {
        screen.showLocalResult();
    }

    public void onGlobalResultButtonPressed() {
        screen.showGlobalResult();
    }
}
