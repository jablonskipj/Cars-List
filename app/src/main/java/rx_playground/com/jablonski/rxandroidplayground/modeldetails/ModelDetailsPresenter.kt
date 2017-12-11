package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import java.util.ArrayList

import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource
import rx_playground.com.jablonski.rxandroidplayground.model.ListElement
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Photo
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig
import rx_playground.com.jablonski.rxandroidplayground.modeldetails.ModelDetailsContract

/**
 * Created by yabol on 16.05.2017.
 */

class ModelDetailsPresenter(private val view: ModelDetailsContract.View) : ModelDetailsContract.Presenter, ModelDetailsContract.Provider, ModelDetailsContract.ImagesProvider {
    override var model: Model
        get() = model
        set(value) { model = value }

    private val elements: MutableList<ListElement>
    private var repository: ModelDetailsContract.Repository? = null
    var photo: Photo? = null
        private set

    override val count: Int
        get() = this.elements.size

    override val photosCount: Int
        get() = if (this.photo != null) {
            this.photo!!.sources.size
        } else 0

    init {
        this.elements = ArrayList()
    }

    fun setRepository(repository: ModelDetailsContract.Repository) {
        this.repository = repository
    }

    override fun loadModelData(modelId: String) {
        this.repository?.getModelDetails(modelId)
        this.repository?.getModelPhotos(modelId)
    }

    override fun displayModel(model: Model) {
        this.model = model
        if (this.elements.size > 0) {
            this.elements.clear()
        }
        with(elements){
            add(model)
            add(model.category)
            add(model.engine)
            add(model.transmission)
        }
    }

    override fun displayPhotos(photos: Photo?) {
        this.photo = photos
        this.view.displayPhotos()
    }

    override fun getObject(position: Int): RowConfig {
        return this.elements[position].rowConfig
    }

    override fun getPositionType(position: Int): Int {
        return this.elements[position].viewType
    }

    override fun getImage(position: Int): ImageSource?{
        return if (this.photo != null) {
            this.photo!!.sources[position]
        } else return null
    }
}
