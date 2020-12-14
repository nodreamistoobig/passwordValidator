import java.io.File
import kotlin.math.log2

class Validator (private val password: String) {

    fun check():HashMap<String, Boolean>{
        val errors = HashMap<String, Boolean>()

        errors.put(validLength(password).name, validLength(password).execute())
        errors.put(upperLowerCase(password).name, upperLowerCase(password).execute())
        errors.put(numbers(password).name, numbers(password).execute())
        errors.put(symbols(password).name, symbols(password).execute())
        errors.put(noDictWords(password).name, noDictWords(password).execute())
        errors.put(entropy(password).name, entropy(password).execute())
        return errors
    }
}