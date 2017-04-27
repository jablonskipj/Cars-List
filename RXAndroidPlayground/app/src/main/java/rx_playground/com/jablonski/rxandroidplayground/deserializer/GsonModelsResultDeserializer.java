package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;

/**
 * Created by yabol on 25.04.2017.
 */

public class GsonModelsResultDeserializer implements JsonDeserializer<ModelsResult> {
    @Override
    public ModelsResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        return getModulesResult(json);
    }

    private ModelsResult getModulesResult(JsonElement json) {
        JsonObject result = json.getAsJsonObject();

        ModelsResultDeserializer deserializer = new ModelsResultDeserializer();
        return deserializer.getDeserializedObject(result);
    }
}
