package ventegocreative.co.nz.sot.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = Film.TABLE_NAME)
data class Film(
		@PrimaryKey
		@ColumnInfo(name = "id")
		@SerializedName("id")
		val id: String,
		
		@ColumnInfo(name = "title")
		@SerializedName("title")
		val title: String,
		
		@ColumnInfo(name = "description")
		@SerializedName("description")
		val description: String,
		
		@ColumnInfo(name = "director")
		@SerializedName("director")
		val director: String,
		
		@ColumnInfo(name = "release_date")
		@SerializedName("release_date")
		val releaseDate: String
		
) : Parcelable {
	
	constructor(title: String, description: String, director: String, releaseDate: String) :
			this(UUID.randomUUID().toString(), title, description, director, releaseDate)
	
	companion object {
		const val TABLE_NAME = "films"
	}
}