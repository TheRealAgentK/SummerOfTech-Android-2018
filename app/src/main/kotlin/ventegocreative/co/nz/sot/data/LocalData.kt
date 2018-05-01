package ventegocreative.co.nz.sot.data

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ventegocreative.co.nz.sot.data.models.Film

class LocalData(private val context: Context) {
	
	private val gson: Gson = Gson()
	
	fun saveFilm(film: Film) {
		val filmsGson = getSharedPrefs().getString(KEY_FILMS, "")
		
		val films = getFilmsListFromJson(filmsGson)
		films.add(film)
		
		getSharedPrefs().edit().putString(KEY_FILMS, gson.toJson(films)).commit()
	}
	
	fun getFilms(): List<Film> = getFilmsListFromJson(getSharedPrefs().getString(KEY_FILMS, ""))
	
	private fun getSharedPrefs() = PreferenceManager.getDefaultSharedPreferences(context)
	
	private fun getFilmsListFromJson(json: String): MutableList<Film> {
		if (json.isNotEmpty()) {
			return Gson().fromJson<MutableList<Film>>(json, object : TypeToken<MutableList<Film>>() {}.type)
		}
		return mutableListOf()
	}
	
	
	companion object {
		val KEY_FILMS = "_KEY_FILMS"
	}
}