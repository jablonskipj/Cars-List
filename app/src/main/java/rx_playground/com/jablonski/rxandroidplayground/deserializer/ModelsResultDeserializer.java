package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;

/**
 * Created by yabol on 27.04.2017.
 */

public class ModelsResultDeserializer implements Deserializer<ModelsResult> {

    @Override
    public ModelsResult getDeserializedObject(JsonElement object) {
        ModelsResult result = new ModelsResult();
        if(object != null) {
            JsonObject modelResultObject = object.getAsJsonObject();
            JsonElement modelResultElement = modelResultObject.get("models");
            if(modelResultElement != null) {
                JsonArray modelsArray = modelResultElement.getAsJsonArray();
                if (modelsArray != null && modelsArray.size() > 0) {
                    JsonObject model = modelsArray.get(0).getAsJsonObject();
                    result.addModel(new ModelDeserializer().getDeserializedObject(model));
                }
            }
        }
        return result;
    }
}
