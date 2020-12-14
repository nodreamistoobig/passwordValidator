import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class rulesTest{
    @Test
    fun check_length1() {
        assertEquals(true, validLength("helloWorld").execute())
    }

    @Test
    fun check_length2() {
        assertEquals(false, validLength("hello").execute())
    }

    @Test
    fun check_case1() {
        assertEquals(false, upperLowerCase("hello").execute())
    }

    @Test
    fun check_case2() {
        assertEquals(false, upperLowerCase("HELLO").execute())
    }

    @Test
    fun check_case3() {
        assertEquals(true, upperLowerCase("hElLo").execute())
    }

    @Test
    fun check_numbers1() {
        assertEquals(true, numbers("a21sdn").execute())
    }

    @Test
    fun check_numbers2() {
        assertEquals(false, numbers("asdn").execute())
    }

    @Test
    fun check_symbols1() {
        assertEquals(true, symbols("hrb~gd").execute())
    }

    @Test
    fun check_symbols2() {
        assertEquals(false, symbols("hrbgd").execute())
    }

    @Test
    fun check_dict1() {
        assertEquals(true, noDictWords("emsvaniro").execute())
    }

    @Test
    fun check_dict2() {
        assertEquals(false, noDictWords("caballo").execute())
    }

    @Test
    fun check_entropy1() {
        assertEquals(true, entropy("emsvaniro").execute())
    }

    @Test
    fun check_entropy2() {
        assertEquals(false, entropy("1122qqq").execute())
    }
}