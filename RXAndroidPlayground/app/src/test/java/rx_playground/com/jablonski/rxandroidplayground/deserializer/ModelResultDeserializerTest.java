package rx_playground.com.jablonski.rxandroidplayground.deserializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult;
import rx_playground.com.jablonski.rxandroidplayground.utils.ResourcesProvider;

/**
 * Created by yabol on 27.04.2017.
 */

public class ModelResultDeserializerTest {
    ResourcesProvider provider;
    JsonParser parser;
    ModelsResultDeserializer deserializer;

    @Before
    public void init(){
        provider = new ResourcesProvider();
        parser = new JsonParser();
        deserializer = new ModelsResultDeserializer();
    }

    @Test
    public void testModelResultDeserializerFullData(){
        String json = provider.getStringFromResourceile("ModelResponseFull.json");
        if(json != null){
            JsonElement jsonElement = parser.parse(json);
            ModelsResult result = deserializer.getDeserializedObject(jsonElement);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getModels());
            for(Model model : result.getModels()){
                Assert.assertNotNull(model.getSubmodels());
                Assert.assertNotNull(model.getName());
                for(Model submodel : model.getSubmodels()){
                    Assert.assertNotNull(submodel);
                    Assert.assertNotNull(submodel.getName());
                    Assert.assertNotNull(submodel.getSubmodelName());
                }
            }
        }
    }

    @Test
    public void testModuleResultDeserializeMissingSubmodels(){
        String json = provider.getStringFromResourceile("ModelResponseNoSubmodel.json");
        if(json != null){
            JsonElement element = parser.parse(json);
            ModelsResult result = deserializer.getDeserializedObject(element);

            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getModels());
            for(Model model : result.getModels()){
                Assert.assertNotNull(model.getName());
                Assert.assertNull(model.getSubmodels());
            }
        }
    }

    @Test
    public void testModuleResponseDeserializerMissingYears(){
        String json = provider.getStringFromResourceile("ModelResponseNoYear.json");
        if(json != null){
            JsonElement element = parser.parse(json);
            ModelsResult result = deserializer.getDeserializedObject(element);
            Assert.assertNotNull(result);
            Assert.assertNotNull(result.getModels());
            for(Model model : result.getModels()){
                Assert.assertNotNull(model.getName());
                Assert.assertNull(model.getSubmodels());
            }
        }
    }

    @Test
    public void testModuleResponseDeserializerMissingModels(){
        String json = provider.getStringFromResourceile("ModelResponseMissingModel.json");
        if(json != null){
            JsonElement element = parser.parse(json);
            ModelsResult result = deserializer.getDeserializedObject(element);
            Assert.assertNotNull(result);
            Assert.assertNull(result.getModels());
        }
    }
}
