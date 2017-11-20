package rx_playground.com.jablonski.rxandroidplayground.manufacturers

import java.util.ArrayList

import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersViewContract
import rx_playground.com.jablonski.rxandroidplayground.model.Model
import rx_playground.com.jablonski.rxandroidplayground.model.Manufacturer
import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersListPresenter

/**
 * Created by yabol on 13.04.2017.
 */

class ManufacturersRepositoryMock(private val presenter: ManufacturersListPresenter) : ManufacturersViewContract.Repository {
    override fun getManufacturers(year: String) {
        val manufacturers = ArrayList<Manufacturer>()
        val manu = Manufacturer("bmw")
        manu.name = "BMW"
        val bmw = Model("x3")
        bmw.niceName = "X3 3.0D"
        bmw.submodelName = "X3 3.0D M"
        manu.addModel(bmw)
        manufacturers.add(manu)
        manufacturers.add(Manufacturer("Audi"))
        presenter.displayElements(manufacturers)
    }
}
