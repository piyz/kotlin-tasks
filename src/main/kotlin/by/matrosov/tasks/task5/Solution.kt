package by.matrosov.tasks.task5

// declare the s variable to make the first line print null
// and the second one throw an exception

fun main(){

    val s = "any string"

    println(s as? Int) //null
    println(s as Int?) //exception
}