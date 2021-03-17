/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("unused", "MemberVisibilityCanBePrivate", "UNCHECKED_CAST")

package com.deflatedpickle.bellatrix

import com.deflatedpickle.bellatrix.util.div
import com.deflatedpickle.bellatrix.util.minus
import com.deflatedpickle.bellatrix.util.plus
import com.deflatedpickle.bellatrix.util.rem
import com.deflatedpickle.bellatrix.util.times
import kotlin.math.min
import kotlin.reflect.typeOf

fun <T : Number> vectorOf(vararg elements: T): Vector<T> = listToVector(elements.toList())
fun <T : Number> vecOf(vararg elements: T): Vector<T> = vectorOf(*elements)

fun intVectorOf(vararg elements: Int): Vector<Int> = listToVector(elements.toList())
fun floatVectorOf(vararg elements: Float): Vector<Float> = listToVector(elements.toList())
fun doubleVectorOf(vararg elements: Double): Vector<Double> = listToVector(elements.toList())
fun longVectorOf(vararg elements: Long): Vector<Long> = listToVector(elements.toList())
fun shortVectorOf(vararg elements: Short): Vector<Short> = listToVector(elements.toList())
fun byteVectorOf(vararg elements: Byte): Vector<Byte> = listToVector(elements.toList())

fun intVecOf(vararg elements: Int): Vector<Int> = intVectorOf(*elements)
fun floatVecOf(vararg elements: Float): Vector<Float> = floatVectorOf(*elements)
fun doubleVecOf(vararg elements: Double): Vector<Double> = doubleVectorOf(*elements)
fun longVecOf(vararg elements: Long): Vector<Long> = longVectorOf(*elements)
fun shortVecOf(vararg elements: Short): Vector<Short> = shortVectorOf(*elements)
fun byteVecOf(vararg elements: Byte): Vector<Byte> = byteVectorOf(*elements)

typealias Vec0<T> = Vector0<T>
typealias Vec0i = Vector0<Int>
typealias Vec0f = Vector0<Float>
typealias Vec0d = Vector0<Double>
typealias Vec0l = Vector0<Long>
typealias Vec0s = Vector0<Short>
typealias Vec0b = Vector0<Byte>

class Vector0<T : Number> : Vector<T>()

typealias Vec1<T> = Vector1<T>
typealias Vec1i = Vector1<Int>
typealias Vec1f = Vector1<Float>
typealias Vec1d = Vector1<Double>
typealias Vec1l = Vector1<Long>
typealias Vec1s = Vector1<Short>
typealias Vec1b = Vector1<Byte>

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

