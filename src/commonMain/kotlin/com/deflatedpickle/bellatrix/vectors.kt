/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("unused", "MemberVisibilityCanBePrivate", "UNCHECKED_CAST", "PropertyName")

package com.deflatedpickle.bellatrix

import com.deflatedpickle.bellatrix.util.Operator
import com.deflatedpickle.bellatrix.util.div
import com.deflatedpickle.bellatrix.util.fma
import com.deflatedpickle.bellatrix.util.minus
import com.deflatedpickle.bellatrix.util.plus
import com.deflatedpickle.bellatrix.util.rem
import com.deflatedpickle.bellatrix.util.times
import com.deflatedpickle.bellatrix.util.to
import kotlin.jvm.JvmName
import kotlin.math.abs as ktabs
import com.deflatedpickle.bellatrix.util.Compare
import com.deflatedpickle.bellatrix.util.abs
import com.deflatedpickle.bellatrix.util.compareTo
import kotlin.math.max
import kotlin.math.sqrt
import kotlin.reflect.typeOf

/**
 * Creates a [Vector] from the variables in [elements]
 */
inline fun <reified T : Number> vectorOf(vararg elements: T): Vector<T> = listToVector(elements.toList())

/**
 * Creates a [Vector] from the variables in [elements]
 */
inline fun <reified T : Number> vecOf(vararg elements: T): Vector<T> = vectorOf(*elements)

/**
 * Creates a [MutableVector] from the variables in [elements]
 */
inline fun <reified T : Number> mutableVectorOf(vararg elements: T): MutableVector<T> =
    listToVector(elements.toList()).toMutableVector()

/**
 * Creates a [MutableVector] from the variables in [elements]
 */
inline fun <reified T : Number> mutVecOf(vararg elements: T): MutableVector<T> =
    vectorOf(*elements).toMutableVector()

/**
 * Creates a [Vector] locked to [Int] from the variables in [elements]
 */
fun intVectorOf(vararg elements: Int): Vector<Int> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Float] from the variables in [elements]
 */
fun floatVectorOf(vararg elements: Float): Vector<Float> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Double] from the variables in [elements]
 */
fun doubleVectorOf(vararg elements: Double): Vector<Double> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Long] from the variables in [elements]
 */
fun longVectorOf(vararg elements: Long): Vector<Long> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Short] from the variables in [elements]
 */
fun shortVectorOf(vararg elements: Short): Vector<Short> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Byte] from the variables in [elements]
 */
fun byteVectorOf(vararg elements: Byte): Vector<Byte> = listToVector(elements.toList())

/**
 * Creates a [Vector] locked to [Int] from the variables in [elements]
 */
fun intVecOf(vararg elements: Int): Vector<Int> = intVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Float] from the variables in [elements]
 */
fun floatVecOf(vararg elements: Float): Vector<Float> = floatVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Double] from the variables in [elements]
 */
fun doubleVecOf(vararg elements: Double): Vector<Double> = doubleVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Long] from the variables in [elements]
 */
fun longVecOf(vararg elements: Long): Vector<Long> = longVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Short] from the variables in [elements]
 */
fun shortVecOf(vararg elements: Short): Vector<Short> = shortVectorOf(*elements)

/**
 * Creates a [Vector] locked to [Byte] from the variables in [elements]
 */
fun byteVecOf(vararg elements: Byte): Vector<Byte> = byteVectorOf(*elements)

typealias Vec0<T> = Vector0<T>
typealias Vec0i = Vector0<Int>
typealias Vec0f = Vector0<Float>
typealias Vec0d = Vector0<Double>
typealias Vec0l = Vector0<Long>
typealias Vec0s = Vector0<Short>
typealias Vec0b = Vector0<Byte>

/**
 * Creates a [Vector] of [T] with zero elements
 */
class Vector0<T : Number> : Vector<T>()

