package rx_playground.com.jablonski.rxandroidplayground.network;


import android.util.Log;

import io.reactivex.Observable;
import retrofit2.Retrofit;


import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 10.04.2017.
 */

public class NetworkConnector {
    private static final String BASE_URL = "https://api.edmunds.com/";
    private CarsAPI api;

    public NetworkConnector(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).

                build();
        this.api = retrofit.create(CarsAPI.class);
    }

    public Observable<Result> getManufacturersByName(String year){
        return api.getManufacturersByYear(year);
    }

    public Observable<ModelsResult> getSubmodels(String modelNiceName, String year){
        return api.getSubmodels(modelNiceName, year);
    }

}
