package ventegocreative.co.nz.sot.data

import android.content.Context


object DataManager{
	
	lateinit var database: FilmDatabase
	
	fun init(context: Context) {
		database = FilmDatabase.create(context)
	}
	
}