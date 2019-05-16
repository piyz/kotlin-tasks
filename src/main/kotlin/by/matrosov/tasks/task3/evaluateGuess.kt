package by.matrosov.tasks.task3

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var mutableSecret = secret
    var mutableGuess = guess
    var right = 0
    var wrong = 0

    for (i in secret.indices){
        if (secret[i] == guess[i]){
            right++
            mutableSecret = mutableSecret.replaceRange(i,i + 1, "_")
            mutableGuess = mutableGuess.replaceRange(i,i + 1, "_")
        }
    }

    for (i in secret.indices){
        if (mutableGuess[i] != '_'){
            if (mutableSecret.contains(mutableGuess[i])){
                var j = 0
                while (mutableSecret[j] != mutableGuess[i]){
                    j++
                }
                mutableSecret = mutableSecret.replaceRange(j,j + 1, "_")
                wrong++
            }
        }

    }

    return Evaluation(right, wrong)
}