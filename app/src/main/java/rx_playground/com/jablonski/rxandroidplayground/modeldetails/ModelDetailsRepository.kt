package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import io.reactivex.Observable
import rx_playground.com.jablonski.rxandroidplayground.model.ModelDetailsResult
import rx_playground.com.jablonski.rxandroidplayground.model.PhotosResult
import rx_playground.com.jablonski.rxandroidplayground.network.NetworkConnector

/**
 * Created by yabol on 19.04.2017.
 */

class ModelDetailsRepository(private val presenter: ModelDetailsContract.Presenter) : ModelDetailsContract.Repository {

    private val connector: NetworkConnector = NetworkConnector()

    override fun getModelDetails(modelId: String): Observable<ModelDetailsResult> {
       return this.connector.getModelsDetails(modelId)
    }

    override fun getModelPhotos(modelId: String): Observable<PhotosResult> {
        return this.connector.getPhotos(modelId)
    }
}
