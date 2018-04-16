package ventegocreative.co.nz.sot

import ventegocreative.co.nz.sot.model.mappers.PetDataSexMapper
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class PetDataSexMapperSpekTest : Spek({

    describe("a pet's sex converter") {

        it("should return 'Male' when 'M' is being passed in") {
            val result = PetDataSexMapper.petSexShortFullMapper("M")
            assertEquals("Male", result)
        }

        it("should return 'Female' when 'F' is being passed in") {
            val result = PetDataSexMapper.petSexShortFullMapper("F")
            assertEquals("Female", result)
        }
    }
})
