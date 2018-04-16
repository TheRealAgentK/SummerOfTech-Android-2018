package ventegocreative.co.nz.sot.commands

import ventegocreative.co.nz.sot.model.api.PetfinderRequest
import ventegocreative.co.nz.sot.model.domain.PetList
import ventegocreative.co.nz.sot.model.mappers.PetDataDomainMapper

class PetFindCommand(val zipCode: String, val animal: String): Command<PetList> {

    override fun execute(): PetList {
        return PetDataDomainMapper().getFromData(PetfinderRequest(zipCode,animal).send())
    }
}
