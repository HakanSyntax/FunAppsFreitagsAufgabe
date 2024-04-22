package de.syntax_institut.funappsvorlage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntax_institut.funappsvorlage.data.datamodels.Result
import de.syntax_institut.funappsvorlage.databinding.ListItemResultBinding
import de.syntax_institut.funappsvorlage.ui.SearchFragmentDirections

class SearchAdapter(
    private val dataset: List<Result>
) : RecyclerView.Adapter<SearchAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(val binding: ListItemResultBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ListItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Hole das Ergebnis aus der Liste
        val result = dataset[position]
        val imgUri = result.artworkUrl100?.toUri()?.buildUpon()?.scheme("https")?.build()


        // Setze Songtitel und Künstler
        holder.binding.tvTrackName.text = result.trackName
        holder.binding.tvArtistName.text = result.artistName
        holder.binding.tvCoverImg.load(imgUri)
        holder.binding.tvTrackTime.text = formatMillis(result.trackTimeMillis)

        holder.binding.songCard.setOnClickListener {
            val navController = it.findNavController()
            val action = SearchFragmentDirections.actionSearchFragmentToDetailFragment(
                trackName = result.trackName ?: "",
                artistName = result.artistName ?: "",
                primaryGenreName = result.primaryGenreName ?: "",
                trackTimeMillis = result.trackTimeMillis?: 0,
                releaseDate = result.releaseDate ?: "",
                trackPrice = (result.trackPrice?: "").toString(),
                artworkUrl100 = result.artworkUrl100 ?: ""
            )
            navController.navigate(action)
        }
    }



    fun formatMillis(millis: Int?): String {
        if (millis == null) return "p/a"
        val seconds = millis / 1000 % 60
        val minutes = millis / (1000 * 60) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}


