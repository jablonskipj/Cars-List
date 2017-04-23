package rx_playground.com.jablonski.rxandroidplayground.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yabol on 23.04.2017.
 */

public class ModelsResult {
    @SerializedName("models")
    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
