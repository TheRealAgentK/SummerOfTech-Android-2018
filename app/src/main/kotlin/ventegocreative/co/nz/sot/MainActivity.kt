package ventegocreative.co.nz.sot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ventegocreative.co.nz.sot.adapters.AnimalListAdapter
import ventegocreative.co.nz.sot.commands.PetFindCommand
import ventegocreative.co.nz.sot.model.domain.Pet

class MainActivity : AppCompatActivity() {

    @BindView(R.id.animal_list)
    lateinit var animalList: RecyclerView

    private val animalItems = listOf(
            "Molly - 12 yrs - Persian",
            "Max - 7 yrs - German Shepherd",
            "Tantala - 2 months - Chicken")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        frameLayout {
            recyclerView {
                id = R.id.animal_list
                layoutManager = LinearLayoutManager(ctx)
            }
        }

        ButterKnife.bind(this)

        animalList.layoutManager = LinearLayoutManager(this)

        doAsync(exceptionHandler = { throwable : Throwable -> throwable.printStackTrace() }) {
            val result = PetFindCommand("90210","cat").execute()
            uiThread {
                animalList.adapter = AnimalListAdapter(result,
                        object: AnimalListAdapter.ItemClickListener{
                            override fun invoke(pet: Pet) {
                                toast(pet.name)
                            }
                        }
                )
            }
        }
    }
}