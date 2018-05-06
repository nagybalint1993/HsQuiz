package hu.bme.bgyn.hsquiz.Repository;

import android.content.Context;
import android.os.Debug;
import android.util.Log;

import java.util.List;
import hu.bme.bgyn.hsquiz.model.Card;
import hu.bme.bgyn.hsquiz.model.Result;

import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;

public class GameRepository implements Repository {

    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public void createResult(Result result) {
        SugarRecord.save(result);
    }

    @Override
    public List<Result> getAllResult() {
        return SugarRecord.listAll(Result.class);
    }

    @Override
    public void clearAllResult() {
        SugarRecord.deleteAll(Result.class);
    }

    @Override
    public List<Result> getTopTenResult() {
        return Result.findWithQuery(Result.class, "Select * FROM Result ORDER BY point DESC limit 10");
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> list;
        try {
            list = SugarRecord.listAll(Card.class);
        } catch (Exception e) {
            Log.d("getAllCard", e.getMessage());
            return null;
        }
        return list;
    }

    @Override
    public void saveCardList(List<Card> list) {
        SugarRecord.saveInTx(list);
    }

    @Override
    public void clearCard(String currentCardName) {
        SugarRecord.deleteInTx(getCard(currentCardName));
    }

    @Override
    public Card getCard(String name) {
        return SugarRecord.findWithQuery(Card.class, "Select * from Card where name = ?" ,name).get(0);
    }


}
