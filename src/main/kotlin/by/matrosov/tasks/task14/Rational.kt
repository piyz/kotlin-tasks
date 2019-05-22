package by.matrosov.tasks.task14

import java.math.BigInteger

data class Rational (val n: BigInteger, val d: BigInteger){
    operator fun plus(rational: Rational): Rational {
        val b = this.d * rational.d
        val a = b/this.d * this.n + b/rational.d * rational.n
        return Rational(a, b)
    }
    operator fun minus(rational: Rational): Rational {
        val b = this.d * rational.d
        val a = b/this.d * this.n - b/rational.d * rational.n
        return Rational(a, b)
    }
    operator fun times(rational: Rational): Rational {
        val b = this.d * rational.d
        val a = this.n * rational.n
        return Rational(a, b)
    }
    operator fun div(rational: Rational): Rational {
        val b = this.d * rational.n
        val a = this.n * rational.d
        return Rational(a, b)
    }
    operator fun unaryMinus(): Rational {
        val b = this.d
        val a = -this.n
        return Rational(a, b)
    }
    operator fun compareTo(rational: Rational): Int {
        if (this.d == rational.d){
            if (this.n < rational.n) return -1
            return 1
        }

        val a = this.n * rational.d
        val b = rational.n * this.d
        if (a < b) return -1
        return 1
    }
    operator fun rangeTo(rational: Rational): Pair<Rational, Rational> {
        return Pair(this, rational)
    }
    private fun rationalToStringConverter(a: BigInteger, b: BigInteger): String{
        if (b == 1.toBigInteger()) return a.toString()

        val gcd = a.gcd(b)
        return (a/gcd).toString() + "/" + (b/gcd).toString()
    }
    override fun toString(): String = rationalToStringConverter(n, d)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        if (this.toString() != other.toString()) return false
        return true
    }
}

private infix fun Number.divBy(i: Number): Rational {

    fun Long.toBigInteger(): BigInteger = BigInteger.valueOf(this)
    fun Int.toBigInteger(): BigInteger = BigInteger.valueOf(toLong())

    when (i) {
        is Int -> return Rational(this.toInt().toBigInteger(), i.toBigInteger())
        is Long -> return Rational(this.toLong().toBigInteger(), i.toBigInteger())
    }

    return Rational(this as BigInteger, i as BigInteger)
}

private fun String.toRational(): Rational {
    val s = this.split("/")
    return Rational(s[0].toBigInteger(), s[1].toBigInteger())
}

private operator fun Pair<Rational, Rational>.contains(rational: Rational): Boolean {
    if (this.first < rational && rational < this.second) return true
    return false
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