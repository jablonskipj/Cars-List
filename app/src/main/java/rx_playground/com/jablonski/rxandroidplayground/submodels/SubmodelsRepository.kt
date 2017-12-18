package rx_playground.com.jablonski.rxandroidplayground.submodels

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector

/**
 * Created by yabol on 23.04.2017.
 */

class SubmodelsRepository() : SubmodelsViewContract.Repository {
    private val connector: NetworkConnector = NetworkConnector()

    override fun loadElements(manufacturer: String, modelNiceName: String, year: String): Observable<ModelsResult> {
        return this.connector.getSubmodels(manufacturer, modelNiceName, year).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
    }
}
