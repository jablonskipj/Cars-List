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

public class StyleDeserializer implements Deserializer<List<Model>> {
    @Override
    public List<Model> getDeserializedObject(JsonElement object) {
        if (object != null) {
            SubmodelsDeserializer deserilizer = new SubmodelsDeserializer();
            JsonArray styles = object.getAsJsonArray();
            List<Model> submodels = new ArrayList<>();
            for (int k = 0; k < styles.size(); k++) {
                JsonObject singleStyle = styles.get(k).getAsJsonObject();
                Model submodel = deserilizer.getDeserializedObject(singleStyle);
                if(submodel != null) {
                    submodels.add(submodel);
                }
            }
            return submodels;
        }
        return null;
    }
}
