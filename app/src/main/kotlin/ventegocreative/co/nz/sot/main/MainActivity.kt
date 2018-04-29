package ventegocreative.co.nz.sot.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.FilmsRequest
import ventegocreative.co.nz.sot.data.models.Film

class MainActivity : AppCompatActivity() {
	
	@BindView(R.id.film_list)
	lateinit var filmList: RecyclerView
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		MainActivityUI().setContentView(this)
		ButterKnife.bind(this)
		
		doAsync(exceptionHandler = { throwable: Throwable -> throwable.printStackTrace() }) {
			val remoteFilmsList = FilmsRequest().send()
			uiThread {
				filmList.adapter = FilmListAdapter(remoteFilmsList, { film: Film ->
					Toast.makeText(this@MainActivity, film.title, Toast.LENGTH_SHORT).show()
				})
			}
		}
	}
}


class MainActivityUI : AnkoComponent<MainActivity> {
	
	override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
		frameLayout {
			recyclerView {
				id = R.id.film_list
				layoutManager = LinearLayoutManager(ctx)
			}
		}
	}
}