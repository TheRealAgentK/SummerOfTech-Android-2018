package ventegocreative.co.nz.sot.model.mappers

class PetDataSexMapper {

    companion object {

        fun petSexShortFullMapper(shortSex:String):String {
            when (shortSex) {
                "M" -> return "Male"
                "F" -> return "Female"
            }

            return "Unspecified"
        }

    }
}

