abstract class Rule(var name: String){
    open var password: String = ""
    open fun execute():Boolean{
        return false
    }
}