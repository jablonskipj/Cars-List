package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import android.util.Log

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rx_playground.com.jablonski.rxandroidplayground.modeldetails.ModelDetailsContract
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.ModelDetailsResult
import rx_playground.com.jablonski.rxandroidplayground.model.Photo
import rx_playground.com.jablonski.rxandroidplayground.model.PhotosResult
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector

/**
 * Created by yabol on 19.04.2017.
 */

class ModelDetailsRepository(private val presenter: ModelDetailsContract.Presenter) : ModelDetailsContract.Repository {

    private val connector: NetworkConnector = NetworkConnector()
    private var model: Model? = null
    private var resultPhoto: Photo? = null

    override fun getModelDetails(modelId: String) {
        this.connector.getModelsDetails(modelId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ModelDetailsResult> {
                    override fun onSubscribe(d: Disposable) {
                        Log.e("Subscribe", "hello")
                    }

                    override fun onNext(result: ModelDetailsResult) {
                        model = result.model
                        model?.let {
                            with(it) {
                                engine = result.engine
                                transmission = result.transmission
                                category = result.categories
                                drivenWheels = result.drivenWheels
                                numberOfDoors = result.numOfDoors
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Exception", e.message)
                    }

                    override fun onComplete() {
                        presenter.displayModel(model!!)
                    }
                })
    }

    override fun getModelPhotos(modelId: String) {
        this.connector.getPhotos(modelId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<PhotosResult> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(photosResult: PhotosResult) {
                        val photos = photosResult.photos
                        resultPhoto = Photo()
                        for (singlePhoto in photos) {
                            resultPhoto?.addPhotoSources(singlePhoto.sources)
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Exception", e.message)
                    }

                    override fun onComplete() {
                        presenter.displayPhotos(resultPhoto)
                    }
                })
    }
}
