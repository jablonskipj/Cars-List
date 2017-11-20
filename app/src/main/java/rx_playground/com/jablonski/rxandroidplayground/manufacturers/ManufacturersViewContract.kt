package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import io.reactivex.annotations.Nullable
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer

/**
 * Created by yabol on 06.04.2017.
 */

interface ManufacturersViewContract {

    interface View : BaseViewCotract.BaseView<Manufacturer> {
        fun showListFragment(@Nullable manufacturer: String, @Nullable models: List<Model>)
    }

    interface Presenter : BaseViewCotract.BasePresenter<Manufacturer> {
        fun loadElements(year: String)
    }

    interface Repository {
        fun getManufacturers(year: String)
    }

}
