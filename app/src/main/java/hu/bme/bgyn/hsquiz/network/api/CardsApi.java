package hu.bme.bgyn.hsquiz.network.api;



import retrofit2.Call;
import retrofit2.http.*;

import hu.bme.bgyn.hsquiz.model.Card;

import java.util.List;

public interface CardsApi {

  /**
   * Get all cards
   * Returns all hearthstone cards
   * @param pageSize The numbers of items to return
   * @param offset The number of items to skip before starting to collect the result set
   * @return Call<List<Card>>
   */

  @GET("cards")
  Call<List<Card>> cardsGet(
          @Query("pageSize") String pageSize, @Query("offset") String offset
  );


}
