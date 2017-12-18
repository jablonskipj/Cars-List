package rx_playground.com.jablonski.rxandroidplayground.submodels

import io.reactivex.Observable
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult
import java.util.*

/**
 * Created by yabol on 26.05.2017.
 */

class SubmodelReposioryMock() : SubmodelsViewContract.Repository {
    override fun loadElements(manufacturer: String, modelNiceName: String, year: String): Observable<ModelsResult> {
        val elements = ArrayList<Model>()

        val x6 = Model("x6 2.5i")
        x6.niceName = "BMW X6"
        x6.submodelName = "X6 2.5"
        x6.niceName = "X6 2.5"
        x6.id = "200703383"
        elements.add(x6)

        val modelResult = ModelsResult()
        modelResult.models = elements
        return Observable.just(modelResult)
    }

}
