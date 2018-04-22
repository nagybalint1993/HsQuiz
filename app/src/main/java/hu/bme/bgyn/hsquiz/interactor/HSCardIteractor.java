package hu.bme.bgyn.hsquiz.interactor;

import java.util.List;

import hu.bme.bgyn.hsquiz.HsQuizApplication;
import hu.bme.bgyn.hsquiz.model.Card;

public class HSCardIteractor {

    public HSCardIteractor(){
        HsQuizApplication.injector.inject(this);
    }
}
