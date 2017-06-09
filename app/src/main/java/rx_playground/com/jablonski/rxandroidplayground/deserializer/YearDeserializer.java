package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 27.04.2017.
 */

public class YearDeserializer implements Deserializer<List<Model>> {
    @Override
    public List<Model> getDeserializedObject(JsonElement object) {
        if (object != null) {
            JsonObject year = object.getAsJsonObject();

            JsonElement styleElement = year.get("styles");
            if(styleElement != null) {
                JsonArray styles = styleElement.getAsJsonArray();

                return new StyleDeserializer().getDeserializedObject(styles);
            }
        }
        return null;
    }
}
