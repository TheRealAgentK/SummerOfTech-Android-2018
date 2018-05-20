package ventegocreative.co.nz.sot.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Film(
		@SerializedName("id") val id: String,
		@SerializedName("title") val title: String,
		@SerializedName("description") val description: String,
		@SerializedName("director") val director: String,
		@SerializedName("release_date") val releaseDate: String
		
//		Everything below is included in the API, but not needed for this basic app
//		@SerializedName("producer") val producer: String,
//		@SerializedName("rt_score") val rtScore: String,
//		@SerializedName("people") val people: List<String>,
//		@SerializedName("species") val species: List<String>,
//		@SerializedName("locations") val locations: List<String>,
//		@SerializedName("vehicles") val vehicles: List<String>,
//		@SerializedName("url") val url: String
) : Parcelable {
	
	constructor(title: String, description: String, director: String, releaseDate: String) :
			this(UUID.randomUUID().toString(), title, description, director, releaseDate)
	
}