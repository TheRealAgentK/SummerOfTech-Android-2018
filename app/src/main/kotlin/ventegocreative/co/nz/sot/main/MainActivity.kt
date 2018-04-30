package ventegocreative.co.nz.sot.main

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ventegocreative.co.nz.sot.R
import ventegocreative.co.nz.sot.data.FilmsRequest
import ventegocreative.co.nz.sot.data.models.Film
import ventegocreative.co.nz.sot.detail.DetailActivity
import ventegocreative.co.nz.sot.form.FormActivity

class MainActivity : AppCompatActivity() {
	
	@BindView(R.id.film_list)
	lateinit var filmList: RecyclerView
	@BindView(R.id.add_fab)
	lateinit var addFab: FloatingActionButton
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		setContentView(R.layout.activity_main)
		
		ButterKnife.bind(this)
		
		addFab.setOnClickListener { startActivity(FormActivity.getIntent(this)) }
		
		doAsync(exceptionHandler = { throwable: Throwable -> throwable.printStackTrace() }) {
			val remoteFilmsList = FilmsRequest().send()
			uiThread {
				filmList.adapter = FilmListAdapter(remoteFilmsList, { film: Film ->
					startActivity(DetailActivity.getIntent(this@MainActivity, film))
				})
			}
		}
	}
}