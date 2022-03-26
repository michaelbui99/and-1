package io.github.michaelbui99.listsdynamicviewchanges

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.Log
import android.util.Log.INFO
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide

class CelebrityAdapter(private val celebrities: List<Celebrity>, public var listener: OnClickListener) :
    Adapter<CelebrityAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.celebrity_list_item, parent, false)

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val containerColor = if (celebrities[position].gender == Gender.M) "#158B9F" else "#C62AE1"
        holder.container.setBackgroundColor(Color.parseColor(containerColor))
        holder.name.text = celebrities[position].name

        Glide.with(holder.image.context).load(celebrities[position].imageUrl)
            .placeholder(R.drawable.ic_launcher_background).dontAnimate().into(holder.image)
    }

    override fun getItemCount(): Int {
        return celebrities.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container: ConstraintLayout = itemView.findViewById(R.id.list_item_container)
        var name: TextView = itemView.findViewById(R.id.textview_name)
        var image: ImageView = itemView.findViewById(R.id.imageview_celeb)

        init {
            itemView.setOnClickListener(){
            listener.onClick(celebrities[bindingAdapterPosition])
            }
        }
    }

    interface OnClickListener{
        fun onClick(celebrity: Celebrity)
    }
}
