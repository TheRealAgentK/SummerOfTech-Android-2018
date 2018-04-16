package ventegocreative.co.nz.sot.model.data.parsing

import com.google.gson.*
import ventegocreative.co.nz.sot.model.data.Contact

import java.lang.reflect.Type

class ContactDeserializer : JsonDeserializer<Contact> {

    @Throws(JsonParseException::class)
    override fun deserialize(jElement: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Contact {
        val jObject = jElement.asJsonObject

        val stateValue  = jObject.get("state").asJsonObject.getAsJsonPrimitive("\$t")
        val cityValue = jObject.get("city").asJsonObject.getAsJsonPrimitive("\$t")
        val zipValue = jObject.get("zip").asJsonObject.getAsJsonPrimitive("\$t")

        return Contact(stateValue.asString, cityValue.asString, zipValue.asInt)
    }
}
