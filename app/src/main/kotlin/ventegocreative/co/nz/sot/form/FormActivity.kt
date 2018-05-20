package ventegocreative.co.nz.sot.form

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.LocalData
import ventegocreative.co.nz.sot.data.models.Film
import ventegocreative.co.nz.sot.databinding.ActivityFormBinding

import ventegocreative.co.nz.sot.detail.DetailViewModel

class FormActivity : AppCompatActivity() {
	
	lateinit var binding: ActivityFormBinding

	lateinit var mFirebaseAnalytics: FirebaseAnalytics
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = DataBindingUtil.setContentView(this, R.layout.activity_form)

		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		
		binding.doneFab.setOnClickListener { saveFilm() }
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		if (item.itemId == android.R.id.home) {
			onBackPressed()
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	override fun onBackPressed() {
		setResult(Activity.RESULT_CANCELED)
		super.onBackPressed()
	}
	
	
	private fun saveFilm() {
		with(binding) {
			LocalData(this@FormActivity).saveFilm(Film(
					titleEt.text.toString(),
					descriptionEt.text.toString(),
					directorEt.text.toString(),
					releaseDateEt.text.toString()))
		}
		setResult(Activity.RESULT_OK)

		val params = Bundle()
		params.putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, binding.titleEt.text.toString())

		mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.UNLOCK_ACHIEVEMENT, params)

		Log.i(FormActivity::class.java.simpleName, "Added new movie: " + binding.titleEt.text.toString())

		finish()
	}
	
	companion object {
		
		fun getIntent(context: Context): Intent = Intent(context, FormActivity::class.java)
		
	}
}