typealias Vec1<T> = Vector1<T>
typealias Vec1i = Vector1<Int>
typealias Vec1f = Vector1<Float>
typealias Vec1d = Vector1<Double>
typealias Vec1l = Vector1<Long>
typealias Vec1s = Vector1<Short>
typealias Vec1b = Vector1<Byte>

/**
 * Creates a [Vector] of [T] with one element
 */
class Vector1<T : Number>(
    one: T
) : Vector<T>(one) {
    operator fun component1(): T = this.elements[0]
}

typealias Vec2<T> = Vector2<T>
typealias Vec2i = Vector2<Int>
typealias Vec2f = Vector2<Float>
typealias Vec2d = Vector2<Double>
typealias Vec2l = Vector2<Long>
typealias Vec2s = Vector2<Short>
typealias Vec2b = Vector2<Byte>

/**
 * Creates a [Vector] of [T] with two elements
 */
class Vector2<T : Number>(
    one: T,
    two: T
) : Vector<T>(one, two) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
}

typealias Vec3<T> = Vector3<T>
typealias Vec3i = Vector3<Int>
typealias Vec3f = Vector3<Float>
typealias Vec3d = Vector3<Double>
typealias Vec3l = Vector3<Long>
typealias Vec3s = Vector3<Short>
typealias Vec3b = Vector3<Byte>

/**
 * Creates a [Vector] of [T] with three elements
 */
class Vector3<T : Number>(
    one: T,
    two: T,
    three: T
) : Vector<T>(one, two, three) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]

    operator fun get(e1: Int, e2: Int): Vector2<T> =
        Vector2(elements[e1], elements[e2])
}

typealias Vec4<T> = Vector4<T>
typealias Vec4i = Vector4<Int>
typealias Vec4f = Vector4<Float>
typealias Vec4d = Vector4<Double>
typealias Vec4l = Vector4<Long>
typealias Vec4s = Vector4<Short>
typealias Vec4b = Vector4<Byte>

/**
 * Creates a [Vector] of [T] with four elements
 */
class Vector4<T : Number>(
    one: T,
    two: T,
    three: T,
    four: T
) : Vector<T>(one, two, three, four) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]
    operator fun component4(): T = this.elements[3]

    operator fun get(e1: Int, e2: Int): Vector2<T> =
        Vector2(elements[e1], elements[e2])

    operator fun get(e1: Int, e2: Int, e3: Int): Vector3<T> =
        Vector3(elements[e1], elements[e2], elements[e3])
}

typealias Vec5<T> = Vector5<T>
typealias Vec5i = Vector5<Int>
typealias Vec5f = Vector5<Float>
typealias Vec5d = Vector5<Double>
typealias Vec5l = Vector5<Long>
typealias Vec5s = Vector5<Short>
typealias Vec5b = Vector5<Byte>

/**
 * Creates a [Vector] of [T] with five elements
 */
class Vector5<T : Number>(
    one: T,
    two: T,
    three: T,
    four: T,
    five: T
) : Vector<T>(one, two, three, four, five) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]
    operator fun component4(): T = this.elements[3]
    operator fun component5(): T = this.elements[4]

    operator fun get(e1: Int, e2: Int): Vector2<T> =
        Vector2(elements[e1], elements[e2])

    operator fun get(e1: Int, e2: Int, e3: Int): Vector3<T> =
        Vector3(elements[e1], elements[e2], elements[e3])

    operator fun get(e1: Int, e2: Int, e3: Int, e4: Int): Vector4<T> =
        Vector4(elements[e1], elements[e2], elements[e3], elements[e4])
}

typealias Vec6<T> = Vector6<T>
typealias Vec6i = Vector6<Int>
typealias Vec6f = Vector6<Float>
typealias Vec6d = Vector6<Double>
typealias Vec6l = Vector6<Long>
typealias Vec6s = Vector6<Short>
typealias Vec6b = Vector6<Byte>

/**
 * Creates a [Vector] of [T] with six elements
 */
