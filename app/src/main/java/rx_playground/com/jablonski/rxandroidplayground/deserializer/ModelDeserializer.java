package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 27.04.2017.
 */

public class ModelDeserializer implements Deserializer<Model> {
    @Override
    public Model getDeserializedObject(JsonElement object) {
        if (object != null) {
            JsonObject modelObject = object.getAsJsonObject();
            Model singleModel = new Model(modelObject.get("name").getAsString());
            singleModel.setNiceName(modelObject.get("niceName").getAsString());
            singleModel.setId(modelObject.get("id").getAsString());

            JsonArray years = modelObject.getAsJsonArray("years");

            if (years != null) {
                JsonObject singleYear = (JsonObject) years.get(0);

                List<Model> parsedSubmodels = new YearDeserializer().getDeserializedObject(singleYear);
                singleModel.setSubmodels(parsedSubmodels);
            }
            return singleModel;
        }
        return null;
    }
}
