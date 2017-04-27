package rx_playground.com.jablonski.rxandroidplayground.network;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;


import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx_playground.com.jablonski.rxandroidplayground.deserializer.GsonModelsResultDeserializer;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;
import rx_playground.com.jablonski.rxandroidplayground.model.Result;

/**
 * Created by yabol on 10.04.2017.
 */

public class NetworkConnector {
    private static final String BASE_URL = "https://api.edmunds.com/";

    public NetworkConnector() {

    }

    public Observable<Result> getManufacturersByName(String year) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        CarsAPI api = retrofit.create(CarsAPI.class);
        return api.getManufacturersByYear(year);
    }

    public Observable<ModelsResult> getSubmodels(String manufacturer, String modelNiceName, String year) {
        Gson gson = new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).
                setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").
                registerTypeAdapter(ModelsResult.class, new GsonModelsResultDeserializer()).
                create();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create(gson)).
                build();
        CarsAPI api = retrofit.create(CarsAPI.class);

        return api.getSubmodels(manufacturer, modelNiceName, year);
    }

}
