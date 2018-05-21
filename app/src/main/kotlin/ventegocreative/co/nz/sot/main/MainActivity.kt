package ventegocreative.co.nz.sot.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.crashlytics.android.Crashlytics
import com.google.firebase.analytics.FirebaseAnalytics
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.FilmsRequest
import ventegocreative.co.nz.sot.data.LocalData
import ventegocreative.co.nz.sot.data.models.Film
import ventegocreative.co.nz.sot.detail.DetailActivity
import ventegocreative.co.nz.sot.form.FormActivity

class MainActivity : AppCompatActivity() {
	
	@BindView(R.id.film_list)
	lateinit var filmList: RecyclerView
	@BindView(R.id.add_fab)
	lateinit var addFab: FloatingActionButton

	lateinit var mFirebaseAnalytics: FirebaseAnalytics

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_main)

		ButterKnife.bind(this)

		addFab.setOnClickListener { startActivityForResult(FormActivity.getIntent(this), REQUESTCODE_ADDFILM) }

		fetchAndDisplayFilmsList()

		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		if (resultCode == Activity.RESULT_OK) {
			when (requestCode) {
				REQUESTCODE_ADDFILM -> fetchAndDisplayFilmsList()
			}
		}
		super.onActivityResult(requestCode, resultCode, data)
	}
	
	private fun fetchAndDisplayFilmsList() {
		doAsync(exceptionHandler = { throwable: Throwable -> throwable.printStackTrace() }) {
			
			val localFilmsList = LocalData(this@MainActivity).getFilms()
			val remoteFilmsList = FilmsRequest().send()
			val combinedFilmsList = localFilmsList.plus(remoteFilmsList)

			uiThread {
				filmList.adapter = FilmListAdapter(combinedFilmsList, { film: Film ->
					startActivity(DetailActivity.getIntent(this@MainActivity, film))
				})
			}
		}
	}

	companion object {
		val REQUESTCODE_ADDFILM = 19
	}
}