package by.matrosov.tasks.task8

fun String.isNice(): Boolean {

    fun firstCondition(): Boolean {
        if (!this.contains("bu") &&
                !this.contains("ba") &&
                    !this.contains("be")) return true
        return false
    }

    fun secondCondition(): Boolean {
        if (this.filter
            { c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' }
                .count() >= 3) return true
        return false
    }

    fun thirdCondition(): Boolean {
        this.zipWithNext { a, b -> if (a == b) return true }
        return false
    }

    if (firstCondition() && secondCondition() ||
            firstCondition() && thirdCondition() ||
                secondCondition() && thirdCondition()) return true
    return false
}