package by.matrosov.tasks.task14

data class Rational (val n: Long, val d: Long) {

    private fun rationalToStringConverter(n1: Long, d1: Long): String{

        if (d1 == 1L) return "$n1"

        var a = n1
        if (n1 < 0) a = -n1
        var b = d1

        if (a > b){

            for (i in 2..b){
                if (a % i == 0L && b % i == 0L){

                    a /= i
                    b /= i

                    return rationalToStringConverter(a, b)
                }
            }
            if (n < 0) return "-$a/$b"
            return "$a/$b"


        }else if(b > a){

            for (i in 2..a){
                if (a % i == 0L && b % i == 0L){

                    a /= i
                    b /= i

                    return rationalToStringConverter(a, b)
                }
            }
            if (n < 0) return "-$a/$b"
            return "$a/$b"
        }

        return "1"
    }

    operator fun plus(rational: Rational): Rational {
        val d = this.d * rational.d
        val n = d / this.d * this.n + d / rational.d * rational.n

        return Rational(n, d)
    }

    operator fun minus(rational: Rational): Rational {
        val d = this.d * rational.d
        val n = d / this.d * this.n - d / rational.d * rational.n

        return Rational(n, d)
    }

    operator fun times(rational: Rational): Rational {
        val d = this.d * rational.d
        val n = this.n * rational.n

        return Rational(n, d)
    }

    operator fun div(rational: Rational): Rational {
        val d = this.d * rational.n
        val n = this.n * rational.d

        return Rational(n, d)
    }

    operator fun unaryMinus(): Rational {
        val d = this.d
        val n = -this.n

        return Rational(n, d)
    }

    operator fun compareTo(rational: Rational): Int {
        if (this.d == rational.d){
            if (this.n < rational.n) return -1
            return 1
        }

        val a = this.n * rational.d
        val b = this.d * rational.n
        if (a < b) return -1
        return 1
    }

    operator fun rangeTo(rational: Rational): Pair<Rational, Rational> {
        return Pair(this, rational)
    }

    override fun toString(): String = rationalToStringConverter(n, d)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        if (this.toString() != other.toString()) return false

        return true
    }

}

operator fun Pair<Rational, Rational>.contains(rational: Rational): Boolean {
    if (rational > this.first && rational < this.second) return true
    return false
}

infix fun Number.divBy(i: Number): Rational {
    return Rational(this.toLong(), i.toLong())
}

fun String.toRational(): Rational {
    val r = this.split("/")
    return Rational(r[0].toLong(), r[1].toLong())
}

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}



