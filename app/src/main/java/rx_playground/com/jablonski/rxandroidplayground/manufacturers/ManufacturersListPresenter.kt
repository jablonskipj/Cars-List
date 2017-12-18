package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer
import rx_playground.com.jablonski.rxandroidplayground.model.Result
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract

/**
 * Created by yabol on 06.04.2017.
 */

class ManufacturersListPresenter(private val view: ManufacturersViewContract.View, private var repository: ManufacturersViewContract.Repository) :
        ManufacturersViewContract.Presenter,
        BaseViewCotract.BaseProvider<Manufacturer>,
        BaseViewCotract.BaseOnItemCLickListener<Manufacturer> {

    private var manufacturers: List<Manufacturer>? = null
    fun setRepository(repository: ManufacturersViewContract.Repository) {
        this.repository = repository
    }

    override fun loadElements(year: String) {
        var manufacturers : List<Manufacturer>? = null
        this.repository.getManufacturers(year).subscribe(object : Observer<Result> {
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
                displayElements(manufacturers)
            }
        })

    }

    override fun displayElements(elements: List<Manufacturer>?) {
        this.manufacturers = elements
        this.view.showView(elements)
    }

    override fun getElements(): List<Manufacturer>? {
        return manufacturers
    }

    override fun getCount(): Int {
        return if (this.manufacturers != null)
            this.manufacturers!!.size
        else
            0
    }


    override fun getObject(position: Int): Manufacturer? =
            this.manufacturers?.let { it[position] }

    override fun performClick(item: Manufacturer?) {
        item?.let { view.showListFragment(it.name, it.models) }
    }
}
