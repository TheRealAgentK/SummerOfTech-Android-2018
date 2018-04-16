package ventegocreative.co.nz.sot.model.domain

data class PetList(val pets: List<Pet>)
data class Pet(val age: String, val size: String, val id: Int, val name: String, val sex: String, val animal: String)