package rx_playground.com.jablonski.rxandroidplayground.modeldetails;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource;
import rx_playground.com.jablonski.rxandroidplayground.model.ListElement;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.Photo;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;
import rx_playground.com.jablonski.rxandroidplayground.modeldetails.ModelDetailsContract;

/**
 * Created by yabol on 16.05.2017.
 */

public class ModelDetailsPresenter implements ModelDetailsContract.Presenter, ModelDetailsContract.Provider, ModelDetailsContract.ImagesProvider {
    private Model model;
    private List<ListElement> elements;
    private ModelDetailsContract.View view;
    private ModelDetailsContract.Repository repository;
    private Photo photo;

    public ModelDetailsPresenter(ModelDetailsContract.View view){
        this.view = view;
        this.elements = new ArrayList<>();
    }

    public void setRepository(ModelDetailsContract.Repository repository){
        this.repository = repository;
    }

    @Override
    public void loadModelData(String modelId) {
        this.repository.getModelDetails(modelId);
        this.repository.getModelPhotos(modelId);
    }

    @Override
    public void displayModel(Model model) {
        this.model = model;
        if(this.elements.size() > 0){
            this.elements.clear();
        }
        this.elements.add(model);
        this.elements.add(model.getCategory());
        this.elements.add(model.getEngine());
        this.elements.add(model.getTransmission());
        this.view.displayModelDetails();
    }

    @Override
    public void displayPhotos(Photo photos) {
        this.photo = photos;
        this.view.displayPhotos();
    }

    public Photo getPhoto(){
        return this.photo;
    }

    @Override
    public Model getModel() {
        return this.model;
    }

    @Override
    public RowConfig getObject(int position) {
        return this.elements.get(position).getRowConfig();
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }

    @Override
    public int getPositionType(int position) {
        return this.elements.get(position).getViewType();
    }

    @Override
    public ImageSource getImage(int position) {
        if(this.photo != null){
            return this.photo.getSources().get(position);
        }
        return null;
    }

    @Override
    public int getPhotosCount() {
        if(this.photo != null){
            return this.photo.getSources().size();
        }
        return 0;
    }
}
