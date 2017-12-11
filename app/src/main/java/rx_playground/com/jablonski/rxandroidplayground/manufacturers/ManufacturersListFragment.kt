package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import rx_playground.com.jablonski.rxandroidplayground.R
import rx_playground.com.jablonski.rxandroidplayground.activities.MainActivity
import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseListFragment
import rx_playground.com.jablonski.rxandroidplayground.modellist.ModelsListFragment
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer
import rx_playground.com.jablonski.rxandroidplayground.views.adapters.recyclerview.ManufacturersListAdapter

/**
 * Created by yabol on 06.04.2017.
 */

class ManufacturersListFragment : BaseListFragment(), ManufacturersViewContract.View {

    private var presenter: ManufacturersListPresenter? = null
    private var adapter: ManufacturersListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as MainActivity
        if (this.presenter == null) {
            this.presenter = ManufacturersListPresenter(this)
            val repository = ManufacturersRepository(this.presenter!!)
            this.presenter?.setRepository(repository)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        this.recyclerView.layoutManager = LinearLayoutManager(context)
        activity.title = getString(R.string.manufacturers_fragment_title)
        return view
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
        if (instanceState?.getParcelableArrayList<Parcelable>(EXTRA_CONCERNS) != null) {
            presenter?.displayElements(instanceState.getParcelableArrayList(EXTRA_CONCERNS))
        } else {
            showLoadingIndicator()
            presenter?.loadElements("2017")
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putParcelableArrayList(EXTRA_CONCERNS, presenter!!.elements as ArrayList<out Parcelable>)
    }

    override fun showView(manufacturers: List<Manufacturer>) {
        if (this.adapter == null) {
            this.adapter = ManufacturersListAdapter(context, this.presenter)
            this.adapter?.setOnClickListener(this.presenter)
        }
        if (this.recyclerView.adapter == null) {
            this.recyclerView.adapter = this.adapter
        }
        this.adapter?.notifyDataSetChanged()
        hideLoadingIndicator()
    }


    override fun showListFragment(manufacturer: String, models: List<Model>) {
        activity.startFragment(ModelsListFragment.createInstance(manufacturer, models), false)
    }

    companion object {
        private val EXTRA_CONCERNS = "Concerns"
    }

}
