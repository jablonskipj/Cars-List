package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import android.util.Log

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersViewContract
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer
import rx_playground.com.jablonski.rxandroidplayground.model.Result
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector

/**
 * Created by yabol on 10.04.2017.
 */

class ManufacturersRepository(private val presenter: ManufacturersViewContract.Presenter) : ManufacturersViewContract.Repository {
    private val connector: NetworkConnector = NetworkConnector()
    private var manufacturers: List<Manufacturer>? = null

    override fun getManufacturers(year: String) {

        this.connector.getManufacturersByName(year).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Result> {
            override fun onSubscribe(d: Disposable) {
                Log.e("Subscribe", "hello")
            }

            override fun onNext(result: Result) {
                manufacturers = result.manufacturers
            }

            override fun onError(e: Throwable) {
                Log.e("Exception", e.message)
            }

            override fun onComplete() {
                presenter.displayElements(manufacturers)
            }
        })
        //return this.connector.getAllManufacturers(year);
    }
}
