package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx_playground.com.jablonski.rxandroidplayground.model.Result
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector

/**
 * Created by yabol on 10.04.2017.
 */

class ManufacturersRepository() : ManufacturersViewContract.Repository {
    private val connector: NetworkConnector = NetworkConnector()

    override fun getManufacturers(year: String): Observable<Result> {

        return this.connector.getManufacturersByName(year).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
