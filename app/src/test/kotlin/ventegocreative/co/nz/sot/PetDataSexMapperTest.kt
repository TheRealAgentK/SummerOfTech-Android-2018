package ventegocreative.co.nz.sot

import ventegocreative.co.nz.sot.model.mappers.PetDataSexMapper
import org.junit.Assert
import org.junit.Test

class PetDataSexMapperTest {

    companion object {
        val MALE_IN = "M"
        val MALE_OUT = "Male"
        val FEMALE_IN = "F"
        val FEMALE_OUT = "Female"
    }

    @Test
    fun convertMtoMale() {

        val actual = PetDataSexMapper.petSexShortFullMapper(MALE_IN)
        val expected = MALE_OUT

        Assert.assertEquals("M should convert to Male", expected, actual)
    }

    @Test
    fun convertFtoFemale() {

        val actual = PetDataSexMapper.petSexShortFullMapper(FEMALE_IN)
        val expected = FEMALE_OUT

        Assert.assertEquals("F should convert to Female", expected, actual)
    }
}

