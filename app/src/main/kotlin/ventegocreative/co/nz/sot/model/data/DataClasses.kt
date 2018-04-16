package ventegocreative.co.nz.sot.model.data

data class Petfinder(val pets: Pets)
data class Pets(val pet: List<Pet>)
data class Pet(val age: String, val size: String, val contact: Contact, val id: Int, val breeds: Breeds, val name: String, val sex: String, val animal: String)
data class Breeds(val breedList: List<Breed>)
data class Breed(val breedName: String)
data class Contact(val state: String, val city: String, val zip: Int)
