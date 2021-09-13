@file:Suppress("MemberVisibilityCanBePrivate", "unused", "UNCHECKED_CAST")

package com.deflatedpickle.bellatrix

import com.deflatedpickle.bellatrix.util.*
import kotlin.jvm.JvmName
import kotlin.math.max
import kotlin.math.sqrt
import kotlin.reflect.typeOf

/**
 * Creates a [MathVector] from the variables in [elements]
 */
inline fun <reified T : Number> mathVectorOf(vararg elements: T): MathVector<T> = listToMathVector(elements.toList())

/**
 * Creates a [MathVector] from the variables in [elements]
 */
inline fun <reified T : Number> mathVecOf(vararg elements: T): MathVector<T> = mathVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Int] from the variables in [elements]
 */
fun intVectorOf(vararg elements: Int): MathVector<Int> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Float] from the variables in [elements]
 */
fun floatVectorOf(vararg elements: Float): MathVector<Float> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Double] from the variables in [elements]
 */
fun doubleVectorOf(vararg elements: Double): MathVector<Double> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Long] from the variables in [elements]
 */
fun longVectorOf(vararg elements: Long): MathVector<Long> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Short] from the variables in [elements]
 */
fun shortVectorOf(vararg elements: Short): MathVector<Short> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Byte] from the variables in [elements]
 */
fun byteVectorOf(vararg elements: Byte): MathVector<Byte> = listToVector(elements.toList()).toMathVector()

/**
 * Creates a [Vector] locked to [Int] from the variables in [elements]
 */
fun intVecOf(vararg elements: Int): MathVector<Int> = intVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Float] from the variables in [elements]
 */
fun floatVecOf(vararg elements: Float): MathVector<Float> = floatVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Double] from the variables in [elements]
 */
fun doubleVecOf(vararg elements: Double): MathVector<Double> = doubleVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Long] from the variables in [elements]
 */
fun longVecOf(vararg elements: Long): MathVector<Long> = longVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Short] from the variables in [elements]
 */
fun shortVecOf(vararg elements: Short): MathVector<Short> = shortVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Byte] from the variables in [elements]
 */
fun byteVecOf(vararg elements: Byte): MathVector<Byte> = byteVectorOf(*elements)

typealias Vec0i = MathVector0<Int>
typealias Vec0f = MathVector0<Float>
typealias Vec0d = MathVector0<Double>
typealias Vec0l = MathVector0<Long>
typealias Vec0s = MathVector0<Short>
typealias Vec0b = MathVector0<Byte>

/**
 * Creates a [MathVector] of [T] with zero elements
 */
open class MathVector0<T : Number> : MathVector<T>()

typealias Vec1i = MathVector1<Int>
typealias Vec1f = MathVector1<Float>
typealias Vec1d = MathVector1<Double>
typealias Vec1l = MathVector1<Long>
typealias Vec1s = MathVector1<Short>
typealias Vec1b = MathVector1<Byte>

/**
 * Creates a [MathVector] of [T] with one element
 */
class MathVector1<T : Number>(
    x: T
) : MathVector<T>(x) {
    var x: T
        get() = elements[0]
        set(value) {
            elements[0] = value
        }

    operator fun component1(): T = this.elements[0]
}

typealias Vec2i = MathVector2<Int>
typealias Vec2f = MathVector2<Float>
typealias Vec2d = MathVector2<Double>
typealias Vec2l = MathVector2<Long>
typealias Vec2s = MathVector2<Short>
typealias Vec2b = MathVector2<Byte>

/**
 * Creates a [MathVector] of [T] with two elements
 */
class MathVector2<T : Number>(
    x: T,
    y: T
) : MathVector<T>(x, y) {
    var x: T
        get() = elements[0]
        set(value) {
            elements[0] = value
        }

    var y: T
        get() = elements[1]
        set(value) {
            elements[1] = value
        }

    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
}

typealias Vec3i = MathVector3<Int>
typealias Vec3f = MathVector3<Float>
typealias Vec3d = MathVector3<Double>
typealias Vec3l = MathVector3<Long>
typealias Vec3s = MathVector3<Short>
typealias Vec3b = MathVector3<Byte>

/**
 * Creates a [MathVector] of [T] with three elements
 */
class MathVector3<T : Number>(
    x: T,
    y: T,
    z: T
) : MathVector<T>(x, y, z) {
    var x: T
        get() = elements[0]
        set(value) {
            elements[0] = value
        }

    var y: T
        get() = elements[1]
        set(value) {
            elements[1] = value
        }

    var z: T
        get() = elements[2]
        set(value) {
            elements[2] = value
        }

    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]

    operator fun get(e1: Int, e2: Int): MathVector2<T> =
        MathVector2(elements[e1], elements[e2])
}

typealias Vec4i = MathVector4<Int>
typealias Vec4f = MathVector4<Float>
typealias Vec4d = MathVector4<Double>
typealias Vec4l = MathVector4<Long>
typealias Vec4s = MathVector4<Short>
typealias Vec4b = MathVector4<Byte>

