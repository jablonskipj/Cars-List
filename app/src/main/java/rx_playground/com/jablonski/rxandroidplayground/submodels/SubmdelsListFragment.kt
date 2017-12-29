package rx_playground.com.jablonski.rxandroidplayground.submodels

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rx_playground.com.jablonski.rxandroidplayground.R
import rx_playground.com.jablonski.rxandroidplayground.activities.DetailsActivity
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseListFragment
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.SubmodelsListAdapter
import java.util.*

/**
 * Created by yabol on 23.04.2017.
 */

class SubmdelsListFragment : BaseListFragment(), SubmodelsViewContract.View {
    private lateinit var presenter: SubmodelsListPresenter
    private var adapter: SubmodelsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.presenter = SubmodelsListPresenter(this, SubmodelsRepositoryMock())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)

        this.activity.setTitle(R.string.models_fragment_title)

        return view
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.let {
            it.putParcelableArrayList(EXTRA_SUBMODELS, presenter.elements as ArrayList<out Parcelable>)
        }

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        processInstanceState(savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        processInstanceState(savedInstanceState)
    }


    private fun processInstanceState(instanceState: Bundle?) {
        val args = arguments
        if (instanceState == null) {
            val manufacturer = args.getString(EXTRA_MANUFACTURER)
            val name = args.getString(EXTRA_MODEL_NICE_NAME)
            val year = args.getString(EXTRA_YEAR)
            showLoadingIndicator()
            presenter.loadElements(manufacturer, name, year)
        } else {
            val models = instanceState.getParcelableArrayList<Model>(EXTRA_SUBMODELS)
            if(models != null) {
                presenter.displayElements(models)
            }
        }
    }

    override fun openModelDetails(styleId: String) {
        context.startActivity(DetailsActivity.createDeafaultIntent(context, styleId))
    }

    override fun showView(elements: List<Model>) {
        if (this.adapter == null) {
            this.adapter = SubmodelsListAdapter(context, this.presenter)
            this.adapter!!.setOnClickListener(this.presenter)
        }
        if (this.recyclerView.adapter == null) {
            this.recyclerView.adapter = this.adapter
        }
        var count = presenter.count
        if(count > 0) {
            this.adapter!!.notifyItemRangeInserted(0, count - 1)
        }
        hideLoadingIndicator()
    }

    companion object {
        private val EXTRA_SUBMODELS = "Submodels"
        private val EXTRA_MANUFACTURER = "Manufacturer"
        private val EXTRA_MODEL_NICE_NAME = "ModelNiceName"
        private val EXTRA_YEAR = "year"

        fun createInstance(manufacturer: String, modelNiceName: String, year: String): SubmdelsListFragment {
            val fragment = SubmdelsListFragment()
            val bundle = Bundle()
            bundle.putString(EXTRA_MANUFACTURER, manufacturer)
            bundle.putString(EXTRA_MODEL_NICE_NAME, modelNiceName)
            bundle.putString(EXTRA_YEAR, year)
            fragment.arguments = bundle

            return fragment
        }
    }

}
