package rx_playground.com.jablonski.rxandroidplayground.submodels

import io.reactivex.Observable
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract

/**
 * Created by yabol on 23.04.2017.
 */

interface SubmodelsViewContract {
    interface View : BaseViewCotract.BaseView<Model> {
        fun openModelDetails(styleId: String)
    }

    interface Presenter : BaseViewCotract.BasePresenter<Model> {
        fun loadElements(manufacturer: String, niceName: String, year: String)
    }

    interface Repository {
        fun loadElements(manufacturer: String, modelNiceName: String, year: String): Observable<ModelsResult>
    }
}
