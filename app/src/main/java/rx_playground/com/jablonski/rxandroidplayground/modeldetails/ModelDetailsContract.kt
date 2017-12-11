package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import android.support.v4.app.Fragment

import rx_playground.com.jablonski.rxandroidplayground.model.ImageSource
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Photo
import rx_playground.com.jablonski.rxandroidplayground.model.RowConfig

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
        var model: Model
        fun loadModelData(modelId: String)
        fun displayModel(model: Model)
        fun displayPhotos(photos: Photo?)
    }

    interface View {
        fun displayModelDetails()
        fun displayPhotos()
    }

    interface Repository {
        fun getModelDetails(modelId: String)
        fun getModelPhotos(modelId: String)
    }
}
