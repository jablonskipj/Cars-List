package rx_playground.com.jablonski.rxandroidplayground.modellist;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;

/**
 * Created by yabol on 18.04.2017.
 */

public class ModelsListPresenter implements BaseViewCotract.BasePresenter<Model>, BaseViewCotract.BaseProvider<Model>, BaseViewCotract.BaseOnItemCLickListener<Model> {
    private ModelsViewContract.View view;
    private List<Model> models;

    public ModelsListPresenter(ModelsViewContract.View view){
        this.view = view;
    }
    @Override
    public void displayElements(List<Model> elements) {
        this.models = elements;
        view.showView(this.models);
    }

    @Override
    public List<Model> getElements() {
        return this.models;
    }

    @Override
    public Model getObject(int position) {
        if(this.models != null) return this.models.get(position);
        return null;
    }

    @Override
    public int getCount() {
        if(this.models != null) return this.models.size();
        return 0;
    }

    @Override
    public void performClick(Model object) {
        view.openSubmodelsList(object.getNiceName());
    }
}
