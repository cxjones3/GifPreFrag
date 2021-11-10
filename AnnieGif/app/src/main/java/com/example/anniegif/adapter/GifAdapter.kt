package com.example.anniegif.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anniegif.databinding.ItemImageBinding
import com.example.anniegif.model.Neko
import com.example.anniegif.utils.loadUrl

class GifAdapter(
    private val nekoSelected: (Neko) -> Unit
) : RecyclerView.Adapter<GifAdapter.GifViewHolder>() {
    private val urls = mutableListOf<Neko>()

    class GifViewHolder(
        private val binding: ItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun loadImage(nekoObj: Neko) = with(binding) {
            val imageUrl = nekoObj.url
            itext.text = nekoObj.animeName
            ivImage.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) tooltipText = imageUrl
                contentDescription = imageUrl
                loadUrl(imageUrl)
            }
            return@with
        }

        companion object {
            fun getInstance(parent: ViewGroup): GifViewHolder {
                Log.d("Adapter", "companino")
                val binding = ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                return GifViewHolder(binding)
            }
        }

    }

    fun updateUrls(urls: List<Neko>) = with(this.urls) {
        val size = size
        clear()
        notifyItemRangeRemoved(0, size)

        addAll(urls)
        notifyItemRangeInserted(0, urls.size)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = GifViewHolder.getInstance(parent).also { holder ->
        holder.itemView.setOnClickListener { nekoSelected(urls[holder.adapterPosition]) }
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.loadImage(urls[position])
    }

    override fun getItemCount(): Int {
        return urls.size
    }
}