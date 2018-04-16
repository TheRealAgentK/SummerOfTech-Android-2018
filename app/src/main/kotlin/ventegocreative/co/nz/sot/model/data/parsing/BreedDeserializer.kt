package ventegocreative.co.nz.sot.model.data.parsing

import com.google.gson.*
import ventegocreative.co.nz.sot.model.data.Breed

import java.lang.reflect.Type

class BreedDeserializer : JsonDeserializer<Breed> {

    @Throws(JsonParseException::class)
    override fun deserialize(jElement: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Breed {
        val jObject = jElement.asJsonObject

        val breedValue = jObject.getAsJsonPrimitive("\$t")

        return Breed(breedValue.asString)
    }
}