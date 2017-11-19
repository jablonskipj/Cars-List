package rx_playground.com.jablonski.rxandroidplayground.activities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import butterknife.ButterKnife
import rx_playground.com.jablonski.rxandroidplayground.R
import rx_playground.com.jablonski.rxandroidplayground.manufacturers.ManufacturersListFragment

class MainActivity : AppCompatActivity() {
    lateinit var manager: FragmentManager
    var actionBar: ActionBar? = null
    lateinit var toolbar: Toolbar


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        toolbar = findViewById(R.id.toolbar) as Toolbar

        setSupportActionBar(toolbar)

        actionBar = supportActionBar
        manager = supportFragmentManager

        if (savedInstanceState == null) {
            val fragment = ManufacturersListFragment()
            startFragment(fragment, true)

        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun startFragment(fragment: Fragment, replace: Boolean) {
        val transaction = manager.beginTransaction()

        transaction.setCustomAnimations(R.anim.slide_to_right, R.anim.slide_from_right)

        if (replace) {
            transaction.replace(R.id.fragmentContainer, fragment).addToBackStack(null)
        } else {
            transaction.add(R.id.fragmentContainer, fragment).addToBackStack(null)
        }
        transaction.commitAllowingStateLoss()

        Log.e("MainActivity", "BackPress fragments count: " + manager.backStackEntryCount)

        manageToolbarBackButton(manager)
    }

    private fun manageToolbarBackButton(manager: FragmentManager) {
        val fragmentsCount = manager.backStackEntryCount
        if (fragmentsCount > 0) {
            actionBar!!.setDisplayShowHomeEnabled(true)
            actionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onBackPressed() {
        val fragmentsCount = manager.backStackEntryCount

        Log.e("MainActivity", "BackPress fragments count: " + fragmentsCount)
        if (fragmentsCount == 2) {
            actionBar!!.setDisplayHomeAsUpEnabled(false)
            actionBar!!.setDisplayShowHomeEnabled(false)
        }

        if (fragmentsCount == 1) {
            finish()
        } else {
            manager.popBackStack()
        }

    }
}


