package org.example

fun main() {
    val a = Fraction(1, 2, -1)
    println(a)
    println(a + Fraction(1, 3))
    println(a * Fraction(5, 2, -1))
    println(a / Fraction(2, 1))
    println(-Fraction(1, 6) + Fraction(1, 2))
    println(Fraction(2, 3) * Fraction(3, 2))
    println(Fraction(1, 2) > Fraction(2, 3)) // Comparable interface function compareTo()
}