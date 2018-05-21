package ventegocreative.co.nz.sot.detail

import android.content.Context
import android.databinding.BindingAdapter
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.models.Film
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import com.google.firebase.analytics.FirebaseAnalytics
import java.util.*


class DetailViewModel(private val context: Context, private val film: Film) {
	
	fun getTitle() = film.title

	fun getId() = film.id
	
	fun getSubtitle() = "${film.director} - ${film.releaseDate}"
	
	fun getDescription() = film.description
	
	fun getImageUrl() = "https://robohash.org/${film.id}.png?bgset=any"

	fun onClickBuyMovie() {

		val mFirebaseAnalytics = FirebaseAnalytics.getInstance(context as DetailActivity)

		val params = Bundle()
		params.putString(FirebaseAnalytics.Param.CURRENCY, "NZD")
		params.putString(FirebaseAnalytics.Param.VALUE, rand(5,13).toString())
		params.putString("film_id", getId())

		mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE, params)

		Toast.makeText(context, context.getString(R.string.puchaseOkToast), Toast.LENGTH_SHORT).show()
		Log.i(DetailViewModel::class.java.simpleName, "Purchased: " + getTitle())
	}

	fun onClickCrash() {
		Crashlytics.getInstance().crash()
	}

	private fun rand(from: Int, to: Int) : Int {
		val random = Random()
		return random.nextInt(to - from) + from
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