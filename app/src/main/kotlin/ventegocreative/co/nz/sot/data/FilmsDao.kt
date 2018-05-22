package ventegocreative.co.nz.sot.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import ventegocreative.co.nz.sot.data.models.Film


@Dao
interface FilmsDao {
	
	@Query("SELECT * FROM films")
	fun loadFilms(): LiveData<List<Film>>
	
	@Query("SELECT * FROM films WHERE id = :filmId")
	fun loadFilm(filmId: Int): LiveData<Film>
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAllFilms(films: List<Film>)
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertFilm(film: Film)
}