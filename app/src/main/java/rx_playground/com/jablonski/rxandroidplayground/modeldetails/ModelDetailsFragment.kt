package rx_playground.com.jablonski.rxandroidplayground.modeldetails

import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_model_details.*
import rx_playground.com.jablonski.rxandroidplayground.R
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Photo
import rx_playground.com.jablonski.rxandroidplayground.utils.ResourcesUtils
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.ModelDetailsAdapter
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.viewpager.ImagesPagerAdapter

/**
 * Created by yabol on 19.05.2017.
 */

class ModelDetailsFragment : Fragment(), ModelDetailsContract.View {
    private var adapter: ModelDetailsAdapter? = null
    private lateinit var presenter: ModelDetailsPresenter
    private var viewPagerAdapter: ImagesPagerAdapter? = null
    private var modelId: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.presenter = ModelDetailsPresenter(this)
        val repository = ModelDetailsRepository(this.presenter)
        this.presenter.setRepository(repository)

        this.modelId = arguments?.getString(EXTRA_MODEL_ID)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_model_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        setToolbar()
    }

    private fun setToolbar() {
        val context = context

        val primaryDark = ResourcesUtils.getColor(context, R.color.colorPrimaryDark)
        val primary = ResourcesUtils.getColor(context, R.color.colorPrimary)
        val expandedTextColor = ResourcesUtils.getColor(context, android.R.color.transparent)
        val collapsedTextColor = ResourcesUtils.getColor(context, R.color.white)

        collapsingToolbar?.let {
            with(it) {
                title = ResourcesUtils.getText(context, R.string.details_title)
                setExpandedTitleColor(expandedTextColor)
                setContentScrimColor(primary)
                setStatusBarScrimColor(primaryDark)
                setCollapsedTitleTextColor(collapsedTextColor)
            }
        }
        this.toolbar.setNavigationOnClickListener { activity.onBackPressed() }
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
        modelId?.let { this.presenter.loadModelData(it) }
        instanceState?.let {
            this.presenter.displayModel(it.getParcelable<Parcelable>(EXTRA_MODEL) as Model)
            this.presenter.displayPhotos(it.getParcelable<Parcelable>(EXTRA_IMAGE) as Photo)
            this.imagesPager.currentItem = it.getInt(EXTRA_CURRENT_IMAGE)
        }
    }


    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.let {
            it.putParcelable(EXTRA_MODEL, this.presenter.model)
            it.putParcelable(EXTRA_IMAGE, this.presenter.photo)
            it.putInt(EXTRA_CURRENT_IMAGE, this.imagesPager.currentItem)
        }
    }

    override fun displayModelDetails() {
        if (this.adapter == null) {
            this.adapter = ModelDetailsAdapter(context, this.presenter)
        }
        if (this.recyclerView!!.adapter == null) {
            this.recyclerView!!.adapter = this.adapter
        }
        this.adapter?.notifyDataSetChanged()
    }

    override fun displayPhotos() {
        if (this.viewPagerAdapter == null) {
            this.viewPagerAdapter = ImagesPagerAdapter(fragmentManager, this.presenter)
            this.imagesPager.adapter = this.viewPagerAdapter
        }
        this.viewPagerAdapter?.notifyDataSetChanged()
    }

    companion object {
        val EXTRA_MODEL_ID = "modelId"
        private val EXTRA_MODEL = "model"
        private val EXTRA_IMAGE = "imageSource"
        private val EXTRA_CURRENT_IMAGE = "displayedImage"

        fun createInstance(modelId: String): ModelDetailsFragment {
            val framgnet = ModelDetailsFragment()
            val args = Bundle()
            args.putString(ModelDetailsFragment.EXTRA_MODEL_ID, modelId)
            framgnet.arguments = args

            return framgnet
        }
    }
}
