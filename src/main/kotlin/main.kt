class ValidatorException(message:String):Exception(message)

fun main(){
    println("Введите пароль. Пароль должен содержать минимум 8-40 символов, в том числе цифры, строчные и заглавные латинские буквы, специальные символы.")
    val p = readLine().toString()
    val validator = Validator(p)
    val validation = validator.check()

    val errors = HashMap<String, Boolean>()

    errors.put("Длина пароля должна быть от 8 до 40 символов.", validation[0])
    errors.put("Пароль должен содержать строчные и заглавные латинские буквы.", validation[1])
    errors.put("Пароль должен содержать цифры.", validation[2])
    errors.put("Пароль должен содержать специальные символы.", validation[3])
    errors.put("Пароль не должен содержать словарные слова.", validation[4])
    errors.put("Пароль должен имень высокий уровень энтропии.", validation[5])

    var exceptions = ""
    for (error in errors){
        if (!error.value){
            exceptions += "${error.key} "
        }
    }
    if (exceptions != ""){
        throw ValidatorException("Нарушены следующие правила-> " + exceptions)
    }
}