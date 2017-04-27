package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by yabol on 27.04.2017.
 */

public interface Deserializer<T> {
    T getDeserializedObject(JsonElement object);
}
