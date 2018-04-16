package ventegocreative.co.nz.sot.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.model.domain.Pet
import ventegocreative.co.nz.sot.model.domain.PetList
import ventegocreative.co.nz.sot.model.mappers.PetDataSexMapper

class AnimalListAdapter constructor(val items: PetList, val click: AnimalListAdapter.ItemClickListener) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.petlist_item, parent, false)
        return ViewHolder(view, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.pets[position])
    }

    override fun getItemCount(): Int = items.pets.size

    class ViewHolder(val view: View, val click: ItemClickListener) : RecyclerView.ViewHolder(view) {

        @BindView(R.id.name)
        lateinit var nameTV: TextView
        @BindView(R.id.age)
        lateinit var ageTV: TextView
        @BindView(R.id.sex)
        lateinit var sexTV: TextView
        @BindView(R.id.size)
        lateinit var sizeTV: TextView

        init {
            ButterKnife.bind(this,view)
        }

        fun bind(pet: Pet) {
            with(pet) {
                itemView.setOnClickListener { click(this) }
                nameTV.text = name
                ageTV.text = "Age: $age"
                sexTV.text = PetDataSexMapper.petSexShortFullMapper(sex)
                sizeTV.text = "Size: $size"
            }
        }
    }

    interface ItemClickListener {
        operator fun invoke(item: Pet)
    }

}



