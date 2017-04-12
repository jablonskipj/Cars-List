package rx_playground.com.jablonski.rxandroidplayground.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;
import rx_playground.com.jablonski.rxandroidplayground.model.Concern;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 08.04.2017.
 */

public interface CarsAPI {
    static final String API_KEY = "wkvh2xqvcb8j8sd5gc7779zq";

    @GET("api/vehicle/v2/makes?&view=basic&fmt=json&state=used&api_key=" + API_KEY)
    Observable<Result> fetchCarsListByProductionYear(@Query("year") String year);
}
