package hu.bme.bgyn.hsquiz.network.api;




import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import hu.bme.bgyn.hsquiz.network.model.Error;
import hu.bme.bgyn.hsquiz.network.model.Result;
import hu.bme.bgyn.hsquiz.network.model.InlineResponse200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResultApi {
  
  /**
   * Get all result
   * Returns all result
   * @return Call<List<Result>>
   */
  
  @GET("Results")
  Call<List<Result>> resultsGet();
    

  
  /**
   * Create a new result
   * 
   * @param data Result data
   * @return Call<Result>
   */
  
  @POST("Results")
  Call<Result> resultsPost(
    @Body Result data
  );

  
  /**
   * Delete a Result instance
   * 
   * @param id Model id
   * @return Call<InlineResponse200>
   */
  
  @DELETE("Results/{id}")
  Call<InlineResponse200> resultsIdDelete(
    @Path("id") String id
  );

  
}