/**
 * Creates a [MathVector] of [T] with four elements
 */
class MathVector4<T : Number>(
    x: T,
    y: T,
    z: T,
    w: T
) : MathVector<T>(x, y, z, w) {
    var x: T
        get() = elements[0]
        set(value) {
            elements[0] = value
        }
    var y: T
        get() = elements[1]
        set(value) {
            elements[1] = value
        }
    var z: T
        get() = elements[2]
        set(value) {
            elements[2] = value
        }
    var w: T
        get() = elements[3]
        set(value) {
            elements[3] = value
        }

    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]
    operator fun component4(): T = this.elements[3]

    operator fun get(e1: Int, e2: Int): MathVector2<T> =
        MathVector2(elements[e1], elements[e2])

    operator fun get(e1: Int, e2: Int, e3: Int): MathVector3<T> =
        MathVector3(elements[e1], elements[e2], elements[e3])
}

open class MathVector<T : Number>(
    vararg elements: T
) : MutableVector<T>(*elements) {
    /**
     * Calculates the square root of [lengthSquared]
     */
    fun magnitude(): Double = sqrt(this.lengthSquared().toDouble())
    fun length() = magnitude()

    /**
     * Calculates the squared sum of this vector
     */
    fun magnitudeSquared(): Long = this.elements.sumOf { (it * it).to<Long>() as Long }
    fun lengthSquared() = magnitudeSquared()

    internal fun <M : Number> reduceBy(other: Vector<M>): List<Number> {
        if (this.size != other.size) throw IllegalArgumentException("")

        val tempElements = mutableListOf<Number>()

        for ((i, e) in this.elements.withIndex()) {
            tempElements.add(e - other[i])
        }

        return tempElements
    }

    /**
     * Calculates the distance between this vector and [other]
     */
    fun <M : Number> distance(other: Vector<M>): Double {
        val tempElements = this.reduceBy(other)

        val last = tempElements.last()
        var tempFMA = last * last

        for (i in tempElements.reversed().drop(1)) {
            tempFMA = fma(i, i, tempFMA)
        }

        return sqrt(tempFMA.to<Double>() as Double)
    }

    /**
     * Calculates the grid distance between this vector and [other]
     */
    fun <M : Number> gridDistance(other: Vector<M>): Long =
        kotlin.math.abs(this.elements.sumOf { abs(other[this.elements.indexOf(it)] - it).to<Long>() as Long })

    /**
     * Calculates the squared distance between this vector and [other]
     */
    fun <M : Number> distanceSquared(other: Vector<M>): Int =
        this.reduceBy(other).sumBy { (it + it).to<Int>() as Int }

    /**
     * Calculates the dot product between this vector and [other]
     */
    fun <M : Number> dot(other: Vector<M>): Int =
        this.sumBy { (it * other[this.elements.indexOf(it)]).to<Int>() as Int }

    operator fun unaryPlus(): MathVector<T> {
        for ((i, v) in this.withIndex()) {
            this[i] = (v * 1) as T
        }

        return this
    }

    operator fun unaryMinus(): MathVector<T> {
        for ((i, v) in this.withIndex()) {
            this[i] = (v * -1) as T
        }

        return this
    }

    inline fun <reified K : Number> metaMath(other: K, op: Operator): MathVector<K> {
        for ((i, v) in this.withIndex()) {
            when (op) {
                Operator.PLUS -> this[i] = (v + other) as T
                Operator.MINUS -> this[i] = (v - other) as T
                Operator.TIMES -> this[i] = (v * other) as T
                Operator.DIV -> this[i] = (v / other) as T
                Operator.REM -> this[i] = (v % other) as T
            }
        }

        return this as MathVector<K>
    }

    inline operator fun <reified K : Number> plus(other: K): MathVector<K> = metaMath(other, Operator.PLUS)
    inline operator fun <reified K : Number> minus(other: K): MathVector<K> = metaMath(other, Operator.MINUS)
    inline operator fun <reified K : Number> times(other: K): MathVector<K> = metaMath(other, Operator.TIMES)
    inline operator fun <reified K : Number> div(other: K): MathVector<K> = metaMath(other, Operator.DIV)
    inline operator fun <reified K : Number> rem(other: K): MathVector<K> = metaMath(other, Operator.REM)

    @PublishedApi
    internal inline fun <reified T : Number, reified K : Number> metaVectorMath(
        other: Vector<K>,
        op: Operator
    ): MathVector<K> {
        val size = max(this.`access$elements`.size, other.`access$elements`.size)

        val array =
            Array(size) {
                (if (it > this.size - 1) 0.to<T>()
                else this.`access$elements`[it]) as T
            }
        return listToMathVector(array.zip(other.`access$elements`.toTypedArray().copyOf(size).map { it ?: 0 }
            .toList() as List<K>) { a: T, b: K ->
            when (op) {
                Operator.PLUS -> a + b
                Operator.MINUS -> a - b
                Operator.TIMES -> a * b
                Operator.DIV -> a / b
                Operator.REM -> a % b
            }
        }) as MathVector<K>
    }

    inline operator fun <reified T : Number, reified K : Number> plus(other: Vector<K>): MathVector<K> =
        metaVectorMath<T, K>(other, Operator.PLUS)

    inline operator fun <reified T : Number, reified K : Number> minus(other: Vector<K>): MathVector<K> =
        metaVectorMath<T, K>(other, Operator.MINUS)

    inline operator fun <reified T : Number, reified K : Number> times(other: Vector<K>): MathVector<K> =
        metaVectorMath<T, K>(other, Operator.TIMES)

    inline operator fun <reified T : Number, reified K : Number> div(other: Vector<K>): MathVector<K> =
        metaVectorMath<T, K>(other, Operator.DIV)

    inline operator fun <reified T : Number, reified K : Number> rem(other: Vector<K>): MathVector<K> =
        metaVectorMath<T, K>(other, Operator.REM)
}

