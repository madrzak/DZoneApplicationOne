package ie.redstudio.dzoneapplicationone

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ie.redstudio.dzoneapplicationone.data.AppDatabase
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MovieListFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var mViewModel: NewMovieViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewMovieViewModel::class.java)
        mViewModel.retrieveMovies()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener {

            val dao =  AppDatabase.getInstance(this.context!!)?.movieDao()
            GlobalScope.launch {
               dao?.getAll()
            }

            listener?.goToNewMovieFragment()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {
        fun goToNewMovieFragment()
    }

    companion object {

        @JvmStatic
        fun newInstance() = MovieListFragment()
    }
}
