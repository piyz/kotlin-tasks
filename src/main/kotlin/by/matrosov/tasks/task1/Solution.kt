package by.matrosov.tasks.task1
/*
Implement the function that checks whether a string is a valid identifier. A valid identifier is a non-empty string that
starts with a letter or underscore and consists of only letters, digits and underscores.
 */

fun isValidIdentifier(s: String): Boolean {

    if (s.isEmpty()) return false

    if (s[0].toInt() !in 97..122 &&
            s[0].toInt() !in 65..90 &&
                s[0].toInt() != 95) return false

    for (char in s.substring(1)){
        if (char.toInt() !in 97..122 &&
                char.toInt() !in 65..90 &&
                    char.toInt() !in 48..57 &&
                        char.toInt() != 95) return false
    }

    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}