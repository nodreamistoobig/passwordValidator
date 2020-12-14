class ValidatorException(message:String):Exception(message)

fun main(){
    println("Введите пароль. Пароль должен содержать минимум 8-40 символов, в том числе цифры, строчные и заглавные латинские буквы, специальные символы.")
    val p = readLine().toString()
    val validator = Validator(p)

    val errors = validator.check()

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