// TODO: Add a mutable vector
abstract class Vector<T : Number>(
    protected vararg val elements: T
) : Collection<T>, Comparable<Vector<*>> {
    override fun equals(other: Any?): Boolean {
        if (other !is Vector<*>) return false
        return this.compareTo(other) == 0
    }

    override fun toString(): String =
        "${this::class.simpleName}<${this.elements[0]::class.simpleName}> { ${this.elements.joinToString()} }"

    override fun hashCode(): Int {
        return elements.contentHashCode()
    }

    override val size: Int
        get() = elements.size

    override fun isEmpty(): Boolean = size == 0
    override fun contains(element: T): Boolean = elements.contains(element)
    override fun containsAll(elements: Collection<T>): Boolean = elements.containsAll(elements)
    override fun iterator(): Iterator<T> = elements.iterator()

    override fun compareTo(other: Vector<*>): Int = this.elements.contentEquals(other.elements).compareTo(true)
    operator fun get(element: Int): T = elements[element]

    inline fun <reified T : Number, reified K : Number> metaPlus(other: Vector<K>): Vector<*> {
        val size = min(this.`access$elements`.size, other.`access$elements`.size)

        val array = Array(size) { this.`access$elements`[it] as T }
        return listToVector(array.zip(other.`access$elements`.toList().toTypedArray()) { a: T, b: K -> a + b })
    }

    @JvmName("plusInt")
    inline operator fun <reified M : T> plus(other: Vector<Int>): Vector<Int> = metaPlus<M, Int>(other) as Vector<Int>

    @JvmName("plusFloat")
    inline operator fun <reified M : T> plus(other: Vector<Float>): Vector<Float> =
        metaPlus<M, Float>(other) as Vector<Float>

    @JvmName("plusDouble")
    inline operator fun <reified M : T> plus(other: Vector<Double>): Vector<Double> =
        metaPlus<M, Double>(other) as Vector<Double>

    @JvmName("plusLong")
    inline operator fun <reified M : T> plus(other: Vector<Long>): Vector<Long> =
        metaPlus<M, Long>(other) as Vector<Long>

    @JvmName("plusByte")
    inline operator fun <reified M : T> plus(other: Vector<Byte>): Vector<Byte> =
        metaPlus<M, Byte>(other) as Vector<Byte>

    @JvmName("plusShort")
    inline operator fun <reified M : T> plus(other: Vector<Short>): Vector<Short> =
        metaPlus<M, Short>(other) as Vector<Short>

    inline fun <reified T : Number, reified K : Number> metaMinus(other: Vector<K>): Vector<*> {
        val size = min(this.`access$elements`.size, other.`access$elements`.size)

        val array = Array(size) { this.`access$elements`[it] as T }
        return listToVector(array.zip(other.`access$elements`.toList().toTypedArray()) { a: T, b: K -> a - b })
    }

    @JvmName("minusInt")
    inline operator fun <reified M : T> minus(other: Vector<Int>): Vector<Int> = metaMinus<M, Int>(other) as Vector<Int>

    @JvmName("minusFloat")
    inline operator fun <reified M : T> minus(other: Vector<Float>): Vector<Float> =
        metaMinus<M, Float>(other) as Vector<Float>

    @JvmName("minusDouble")
    inline operator fun <reified M : T> minus(other: Vector<Double>): Vector<Double> =
        metaMinus<M, Double>(other) as Vector<Double>

    @JvmName("minusLong")
    inline operator fun <reified M : T> minus(other: Vector<Long>): Vector<Long> =
        metaMinus<M, Long>(other) as Vector<Long>

    @JvmName("minusByte")
    inline operator fun <reified M : T> minus(other: Vector<Byte>): Vector<Byte> =
        metaMinus<M, Byte>(other) as Vector<Byte>

    @JvmName("minusShort")
    inline operator fun <reified M : T> minus(other: Vector<Short>): Vector<Short> =
        metaMinus<M, Short>(other) as Vector<Short>

    inline fun <reified T : Number, reified K : Number> metaTimes(other: Vector<K>): Vector<*> {
        val size = min(this.`access$elements`.size, other.`access$elements`.size)

        val array = Array(size) { this.`access$elements`[it] as T }
        return listToVector(array.zip(other.`access$elements`.toList().toTypedArray()) { a: T, b: K -> a * b })
    }

    @JvmName("timesInt")
    inline operator fun <reified M : T> times(other: Vector<Int>): Vector<Int> = metaTimes<M, Int>(other) as Vector<Int>

    @JvmName("timesFloat")
    inline operator fun <reified M : T> times(other: Vector<Float>): Vector<Float> =
        metaTimes<M, Float>(other) as Vector<Float>

    @JvmName("timesDouble")
    inline operator fun <reified M : T> times(other: Vector<Double>): Vector<Double> =
        metaTimes<M, Double>(other) as Vector<Double>

    @JvmName("timesLong")
    inline operator fun <reified M : T> times(other: Vector<Long>): Vector<Long> =
        metaTimes<M, Long>(other) as Vector<Long>

    @JvmName("timesByte")
    inline operator fun <reified M : T> times(other: Vector<Byte>): Vector<Byte> =
        metaTimes<M, Byte>(other) as Vector<Byte>

    @JvmName("timesShort")
    inline operator fun <reified M : T> times(other: Vector<Short>): Vector<Short> =
        metaTimes<M, Short>(other) as Vector<Short>

    inline fun <reified T : Number, reified K : Number> metaDiv(other: Vector<K>): Vector<*> {
        val size = min(this.`access$elements`.size, other.`access$elements`.size)

        val array = Array(size) { this.`access$elements`[it] as T }
        return listToVector(array.zip(other.`access$elements`.toList().toTypedArray()) { a: T, b: K -> a / b })
    }

    @JvmName("divInt")
    inline operator fun <reified M : T> div(other: Vector<Int>): Vector<Int> = metaDiv<M, Int>(other) as Vector<Int>

    @JvmName("divFloat")
    inline operator fun <reified M : T> div(other: Vector<Float>): Vector<Float> =
        metaDiv<M, Float>(other) as Vector<Float>

    @JvmName("divDouble")
    inline operator fun <reified M : T> div(other: Vector<Double>): Vector<Double> =
        metaDiv<M, Double>(other) as Vector<Double>

    @JvmName("divLong")
    inline operator fun <reified M : T> div(other: Vector<Long>): Vector<Long> = metaDiv<M, Long>(other) as Vector<Long>

    @JvmName("divByte")
    inline operator fun <reified M : T> div(other: Vector<Byte>): Vector<Byte> = metaDiv<M, Byte>(other) as Vector<Byte>

    @JvmName("divShort")
    inline operator fun <reified M : T> div(other: Vector<Short>): Vector<Short> =
        metaDiv<M, Short>(other) as Vector<Short>

    inline fun <reified T : Number, reified K : Number> metaRem(other: Vector<K>): Vector<*> {
        val size = min(this.`access$elements`.size, other.`access$elements`.size)

        val array = Array(size) { this.`access$elements`[it] as T }
        return listToVector(array.zip(other.`access$elements`.toList().toTypedArray()) { a: T, b: K -> a % b })
    }

    @JvmName("remInt")
    inline operator fun <reified M : T> rem(other: Vector<Int>): Vector<Int> = metaRem<M, Int>(other) as Vector<Int>

    @JvmName("remFloat")
    inline operator fun <reified M : T> rem(other: Vector<Float>): Vector<Float> =
        metaRem<M, Float>(other) as Vector<Float>

    @JvmName("remDouble")
    inline operator fun <reified M : T> rem(other: Vector<Double>): Vector<Double> =
        metaRem<M, Double>(other) as Vector<Double>

    @JvmName("remLong")
    inline operator fun <reified M : T> rem(other: Vector<Long>): Vector<Long> = metaRem<M, Long>(other) as Vector<Long>

    @JvmName("remByte")
    inline operator fun <reified M : T> rem(other: Vector<Byte>): Vector<Byte> = metaRem<M, Byte>(other) as Vector<Byte>

    @JvmName("remShort")
    inline operator fun <reified M : T> rem(other: Vector<Short>): Vector<Short> =
        metaRem<M, Short>(other) as Vector<Short>

    fun toArray(): Array<out T> = elements
    fun toList(): List<T> = elements.toList()
    fun toSet(): Set<T> = elements.toSet()

    @Suppress("PropertyName")
    @PublishedApi
    internal val `access$elements`: Array<out T>
        get() = elements
}

/**
 * Sums together the elements of a [Vector]
 */
// This only works when used as an extension function
@Suppress("UNCHECKED_CAST")
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

/**
 * Decides the correct vector for the given list of elements
 */
@PublishedApi
internal fun <T : Number> listToVector(e: List<T>): Vector<T> = when (e.size) {
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
 * Converts a [List] to a [Vector] of the same amount of values
 */
fun <T : Number> List<T>.toVector(): Vector<T> = listToVector(this)
fun <T : Number> Array<T>.toVector(): Vector<T> = listToVector(this.toList())
fun <T : Number> Set<T>.toVector(): Vector<T> = listToVector(this.toList())

open class VectorException(message: String = "") : Exception(message)
class UnimplementedVectorException : VectorException(
    message = "The given size vector hasn't been implemented yet"
)
