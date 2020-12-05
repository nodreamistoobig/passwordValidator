import java.io.File
import kotlin.math.log2

class Validator (private val password: String) {

    private fun validLength():Boolean{
        if (password.length < 8 || password.length > 40){
            return false
        }
        return true
    }

    private fun upperLowerCase():Boolean{
        var lower: Boolean = false
        var upper: Boolean = false

        for (c: Char in password){
            if (c in 'a'..'z')
                lower = true
            else if (c in 'A'..'Z')
                upper = true

            if (lower && upper)
                return true
        }
        return false
    }

    private fun numbers():Boolean{
        for (c: Char in password){
            if (c in '0'..'9')
                return true
        }
        return false
    }

    private fun symbols():Boolean{
        for (c: Char in password){
            if (c in '!'..'/' || c in ':'..'@' || c in '['..'`' || c in '{'..'~')
                return true
        }
        return false
    }

    private fun noDictWords():Boolean{
        val dictionary = File("pswd-dict.txt")
        val words = ArrayList<String>()
        dictionary.readLines().forEach {
            words.add(it)
        }
        for (word in words)
            if (password.contains(word, ignoreCase = true))
                return false
        return true
    }

    private fun entropy():Boolean{
        var H = 0.0
        val frequency = HashMap<Char, Double>()

        for (c: Char in password){
            if (!frequency.containsKey(c)) {
                frequency.put(c, 1.0)
            }
            else{
                frequency.put(c, frequency.getValue(c) + 1.0)
            }
        }

        val dictSize = frequency.size

        for (f in frequency){
            f.setValue(f.value / dictSize)
            H += f.value * log2(f.value)
        }
        H = -H
        if (H > 1)
            return true
        return false
    }

    fun check():ArrayList<Boolean>{
        val errors = ArrayList<Boolean>()

        errors.add(validLength())
        errors.add(upperLowerCase())
        errors.add(numbers())
        errors.add(symbols())
        errors.add(noDictWords())
        errors.add(entropy())
        return errors
    }
}
