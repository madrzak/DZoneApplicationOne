package ie.redstudio.dzoneapplicationone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ie.redstudio.dzoneapplicationone.data.Movie

/**
 * Created by Łukasz on 2019-05-04.
 */
class MovieRecyclerAdapter(private val myDataset: List<Movie>) :
    RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)

        return MovieViewHolder(v)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.tvName.text = myDataset[position].name
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
    }

}



