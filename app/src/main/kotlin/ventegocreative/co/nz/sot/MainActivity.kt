package ventegocreative.co.nz.sot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import ventegocreative.co.nz.sot.adapters.AnimalListAdapter

class MainActivity : AppCompatActivity() {

    @BindView(R.id.animal_list)
    lateinit var animalList: RecyclerView

    private val animalItems = listOf(
        "Molly - 12 yrs - Persian",
        "Max - 7 yrs - German Shepherd",
        "Tantala - 2 months - Chicken")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        animalList.layoutManager = LinearLayoutManager(this)
        animalList.adapter = AnimalListAdapter(animalItems)

  }
}
