package ventegocreative.co.nz.sot.main

import android.app.NotificationChannel
import android.app.NotificationManager
import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.BindView
import butterknife.ButterKnife
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.iid.FirebaseInstanceId
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.DataManager
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

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			// Create channel to show notifications.
			val channelId = getString(R.string.default_notification_channel_id)
			val channelName = getString(R.string.default_notification_channel_name)
			val notificationManager = getSystemService(NotificationManager::class.java)
			notificationManager!!.createNotificationChannel(NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH))
		}

		ButterKnife.bind(this)

		addFab.setOnClickListener { startActivityForResult(FormActivity.getIntent(this), REQUESTCODE_ADDFILM) }

		fetchAndDisplayFilmsList()

		mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)

		val token = FirebaseInstanceId.getInstance().token

		Log.d("MainActivity", "onCreate, token is: " + token)
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//		if (resultCode == Activity.RESULT_OK) {
//			when (requestCode) {
//				REQUESTCODE_ADDFILM -> fetchAndDisplayFilmsList()
//			}
//		}
		super.onActivityResult(requestCode, resultCode, data)
	}
	
	private fun fetchAndDisplayFilmsList() {
		doAsync(exceptionHandler = { throwable: Throwable -> throwable.printStackTrace() }) {
			
			DataManager.getFilms().observe(this@MainActivity, Observer { filmsList: List<Film>? ->
				Log.d("MainActivity", "Film list updated")
				uiThread {
					filmList.adapter = FilmListAdapter(filmsList ?: emptyList(), { film: Film ->
						startActivity(DetailActivity.getIntent(this@MainActivity, film))
					})
				}
			})
			
		}
	}
	
	companion object {
		val REQUESTCODE_ADDFILM = 19
	}
}