package rx_playground.com.jablonski.rxandroidplayground.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelDetailsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 08.04.2017.
 */

public interface CarsAPI {
    String VEHICLES_API_KEY = "wkvh2xqvcb8j8sd5gc7779zq";

   @GET("api/vehicle/v2/makes?state=used&view=basic&fmt=json&api_key=" + VEHICLES_API_KEY)
    Observable<Result> getManufacturersByYear(@Query("year") String year);

    @GET("api/vehicle/v2/{manufacturer}/models?state=used&view=basic&fmt=json&api_key=" + VEHICLES_API_KEY)
    Observable<ModelsResult> getSubmodels(@Path("manufacturer") String manufacturer, @Query("submodel") String modelNiceName, @Query("year") String year);

    @GET("api/vehicle/v2/styles/{styleID}?view=full&fmt=json&api_key=" + VEHICLES_API_KEY)
    Observable<ModelDetailsResult> getModelDetails(@Path("styleID") String styleID);
}
