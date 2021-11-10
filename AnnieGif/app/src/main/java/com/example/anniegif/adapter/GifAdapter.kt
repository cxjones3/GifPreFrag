package com.example.anniegif.adapter

import android.content.res.Resources
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.anniegif.R
import com.example.anniegif.databinding.ItemImageBinding
import com.example.anniegif.model.nekos


class GifAdapter : RecyclerView.Adapter<GifAdapter.GifViewHolder>(){
    private val urls = mutableListOf<nekos>()



    class GifViewHolder(private val binding : ItemImageBinding)
        : RecyclerView.ViewHolder(binding.root){


        @RequiresApi(Build.VERSION_CODES.O)
        fun loadImage(nekoObj: nekos) = with(binding){

                val imageUrl= nekoObj.url
                itext.text = nekoObj.animeName
            ivImage.setTooltipText(imageUrl.toString())
            Log.d("Tool",ivImage.tooltipText.toString())
            //= imageUrl.toCharArray().toString()

          //  val drawable: Drawable? = ResourcesCompat.getDrawable(Resources.getSystem(), R.drawable.nope, null)
            //val resources: Resources = resources
            //ivImage.setImageDrawable(resources.getDrawable(com.example.anniegif.R.drawable.nope))


            Glide.with(ivImage)
                    .load(imageUrl)
                .error(
                    Glide.with(ivImage)
                        .load(R.drawable.nope))
                    .into(ivImage)


        }

        companion object{
            fun getInstance(parent: ViewGroup) : GifViewHolder{
                Log.d("Adapter","companino")
                val binding =   ItemImageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,false
                )
                return GifViewHolder(binding)
            }
        }

    }

    fun updateUrls(urls: List<nekos>){
        Log.d("Adapter","update url")
        val size = this.urls.size
        this.urls.clear()
        notifyItemRangeRemoved(0,size)

        this.urls.addAll(urls)
        notifyItemRangeInserted(0, urls.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        Log.d("Adapter","create")
        return GifViewHolder.getInstance(parent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        Log.d("Adapter","onbvh")
        holder.loadImage(urls[position])
    }

    override fun getItemCount(): Int {
        Log.d("Adapter","size")
        return urls.size
    }
}