@PublishedApi
internal inline fun <reified T : Number, reified K : Number> MathVector<T>.compare(
    other: Vector<K>,
    compare: Compare
): MathVector<T> {
    if (this.size != other.size) throw IllegalArgumentException("")

    for ((i, e) in this.elements.withIndex()) {
        val o = other[i]

        this[i] = (when (compare) {
            Compare.MIN -> if (e < o) e else o.to<T>()
            Compare.MAX -> if (e > o) e else o.to<T>()
        }) as T
    }

    return this
}

/**
 * Sets the values of [this] to zero
 */
inline fun <reified T : Number> MathVector<T>.zero(): MathVector<T> =
    this.apply { for (i in 0 until this.size) this[i] = (0.to<T>() as T) }

/**
 * Sets the values of [this] to it's negative value
 */
inline fun <reified T : Number> MathVector<T>.negate(): MathVector<T> =
    this.apply { for (i in 0 until this.size) this[i] = (this[i] * -1) as T }

/**
 * Sets the values of [this] to the minimum values of either [this] or [other]
 */
@Throws(IllegalArgumentException::class)
inline fun <reified T : Number, reified K : Number> MathVector<T>.min(other: Vector<K>) =
    compare(other, Compare.MIN)

/**
 * Sets the values of [this] to the maximum values of either [this] or [other]
 */
@Throws(IllegalArgumentException::class)
inline fun <reified T : Number, reified K : Number> MathVector<T>.max(other: Vector<K>) =
    compare(other, Compare.MAX)

/**
 * Sets the values of [this] to its absolute value
 */
inline fun <reified T : Number> MathVector<T>.absolute(): MathVector<T> {
    for ((i, e) in this.elements.withIndex()) {
        this[i] = abs(e).to<T>() as T
    }

    return this
}

/**
 * Reflects a vector using a surface normal
 */
inline fun <reified T : Number, reified K : Number> MathVector<T>.reflect(other: MathVector<K>): MathVector<T> =
    (2 * (this.times<T, K>(other)).times<T, K>(other)).minus<K, T>(this)

/**
 * Normalizes the values of [this]
 */
inline fun <reified T : Number> MathVector<T>.normalize(): MathVector<T> {
    val len = this.length()

    for ((i, e) in this.elements.withIndex()) {
        this[i] = (e / len) as T
    }

    return this
}

/**
 * Sums together the elements of a [Vector]
 */
@Throws(UnimplementedVectorException::class)
@ExperimentalStdlibApi
inline fun <reified T : Number> Vector<T>.sum(): T =
    when (typeOf<T>().classifier) {
        Int::class -> (this.toList().toTypedArray() as Array<Int>).sum() as T
        Float::class -> (this.toList().toTypedArray() as Array<Float>).sum() as T
        Double::class -> (this.toList().toTypedArray() as Array<Double>).sum() as T
        Long::class -> (this.toList().toTypedArray() as Array<Long>).sum() as T
        Byte::class -> (this.toList().toTypedArray() as Array<Byte>).sum() as T
        Short::class -> (this.toList().toTypedArray() as Array<Short>).sum() as T
        else -> throw UnimplementedVectorException()
    }

@PublishedApi
internal inline fun <reified T : Number> listToMathVector(e: List<T>): MathVector<T> =
    when (e.size) {
        0 -> MathVector0()
        1 -> MathVector1(e[0])
        2 -> MathVector2(e[0], e[1])
        3 -> MathVector3(e[0], e[1], e[2])
        4 -> MathVector4(e[0], e[1], e[2], e[3])
        else -> MathVector(*e.toTypedArray())
    }

inline operator fun <reified T : Number> Int.times(other: MathVector<T>): MathVector<T> = other.also { it * this }