class Vector6<T : Number>(
    one: T,
    two: T,
    three: T,
    four: T,
    five: T,
    six: T
) : Vector<T>(one, two, three, four, five, six) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
    operator fun component3(): T = this.elements[2]
    operator fun component4(): T = this.elements[3]
    operator fun component5(): T = this.elements[4]
    operator fun component6(): T = this.elements[5]

    operator fun get(e1: Int, e2: Int): Vector2<T> =
        Vector2(elements[e1], elements[e2])

    operator fun get(e1: Int, e2: Int, e3: Int): Vector3<T> =
        Vector3(elements[e1], elements[e2], elements[e3])

    operator fun get(e1: Int, e2: Int, e3: Int, e4: Int): Vector4<T> =
        Vector4(elements[e1], elements[e2], elements[e3], elements[e4])

    operator fun get(e1: Int, e2: Int, e3: Int, e4: Int, e5: Int): Vector5<T> =
        Vector5(elements[e1], elements[e2], elements[e3], elements[e4], elements[e5])
}

/**
 * An immutable collection with unlimited elements of [T]
 */
open class Vector<T : Number>(
    vararg elements: T
) : Collection<T>, Comparable<Vector<*>> {
    @PublishedApi
    internal val elements = elements.toMutableList()

    override fun equals(other: Any?): Boolean {
        if (other !is Vector<*>) return false
        return this.compareTo(other) == 0
    }

    override fun toString(): String = StringBuilder()
        .append("${this::class.simpleName}")
        .apply {
            if (this@Vector.elements.isNotEmpty()) {
                append("<${this@Vector.elements[0]::class.simpleName}>")
            }
        }
        .append(" { ${this.elements.joinToString()} }")
        .toString()

    override fun hashCode(): Int = this.elements.hashCode()

    override val size: Int
        get() = this.elements.size

    override fun isEmpty(): Boolean = size == 0
    override fun contains(element: T): Boolean = this.elements.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = this.elements.containsAll(elements)
    override fun iterator(): Iterator<T> = this.elements.iterator()

    override fun compareTo(other: Vector<*>): Int = (this.elements == other.elements).compareTo(true)

    operator fun get(element: Int): T = this.elements[element]

    /**
     * Calculates the square root of [lengthSquared]
     */
    fun length(): Double = sqrt(this.lengthSquared().toDouble())

    /**
     * Calculates the squared sum of this vector
     */
    fun lengthSquared(): Long = this.elements.sumOf { (it * it).to<Long>() as Long }

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
        ktabs(this.elements.sumOf { abs(other[this.elements.indexOf(it)] - it).to<Long>() as Long })

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

    @PublishedApi
    internal inline fun <reified T : Number, reified K : Number> metaMath(other: Vector<K>, op: Operator): Vector<*> {
        val size = max(this.`access$elements`.size, other.`access$elements`.size)

        val array =
            Array(size) {
                (if (it > this.size - 1) 0.to<T>()
                else this.`access$elements`[it]) as T
            }
        return listToVector(array.zip(other.`access$elements`.toTypedArray().copyOf(size).map { it ?: 0 }
            .toList() as List<K>) { a: T, b: K ->
            when (op) {
                Operator.PLUS -> a + b
                Operator.MINUS -> a - b
                Operator.TIMES -> a * b
                Operator.DIV -> a / b
                Operator.REM -> a % b
            }
        })
    }

    @JvmName("plusInt")
    inline operator fun <reified M : Number> plus(other: Vector<Int>): Vector<Int> =
        metaMath<M, Int>(other, Operator.PLUS) as Vector<Int>

    @JvmName("plusFloat")
    inline operator fun <reified M : Number> plus(other: Vector<Float>): Vector<Float> =
        metaMath<M, Float>(other, Operator.PLUS) as Vector<Float>

    @JvmName("plusDouble")
    inline operator fun <reified M : Number> plus(other: Vector<Double>): Vector<Double> =
        metaMath<M, Double>(other, Operator.PLUS) as Vector<Double>

    @JvmName("plusLong")
    inline operator fun <reified M : Number> plus(other: Vector<Long>): Vector<Long> =
        metaMath<M, Long>(other, Operator.PLUS) as Vector<Long>

    @JvmName("plusByte")
    inline operator fun <reified M : Number> plus(other: Vector<Byte>): Vector<Byte> =
        metaMath<M, Byte>(other, Operator.PLUS) as Vector<Byte>

    @JvmName("plusShort")
    inline operator fun <reified M : Number> plus(other: Vector<Short>): Vector<Short> =
        metaMath<M, Short>(other, Operator.PLUS) as Vector<Short>

    @JvmName("minusInt")
    inline operator fun <reified M : Number> minus(other: Vector<Int>): Vector<Int> =
        metaMath<M, Int>(other, Operator.MINUS) as Vector<Int>

    @JvmName("minusFloat")
    inline operator fun <reified M : Number> minus(other: Vector<Float>): Vector<Float> =
        metaMath<M, Float>(other, Operator.MINUS) as Vector<Float>

    @JvmName("minusDouble")
    inline operator fun <reified M : Number> minus(other: Vector<Double>): Vector<Double> =
        metaMath<M, Double>(other, Operator.MINUS) as Vector<Double>

    @JvmName("minusLong")
    inline operator fun <reified M : Number> minus(other: Vector<Long>): Vector<Long> =
        metaMath<M, Long>(other, Operator.MINUS) as Vector<Long>

    @JvmName("minusByte")
    inline operator fun <reified M : Number> minus(other: Vector<Byte>): Vector<Byte> =
        metaMath<M, Byte>(other, Operator.MINUS) as Vector<Byte>

    @JvmName("minusShort")
    inline operator fun <reified M : Number> minus(other: Vector<Short>): Vector<Short> =
        metaMath<M, Short>(other, Operator.MINUS) as Vector<Short>

    @JvmName("timesInt")
    inline operator fun <reified M : Number> times(other: Vector<Int>): Vector<Int> =
        metaMath<M, Int>(other, Operator.TIMES) as Vector<Int>

    @JvmName("timesFloat")
    inline operator fun <reified M : Number> times(other: Vector<Float>): Vector<Float> =
        metaMath<M, Float>(other, Operator.TIMES) as Vector<Float>

    @JvmName("timesDouble")
    inline operator fun <reified M : Number> times(other: Vector<Double>): Vector<Double> =
        metaMath<M, Double>(other, Operator.TIMES) as Vector<Double>

    @JvmName("timesLong")
    inline operator fun <reified M : Number> times(other: Vector<Long>): Vector<Long> =
        metaMath<M, Long>(other, Operator.TIMES) as Vector<Long>

    @JvmName("timesByte")
    inline operator fun <reified M : Number> times(other: Vector<Byte>): Vector<Byte> =
        metaMath<M, Byte>(other, Operator.TIMES) as Vector<Byte>

    @JvmName("timesShort")
    inline operator fun <reified M : Number> times(other: Vector<Short>): Vector<Short> =
        metaMath<M, Short>(other, Operator.TIMES) as Vector<Short>

    @JvmName("divInt")
    inline operator fun <reified M : Number> div(other: Vector<Int>): Vector<Int> =
        metaMath<M, Int>(other, Operator.DIV) as Vector<Int>

    @JvmName("divFloat")
    inline operator fun <reified M : Number> div(other: Vector<Float>): Vector<Float> =
        metaMath<M, Float>(other, Operator.DIV) as Vector<Float>

    @JvmName("divDouble")
    inline operator fun <reified M : Number> div(other: Vector<Double>): Vector<Double> =
        metaMath<M, Double>(other, Operator.DIV) as Vector<Double>

    @JvmName("divLong")
    inline operator fun <reified M : Number> div(other: Vector<Long>): Vector<Long> =
        metaMath<M, Long>(other, Operator.DIV) as Vector<Long>

    @JvmName("divByte")
    inline operator fun <reified M : Number> div(other: Vector<Byte>): Vector<Byte> =
        metaMath<M, Byte>(other, Operator.DIV) as Vector<Byte>

    @JvmName("divShort")
    inline operator fun <reified M : Number> div(other: Vector<Short>): Vector<Short> =
        metaMath<M, Short>(other, Operator.DIV) as Vector<Short>

    @JvmName("remInt")
    inline operator fun <reified M : Number> rem(other: Vector<Int>): Vector<Int> =
        metaMath<M, Int>(other, Operator.REM) as Vector<Int>

    @JvmName("remFloat")
    inline operator fun <reified M : Number> rem(other: Vector<Float>): Vector<Float> =
        metaMath<M, Float>(other, Operator.REM) as Vector<Float>

    @JvmName("remDouble")
    inline operator fun <reified M : Number> rem(other: Vector<Double>): Vector<Double> =
        metaMath<M, Double>(other, Operator.REM) as Vector<Double>

    @JvmName("remLong")
    inline operator fun <reified M : Number> rem(other: Vector<Long>): Vector<Long> =
        metaMath<M, Long>(other, Operator.REM) as Vector<Long>

    @JvmName("remByte")
    inline operator fun <reified M : Number> rem(other: Vector<Byte>): Vector<Byte> =
        metaMath<M, Byte>(other, Operator.REM) as Vector<Byte>

    @JvmName("remShort")
    inline operator fun <reified M : Number> rem(other: Vector<Short>): Vector<Short> =
        metaMath<M, Short>(other, Operator.REM) as Vector<Short>

    @PublishedApi
    internal val `access$elements`: List<T>
        get() = this.elements
}

