package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 27.04.2017.
 */

public class SubmodelsDeserializer implements Deserializer<Model> {
    @Override
    public Model getDeserializedObject(JsonElement object) {
        if (object != null) {
            JsonObject submodelObject = object.getAsJsonObject();
            Model result = new Model(submodelObject.get("name").getAsString());
            result.setId(submodelObject.get("id").getAsString());
            result.setSubmodelName(submodelObject.get("trim").getAsString());
            return result;
        }
        return null;
    }
}
