import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.function.Executable

internal class ValidatorTest {

    @Test
    fun check1() {
        val str = "Liu1ga7n+"
        val v = Validator(str)
        assertEquals(arrayListOf(true,true,true,true,true,true), v.check())
    }

    @Test
    fun check2() {
        val str = "Answer-42"
        val v = Validator(str)
        assertEquals(arrayListOf(true,true,true,true,false,true), v.check())
    }

    @Test
    fun check3() {
        val str = "1234"
        val v = Validator(str)
        assertEquals(arrayListOf(false,false,true,false,false,true), v.check())
    }

    @Test
    fun check4() {
        val str = "dRum507"
        val v = Validator(str)
        assertEquals(arrayListOf(false,true,true,false,false,true), v.check())
    }

    //length, case, num, symbols, dict, entropy

    @Test
    fun check5() {
        val str = "hrGt4wc90"
        val v = Validator(str)
        assertEquals(arrayListOf(true,true,true,false,true,true), v.check())
    }


    @Test
    fun check6() {
        val str = "oh,darling"
        val v = Validator(str)
        assertEquals(arrayListOf(true,false,false,true,false,true), v.check())
    }

    @Test
    fun check7() {
        val str = "000000"
        val v = Validator(str)
        assertEquals(arrayListOf(false,false,true,false,false,false), v.check())
    }

}