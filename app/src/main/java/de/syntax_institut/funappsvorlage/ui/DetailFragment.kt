package de.syntax_institut.funappsvorlage.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import coil.load
import de.syntax_institut.funappsvorlage.databinding.FragmentDetailBinding
import de.syntax_institut.funappsvorlage.ui.SearchViewModel

class DetailFragment : Fragment() {
    private val viewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding

    private var artistName = ""
    private var trackName = ""
    private var artworkUrl100 = ""
    private var trackTimeMillis = 0
    private var primaryGenreName = ""
    private var releaseDate = ""
    private var trackPrice = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments.let {
            trackName = it?.getString("trackName").toString()
            artistName = it?.getString("artistName").toString()
            primaryGenreName = it?.getString("primaryGenreName").toString()
            trackTimeMillis = it?.getInt("trackTimeMillis") ?: 0
            releaseDate = it?.getString("releaseDate").toString()
            trackPrice = it?.getString("trackPrice").toString()
            artworkUrl100 = it?.getString("artworkUrl100").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val endPrice = trackPrice + "€"
        val coverUri = artworkUrl100?.toUri()?.buildUpon()?.scheme("https")?.build()

        binding.tvTrackNameDetail1.text = trackName
        binding.tvArtistNameDetail1.text = artistName
        binding.tvGenreDetail2.text = primaryGenreName
        binding.tvLangeDetail2.text = formatMillis(trackTimeMillis)
        binding.tvVeroffentlichtDetail2.text = releaseDate
        binding.tvPreisDetail2.text = endPrice
        binding.tvCoverImgDetail.load(coverUri)
    }

    fun formatMillis(millis: Int?): String {
        if (millis == null) return "p/a"
        val seconds = millis / 1000 % 60
        val minutes = millis / (1000 * 60) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }
}


