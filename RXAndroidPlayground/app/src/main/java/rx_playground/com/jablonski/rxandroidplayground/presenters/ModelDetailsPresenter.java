package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.ArrayList;
import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.ModelDetailsContract;
import rx_playground.com.jablonski.rxandroidplayground.model.ListElement;
import rx_playground.com.jablonski.rxandroidplayground.model.Model;
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig;

/**
 * Created by yabol on 16.05.2017.
 */

public class ModelDetailsPresenter implements ModelDetailsContract.Presenter, ModelDetailsContract.Provider {
    private Model model;
    private List<ListElement> elements;
    private ModelDetailsContract.View view;

    public ModelDetailsPresenter(ModelDetailsContract.View view){
        this.view = view;
        this.elements = new ArrayList<>();
    }
    @Override
    public void displayModel(Model model) {
        this.model = model;
        this.elements.add(model);
        this.elements.add(model.getCategory());
        this.elements.add(model.getEngine());
        this.elements.add(model.getTransmission());
        this.view.displayModelDetails();
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
}
