package rx_playground.com.jablonski.rxandroidplayground.submodels

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.ModelsResult
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract

/**
 * Created by yabol on 23.04.2017.
 */

class SubmodelsListPresenter(private val view: SubmodelsViewContract.View, private var repository: SubmodelsViewContract.Repository) : SubmodelsViewContract.Presenter, BaseViewCotract.BaseProvider<Model>, BaseViewCotract.BaseOnItemCLickListener<Model> {
    private var submodels: List<Model>? = null

    override fun displayElements(elements: List<Model>?) {
        this.submodels = elements
        this.view.showView(elements)
    }

    override fun getElements(): List<Model>? {
        return this.submodels
    }

    override fun loadElements(manufacturer: String, niceName: String, year: String) {
        var elements : List<Model>? = null
        this.repository.loadElements(manufacturer, niceName, year).subscribe(object : Observer<ModelsResult> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(modelsResult: ModelsResult) {
                if (modelsResult.models != null && modelsResult.models.size > 0) {
                    elements = modelsResult.models[0].submodels
                }
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                elements?.let {
                    displayElements(it)
                }

            }
        })
    }

    override fun getObject(position: Int): Model? {
        return if (this.submodels != null) {
            this.submodels?.let {
                it[position]
            }
        } else null
    }

    override fun getCount(): Int {
        return if (this.submodels != null) {
            this.submodels!!.size
        } else 0
    }

    override fun performClick(`object`: Model) {
        view.openModelDetails(`object`.id)
    }
}
