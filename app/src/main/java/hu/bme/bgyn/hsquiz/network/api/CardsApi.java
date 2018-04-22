package hu.bme.bgyn.hsquiz.network.api;



import retrofit2.Call;
import retrofit2.http.*;

import hu.bme.bgyn.hsquiz.model.Card;

import java.util.List;

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
