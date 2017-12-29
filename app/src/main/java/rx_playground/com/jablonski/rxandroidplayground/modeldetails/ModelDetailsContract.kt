package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import io.reactivex.Observable
import rx_playground.com.jablonski.rxandroidplayground.model.*

/**
 * Created by yabol on 15.05.2017.
 */

class ModelDetailsContract {
    interface Provider {
        val count: Int
        fun getObject(position: Int): RowConfig
        fun getPositionType(position: Int): Int
    }

    interface ImagesProvider {
        val photosCount: Int
        fun getImage(position: Int): ImageSource?
    }

    interface Presenter {
        fun loadModelData(modelId: String)
        fun displayModel(model: Model)
        fun displayPhotos(photos: Photo?)
    }

    interface View {
        fun displayModelDetails(model: Model)
        fun displayPhotos()
    }

    interface Repository {
        fun getModelDetails(modelId: String): Observable<ModelDetailsResult>
        fun getModelPhotos(modelId: String): Observable<PhotosResult>
    }
}
