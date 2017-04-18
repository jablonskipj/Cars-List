package rx_playground.com.jablonski.rxandroidplayground.presenters;

import java.util.List;

import rx_playground.com.jablonski.rxandroidplayground.contracts.BaseViewCotract;
import rx_playground.com.jablonski.rxandroidplayground.contracts.CarsViewContract;
import rx_playground.com.jablonski.rxandroidplayground.model.Car;

/**
 * Created by yabol on 18.04.2017.
 */

public class CarsListPresenter implements BaseViewCotract.BasePresenter<Car>, BaseViewCotract.BaseProvider<Car>, BaseViewCotract.BaseOnItemCLickListener<Car> {
    private CarsViewContract.View<Car> view;
    private List<Car> cars;

    public CarsListPresenter(CarsViewContract.View<Car> view){
        this.view = view;
    }
    @Override
    public void displayElements(List<Car> elements) {
        this.cars = elements;
        view.showView(this.cars);

    }

    @Override
    public List<Car> getElements() {
        return this.cars;
    }

    @Override
    public Car getObject(int position) {
        if(this.cars != null) return this.cars.get(position);
        return null;
    }

    @Override
    public int getCount() {
        if(this.cars != null) return this.cars.size();
        return 0;
    }

    @Override
    public void performClick(Car object) {
        view.openDetails(object);
    }
}
