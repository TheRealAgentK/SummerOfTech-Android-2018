package ventegocreative.co.nz.sot.data

import android.arch.lifecycle.LiveData
import android.content.Context
import android.util.Log
import org.jetbrains.anko.doAsync
import ventegocreative.co.nz.sot.data.models.Film
import java.net.UnknownHostException


object DataManager {
	
	lateinit var database: FilmDatabase
	
	fun init(context: Context) {
		database = FilmDatabase.create(context)
	}
	
	fun getFilms(): LiveData<List<Film>> {
		try {
//			Try and refresh remote data
			val films: List<Film> = FilmsRequest().send()
			
			database.filmDao().insertAllFilms(films)
			
		} catch (e: UnknownHostException) {
//			Do offline behaviour
			Log.d("DataManager", "UnknownHostException")
		}
		
		return database.filmDao().loadFilms()
	}
	
	fun saveFilm(film: Film) {
		doAsync {
			database.filmDao().insertFilm(film)
		}
	}
}