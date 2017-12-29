package rx_playground.com.jablonski.rxandroidplayground.submodels

import io.reactivex.Observable
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult

/**
 * Created by patrykjablonski on 29.12.2017.
 */
class SubmodelsRepositoryMock: SubmodelsViewContract.Repository {
    override fun loadElements(manufacturer: String, modelNiceName: String, year: String): Observable<ModelsResult> {
        val modelResult = ModelsResult()
        val models = ArrayList<Model>()
        val mainModel = Model("test")
        val submodels = ArrayList<Model>()
        val submodel = Model("test")
        submodel.id = "214"
        submodels.add(submodel)
        mainModel.submodels = submodels
        models.add(mainModel)
        modelResult.models = models
        return Observable.just(modelResult)
    }
    //401640368
}