/**
 * Returns a vector with the copies of [this]
 */
inline fun <reified T : Number> Vector<T>.copy(): Vector<T> = MutableVector(*this.elements.toTypedArray()).toVector()

/**
 * Copies the values of [this] to [other] and returns [this]
 */
inline fun <reified T : Number> Vector<T>.copyTo(other: MutableVector<T>): Vector<T> = this.apply {
    other.clear()
    other.addAll(this.elements)
}

@PublishedApi
internal inline fun <reified T : Number, reified K : Number> MutableVector<T>.compare(
    other: Vector<K>,
    compare: Compare
): Vector<T> {
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
 * An mutable collection with unlimited elements of [T]
 */
open class MutableVector<T : Number>(
    vararg elements: T
) : Vector<T>(*elements), MutableCollection<T> {
    override fun add(element: T): Boolean = this.elements.add(element)
    override fun addAll(elements: Collection<T>): Boolean = this.elements.addAll(elements)
    override fun clear() = this.elements.clear()
    override fun iterator(): MutableIterator<T> = this.elements.iterator()
    override fun remove(element: T): Boolean = this.elements.remove(element)
    override fun removeAll(elements: Collection<T>): Boolean = this.elements.removeAll(elements)
    override fun retainAll(elements: Collection<T>): Boolean = this.elements.retainAll(elements)

    operator fun set(index: Int, element: T): T = this.elements[index].apply {
        this@MutableVector.elements[index] = element
    }
}

/**
 * Sets the values of [this] to the minimum values of either [this] or [other]
 */
@Throws(IllegalArgumentException::class)
inline fun <reified T : Number, reified K : Number> MutableVector<T>.min(other: Vector<K>) =
    compare(other, Compare.MIN)

/**
 * Sets the values of [this] to the maximum values of either [this] or [other]
 */
@Throws(IllegalArgumentException::class)
inline fun <reified T : Number, reified K : Number> MutableVector<T>.max(other: Vector<K>) =
    compare(other, Compare.MAX)

/**
 * Sets the values of [this] to it's absolute value
 */
inline fun <reified T : Number> MutableVector<T>.absolute(): Vector<T> {
    for ((i, e) in this.elements.withIndex()) {
        this[i] = abs(e).to<T>() as T
    }

    return this
}

/**
 * Sets the values of [this] to zero
 */
inline fun <reified T : Number> MutableVector<T>.zero(): MutableVector<T> =
    this.apply { for (i in 0 until this.size) this[i] = (0.to<T>() as T) }

/**
 * Sets the values of [this] to it's negative value
 */
inline fun <reified T : Number> MutableVector<T>.negate(): MutableVector<T> =
    this.apply { for (i in 0 until this.size) this[i] = (this[i] * -1) as T }

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

@Throws(UnimplementedVectorException::class)
@PublishedApi
internal inline fun <reified T : Number> listToVector(e: List<T>, mutable: Boolean = false): Vector<T> =
    if (mutable) MutableVector(*e.toTypedArray())
    else when (e.size) {
        0 -> Vector0()
        1 -> Vector1(e[0])
        2 -> Vector2(e[0], e[1])
        3 -> Vector3(e[0], e[1], e[2])
        4 -> Vector4(e[0], e[1], e[2], e[3])
        5 -> Vector5(e[0], e[1], e[2], e[3], e[4])
        6 -> Vector6(e[0], e[1], e[2], e[3], e[4], e[5])
        else -> throw UnimplementedVectorException()
    }


/**
 * Creates a [MutableVector] from the values of this [Vector], or returns [this] if it's already a [MutableVector]
 */
inline fun <reified T : Number> Vector<T>.toMutableVector(): MutableVector<T> =
    if (this is MutableVector<T>) this
    else MutableVector(*this.elements.toTypedArray())

/**
 * Creates a [Vector] from the values of this [MutableVector]
 */
inline fun <reified T : Number> MutableVector<T>.toVector(): Vector<T> =
    when (this.size) {
        0 -> Vector0()
        1 -> Vector1(this.elements[0])
        2 -> Vector2(this.elements[0], this.elements[1])
        3 -> Vector3(this.elements[0], this.elements[1], this.elements[2])
        4 -> Vector4(this.elements[0], this.elements[1], this.elements[2], this.elements[3])
        5 -> Vector5(this.elements[0], this.elements[1], this.elements[2], this.elements[3], this.elements[4])
        6 -> Vector6(
            this.elements[0],
            this.elements[1],
            this.elements[2],
            this.elements[3],
            this.elements[4],
            this.elements[5]
        )
        else -> Vector(*this.elements.toTypedArray())
    }

/**
 * Converts a [List] to a [Vector] of the same amount of values
 */
inline fun <reified T : Number> List<T>.toVector(): Vector<T> = listToVector(this)

/**
 * Converts an [Array] to a [Vector] of the same amount of values
 */
inline fun <reified T : Number> Array<T>.toVector(): Vector<T> = listToVector(this.toList())

/**
 * Converts a [Set] to a [Vector] of the same amount of values
 */
inline fun <reified T : Number> Set<T>.toVector(): Vector<T> = listToVector(this.toList())

/**
 * Converts a [List] to a [MutableVector] of the same amount of values
 */
inline fun <reified T : Number> List<T>.toMutableVector(): MutableVector<T> = listToVector(this, true) as MutableVector<T>

/**
 * Converts an [Array] to a [MutableVector] of the same amount of values
 */
inline fun <reified T : Number> Array<T>.toMutableVector(): MutableVector<T> = listToVector(this.toList(), true) as MutableVector<T>

/**
 * Converts a [Set] to a [MutableVector] of the same amount of values
 */
inline fun <reified T : Number> Set<T>.toMutableVector(): MutableVector<T> = listToVector(this.toList(), true) as MutableVector<T>

open class VectorException(message: String = "") : Exception(message)
class UnimplementedVectorException : VectorException(
    message = "The given size vector hasn't been implemented yet"
)
