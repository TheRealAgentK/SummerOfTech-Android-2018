package ventegocreative.co.nz.sot.detail

import android.content.Context
import android.databinding.BindingAdapter
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.models.Film

class DetailViewModel(private val context: Context, private val film: Film) {
	
	fun getTitle() = film.title
	
	fun getSubtitle() = "${film.director} - ${film.releaseDate}"
	
	fun getDescription() = film.description
	
	fun getImageUrl() = "https://robohash.org/${film.id}.png?bgset=any"

	fun onClickBuyMovie() {
		Toast.makeText(context, context.getString(R.string.puchaseOkToast), Toast.LENGTH_SHORT).show()
		Log.i(DetailViewModel::class.java.simpleName, "Purchased: " + getTitle())
	}

	companion object {
		
		@JvmStatic
		@BindingAdapter("bind:imageUrl")
		fun loadImage(view: ImageView, imageUrl: String) {
			Picasso.with(view.context)
					.load(imageUrl)
					.error(R.drawable.mock_image)
					.into(view)
		}
	}

}