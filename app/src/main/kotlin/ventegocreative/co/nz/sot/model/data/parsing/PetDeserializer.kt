package ventegocreative.co.nz.sot.model.data.parsing

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import ventegocreative.co.nz.sot.model.data.*
import java.lang.reflect.Type
import java.util.*

class PetDeserializer : JsonDeserializer<Pet> {

    @Throws(JsonParseException::class)
    override fun deserialize(jElement: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Pet {
        val jObject = jElement.asJsonObject

        val gsonBldr = GsonBuilder()
        gsonBldr.registerTypeAdapter(Breed::class.java, BreedDeserializer())
        gsonBldr.registerTypeAdapter(Contact::class.java, ContactDeserializer())
        val g = gsonBldr.create()

        val ageValue = jObject.get("age").asJsonObject.getAsJsonPrimitive("\$t")
        val sizeValue = jObject.get("size").asJsonObject.getAsJsonPrimitive("\$t")
        val idValue = jObject.get("id").asJsonObject.getAsJsonPrimitive("\$t")

        val breedsObj = jObject.get("breeds").asJsonObject
        val breed:List<Breed>
        if (breedsObj.get("breed").isJsonArray) {
            val breedType = object:TypeToken<List<Breed>>() {}.type
            breed = g.fromJson<List<Breed>>(breedsObj.get("breed"), breedType)
        } else {
            val single = g.fromJson(breedsObj.get("breed"), Breed::class.java)
            breed = ArrayList<Breed>()
            breed.add(single)
        }
        val breedsValue = Breeds(breed)

        val contactObj = jObject.get("contact").asJsonObject
        val contactValue = g.fromJson(contactObj, Contact::class.java)

        val nameValue = jObject.get("name").asJsonObject.getAsJsonPrimitive("\$t")
        val sexValue = jObject.get("sex").asJsonObject.getAsJsonPrimitive("\$t")
        val animalValue = jObject.get("animal").getAsJsonObject().getAsJsonPrimitive("\$t")
        return Pet(ageValue.asString, sizeValue.asString, contactValue, idValue.asInt, breedsValue, nameValue.asString, sexValue.asString, animalValue.asString)
    }
}



