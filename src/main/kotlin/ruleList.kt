import java.io.File
import kotlin.math.log2

class validLength (override var password: String) : Rule("Длина пароля должна быть от 8 до 40 символов.") {
    override fun execute(): Boolean {
        if (password.length < 8 || password.length > 40){
            return false
        }
        return true
    }
}

class upperLowerCase (override var password: String) : Rule("Пароль должен содержать строчные и заглавные латинские буквы.") {
    override fun execute(): Boolean {
        var lower = false
        var upper = false

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
}

class numbers (override var password: String) : Rule("Пароль должен содержать цифры.") {
    override fun execute(): Boolean {
        for (c: Char in password){
            if (c in '0'..'9')
                return true
        }
        return false
    }
}

class symbols (override var password: String) : Rule("Пароль должен содержать специальные символы.") {
    override fun execute(): Boolean {
        for (c: Char in password){
            if (c in '!'..'/' || c in ':'..'@' || c in '['..'`' || c in '{'..'~')
                return true
        }
        return false
    }
}

class noDictWords (override var password: String) : Rule("Пароль не должен содержать словарные слова.") {
    override fun execute(): Boolean {
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
}

class entropy (override var password: String) : Rule("Пароль должен имень высокий уровень энтропии.") {
    override fun execute(): Boolean {
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
}