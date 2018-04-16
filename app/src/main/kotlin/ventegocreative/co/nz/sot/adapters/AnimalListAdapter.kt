package ventegocreative.co.nz.sot.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import ventegocreative.co.nz.sot.model.domain.PetList

class AnimalListAdapter constructor(val items: PetList) : RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(items.pets[position]) {
            holder.textView.text = "$name ($age, $sex, $size)"
        }
    }

    override fun getItemCount(): Int = items.pets.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}

