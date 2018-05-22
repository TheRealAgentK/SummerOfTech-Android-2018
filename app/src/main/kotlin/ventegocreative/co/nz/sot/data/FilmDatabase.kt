package ventegocreative.co.nz.sot.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ventegocreative.co.nz.sot.data.models.Film

@Database(
		entities = [
			Film::class
		],
		version = 1
)
abstract class FilmDatabase : RoomDatabase() {
	
	abstract fun filmDao(): FilmsDao
	
	companion object {
		private const val DB_NAME: String = "films-database"
		
		fun create(context: Context): FilmDatabase {
			return Room.databaseBuilder(context, FilmDatabase::class.java, DB_NAME).build()
		}
	}
}