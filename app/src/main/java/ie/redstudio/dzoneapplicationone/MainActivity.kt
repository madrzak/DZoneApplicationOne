package ie.redstudio.dzoneapplicationone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(), NewMovieFragment.OnFragmentInteractionListener,
    MovieListFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        if (savedInstanceState == null) {
            goToMovieListFragment()
        }
    }

    override fun goToNewMovieFragment() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NewMovieFragment.newInstance())
        transaction.commit()
    }

    override fun goToMovieListFragment() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, MovieListFragment.newInstance())
        transaction.commit()
    }
}
