package by.matrosov.tasks.task8

fun String.isNice2(): Boolean {
    val noBadSubstrings = !contains("ba") && !contains("be") && !contains("bu")

    val hasThreeVowels = count{
        it == 'a' || it == 'e' || it == 'i' || it == 'o' || it == 'u'
    } >=3

    var hasDouble = false
    if (length > 1){
        var prevCh: Char? = null
        for (ch in this){
            if (ch == prevCh)
                hasDouble = true
            prevCh = ch
        }
    }

    var conditions = 0
    if (noBadSubstrings) conditions++
    if (hasThreeVowels) conditions++
    if (hasDouble) conditions++

    if (conditions >= 2) return true
    return false
}