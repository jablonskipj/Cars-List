package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import rx_playground.com.jablonski.rxandroidplayground.mvp.BaseViewCotract
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer

/**
 * Created by yabol on 06.04.2017.
 */

class ManufacturersListPresenter(private val view: ManufacturersViewContract.View) :
        ManufacturersViewContract.Presenter,
        BaseViewCotract.BaseProvider<Manufacturer>,
        BaseViewCotract.BaseOnItemCLickListener<Manufacturer> {

    private var repository: ManufacturersViewContract.Repository? = null
    private var manufacturers: List<Manufacturer>? = null
    fun setRepository(repository: ManufacturersViewContract.Repository) {
        this.repository = repository
    }

    override fun loadElements(year: String) {
        this.repository?.getManufacturers(year)

    }

    override fun displayElements(elements: List<Manufacturer>) {
        this.manufacturers = elements
        this.view.showView(elements)
    }

    override fun getElements(): List<Manufacturer>? {
        return manufacturers
    }

    override fun getCount(): Int {
        return if (this.manufacturers != null)
            this.manufacturers!!.size
        else
            0
    }


    override fun getObject(position: Int): Manufacturer? {
        return if (this.manufacturers != null) this.manufacturers!![position] else null
    }

    override fun performClick(item: Manufacturer) {
        view.showListFragment(item.name, item.models)
    }
}
