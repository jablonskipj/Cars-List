package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx_playground.com.jablonski.rxandroidplayground.model.*
import java.util.*

/**
 * Created by yabol on 16.05.2017.
 */

class ModelDetailsPresenter(private val view: ModelDetailsContract.View, private val repository: ModelDetailsContract.Repository) :
        ModelDetailsContract.Presenter,
        ModelDetailsContract.Provider,
        ModelDetailsContract.ImagesProvider {

    var model: Model? = null
    private val elements: MutableList<ListElement>
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

    override fun loadModelData(modelId: String) {

        this.repository.getModelDetails(modelId).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe({
                    val result = it.model
                    result.engine = it.engine
                    result.transmission = it.transmission
                    result.category = it.categories
                    result.drivenWheels = it.drivenWheels
                    result.numberOfDoors = it.numOfDoors

                    displayModel(result)
                }, {
                    Log.e("load model error", it.message)
                })
        this.repository.getModelPhotos(modelId).
                subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe({
                    val photos = it.photos
                    val resultPhoto = Photo()
                    for (singlePhoto in photos) {
                        resultPhoto.addPhotoSources(singlePhoto.sources)
                    }
                    displayPhotos(resultPhoto)
                }, {
                    Log.e("Load photos error", it.message)
                })
    }


    override fun displayModel(model: Model) {
        this.model = model
        if (this.elements.size > 0) {
            this.elements.clear()
        }
        with(elements) {
            add(model)
            add(model.category)
            add(model.engine)
            add(model.transmission)
        }
        view.displayModelDetails(model)
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

    override fun getImage(position: Int): ImageSource? {
        return if (this.photo != null) {
            this.photo!!.sources[position]
        } else return null
    }
}
