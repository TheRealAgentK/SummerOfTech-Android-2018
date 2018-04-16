package ventegocreative.co.nz.sot.model.api

import android.content.Context
import com.google.gson.Gson
import ventegocreative.co.nz.sot.utils.DemoUtils
import java.net.URL

class PetfinderRequest(val zipCode: String, val animal: String, val myContext: Context) {

    companion object {

        private val PETFINDER_URL = "http://api.petfinder.com/pet.find"
        private val API_KEY = "90c7450f970315f4651d3ea5575cbb6b"
        private val RETURN_FORMAT = "json"

        private val REQUEST_URL = "$PETFINDER_URL?key=$API_KEY&format=$RETURN_FORMAT"

    }

    fun send(): String {

        //val result = URL(REQUEST_URL + "&location=" + zipCode + "&animal=" + animal).readText()
        //return Gson().fromJson(result, PetfinderResult::class.java)

        val results = DemoUtils(myContext).loadJSONFromAsset("sampledata.json")
        return results
    }
}
