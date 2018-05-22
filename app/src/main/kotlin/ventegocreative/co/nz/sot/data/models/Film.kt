package ventegocreative.co.nz.sot.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
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
		var id: String,
		
		@ColumnInfo(name = "title")
		@SerializedName("title")
		var title: String,
		
		@ColumnInfo(name = "description")
		@SerializedName("description")
		var description: String,
		
		@ColumnInfo(name = "director")
		@SerializedName("director")
		var director: String,
		
		@ColumnInfo(name = "release_date")
		@SerializedName("release_date")
		var releaseDate: String
		
) : Parcelable {
	
	@Ignore
	constructor(title: String, description: String, director: String, releaseDate: String) :
			this(UUID.randomUUID().toString(), title, description, director, releaseDate)
	
	companion object {
		const val TABLE_NAME = "films"
	}
}