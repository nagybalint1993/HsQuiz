package hu.bme.bgyn.hsquiz.network.api;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import hu.bme.bgyn.hsquiz.network.model.Error;
import hu.bme.bgyn.hsquiz.network.model.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CardsApi {
  
  /**
   * Get all cards
   * Returns all hearthstone cards
   * @return Call<List<Card>>
   */
  
  @GET("cards")
  Call<List<Card>> cardsGet();
    

  
  /**
   * Get one card
   * 
   * @param name Id.
   * @return Call<Card>
   */
  
  @GET("cards/{name}")
  Call<Card> cardsNameGet(
    @Path("name") String name
  );

  
}
