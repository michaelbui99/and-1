package io.github.michaelbui99.listsdynamicviewchanges

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CelebrityAdapter.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celebrityList: RecyclerView = findViewById(R.id.recyclerview_celebs)
        celebrityList.layoutManager = LinearLayoutManager(this)

        val celebrities: List<Celebrity> = listOf(
            Celebrity(
                name = "Krystal Jung",
                gender = Gender.F,
                quote = "You might have a past.. but guess what? You have future, too.",
                imageUrl = "https://i.mydramalist.com/kN5bw_5f.jpg"
            ),
            Celebrity(
                name = "Nam Joo-hyuk",
                gender = Gender.M,
                quote = "Sports",
                imageUrl = "https://i.mydramalist.com/250rk_5f.jpg"
            ),
            Celebrity(
                name = "Seo Ye-ji",
                gender = Gender.F,
                quote = "You shouldn't be embarrassed about being sad",
                imageUrl = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRb1Q4wGpwofHWuNK2vcCqNrkExvySAabxS12zYbLSDr7w5znwR"
            ),
            Celebrity(
                name = "Lee Jong-suk",
                gender = Gender.M,
                quote = "I remember",
                imageUrl = "https://i.mydramalist.com/eLBmQ_5f.jpg"
            ),
        )
        celebrityList.adapter = CelebrityAdapter(celebrities, this);

    }

    override fun onClick(celebrity: Celebrity) {
        Toast.makeText(this, celebrity.quote, Toast.LENGTH_SHORT).show()
    }
}
