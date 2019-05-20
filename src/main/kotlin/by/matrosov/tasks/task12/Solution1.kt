package by.matrosov.tasks.task12

// without NPE

open class C(val value: String) {
    init {
        value.length
    }
}

class D(value: String) : C(value)

fun main(args: Array<String>) {
    println(D("a").value)
}