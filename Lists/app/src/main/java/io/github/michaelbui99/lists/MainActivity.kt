package io.github.michaelbui99.lists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var redditPostsList : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val redditPostList = findViewById<RecyclerView>(R.id.recycler_view);
        redditPostList.layoutManager = LinearLayoutManager(this);

        val redditPosts: List<RedditPost> = listOf(
            RedditPost("post 1", R.drawable.ic_launcher_background),
            RedditPost("post 2", R.drawable.ic_launcher_foreground),
            RedditPost("post 3", R.drawable.ic_launcher_background),
            RedditPost("post 4", R.drawable.ic_launcher_foreground),
            RedditPost("post 5", R.drawable.ic_launcher_background),
            RedditPost("post 6", R.drawable.ic_launcher_foreground),
            RedditPost("post 7", R.drawable.ic_launcher_background),
            RedditPost("post 8", R.drawable.ic_launcher_foreground)
        )

        val redditPostAdapter = RedditPostAdapter(redditPosts);
        redditPostList.adapter = redditPostAdapter;
    }
}