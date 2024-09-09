package org.example

class Fraction(numerator: Int, denominator: Int, sign: Int = 1) : Comparable<Fraction> {

    private val numerator: Int
    private val denominator: Int
    private val sign: Int

    init {
        require(denominator != 0) { "Denominator cannot be zero" }
        val gcd = gcd(numerator, denominator)
        this.numerator = kotlin.math.abs(numerator) / gcd
        this.denominator = kotlin.math.abs(denominator) / gcd
        this.sign = if (numerator * denominator < 0) -1 else 1 * sign
    }

    private val normalizedNumerator: Int
        get() = sign * numerator

    private val normalizedDenominator: Int
        get() = denominator

    override fun toString(): String {
        return "${normalizedNumerator}/${normalizedDenominator}"
    }

    operator fun unaryMinus(): Fraction {
        return Fraction(numerator, denominator, -sign)
    }

    operator fun plus(other: Fraction): Fraction {
        val commonDenominator = denominator * other.denominator
        val newNumerator = normalizedNumerator * other.denominator + other.normalizedNumerator * denominator
        return Fraction(newNumerator, commonDenominator)
    }

    operator fun minus(other: Fraction): Fraction {
        return this + -other
    }

    operator fun times(other: Fraction): Fraction {
        return Fraction(normalizedNumerator * other.normalizedNumerator, normalizedDenominator * other.normalizedDenominator)
    }

    operator fun div(other: Fraction): Fraction {
        return Fraction(normalizedNumerator * other.normalizedDenominator, normalizedDenominator * other.normalizedNumerator)
    }

    override fun compareTo(other: Fraction): Int {
        val thisValue = normalizedNumerator.toDouble() / normalizedDenominator
        val otherValue = other.normalizedNumerator.toDouble() / other.normalizedDenominator
        return thisValue.compareTo(otherValue)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Fraction) return false
        return compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return normalizedNumerator.hashCode() * 31 + normalizedDenominator.hashCode()
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun add(other: Fraction): Fraction {
        return this + other
    }

    fun mult(other: Fraction): Fraction {
        return this * other
    }

    fun negate(): Fraction {
        return -this
    }
}