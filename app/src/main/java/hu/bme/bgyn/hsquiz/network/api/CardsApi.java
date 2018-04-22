package hu.bme.bgyn.hsquiz.network.api;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.Error;
import io.swagger.client.model.Card;

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
