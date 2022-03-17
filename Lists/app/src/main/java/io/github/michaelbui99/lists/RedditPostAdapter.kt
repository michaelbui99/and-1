package io.github.michaelbui99.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RedditPostAdapter(private val redditPosts: List<RedditPost>) : RecyclerView.Adapter<RedditPostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RedditPostAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        val view: View = inflater.inflate(R.layout.reddit_post_list_item, parent, false);

        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: RedditPostAdapter.ViewHolder, position: Int) {
        holder.postTitle.text = redditPosts[position].postTitle
        holder.postThumbnail.setImageResource(redditPosts[position].postThumbnail)
    }

    override fun getItemCount(): Int {
        return redditPosts.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var postTitle: TextView = itemView.findViewById(R.id.post_title);
        var postThumbnail: ImageView =itemView.findViewById(R.id.post_thumbnail);
    }
}


