/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("unused", "MemberVisibilityCanBePrivate", "UNCHECKED_CAST", "PropertyName",
    "UNNECESSARY_NOT_NULL_ASSERTION"
)

package com.deflatedpickle.bellatrix

/**
 * Creates a [Vector] from the variables in [elements]
 */
inline fun <reified T> vectorOf(vararg elements: T): Vector<T> = listToVector(elements.toList())

/**
 * Creates a [Vector] from the variables in [elements]
 */
inline fun <reified T> vecOf(vararg elements: T): Vector<T> = vectorOf(*elements)

typealias Vec0<T> = Vector0<T>

/**
 * Creates a [Vector] of [T] with zero elements
 */
class Vector0<T> : Vector<T>()

typealias Vec1<T> = Vector1<T>

/**
 * Creates a [Vector] of [T] with one element
 */
class Vector1<T>(
    one: T
) : Vector<T>(one) {
    operator fun component1(): T = this.elements[0]
}

typealias Vec2<T> = Vector2<T>

/**
 * Creates a [Vector] of [T] with two elements
 */
class Vector2<T>(
    one: T,
    two: T
) : Vector<T>(one, two) {
    operator fun component1(): T = this.elements[0]
    operator fun component2(): T = this.elements[1]
}

typealias Vec3<T> = Vector3<T>

/**
 * Creates a [Vector] of [T] with three elements
 */
class Vector3<T>(
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

/**
 * Creates a [Vector] of [T] with four elements
 */
class Vector4<T>(
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

/**
 * Creates a [Vector] of [T] with five elements
 */
class Vector5<T>(
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

/**
 * Creates a [Vector] of [T] with six elements
 */
class Vector6<T>(
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
open class Vector<T>(
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
                val first = this@Vector.elements[0]

                if (first != null) {
                    append("<${first!!::class.simpleName}>")
                } else {
                    append("<null>")
                }
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

    @PublishedApi
    internal val `access$elements`: List<T>
        get() = this.elements
}

/**
 * Returns a vector with the copies of [this]
 */
inline fun <reified T> Vector<T>.copy(): Vector<T> = Vector(*this.elements.toTypedArray())

/**
 * Copies the values of [this] to [other] and returns [this]
 */
inline fun <reified T> Vector<T>.copyTo(other: MutableVector<T>): Vector<T> = this.apply {
    other.clear()
    other.addAll(this.elements)
}

@PublishedApi
internal inline fun <reified T> listToVector(e: List<T>, mutable: Boolean = false): Vector<T> =
    if (mutable) MutableVector(*e.toTypedArray())
    else when (e.size) {
        0 -> Vector0()
        1 -> Vector1(e[0])
        2 -> Vector2(e[0], e[1])
        3 -> Vector3(e[0], e[1], e[2])
        4 -> Vector4(e[0], e[1], e[2], e[3])
        5 -> Vector5(e[0], e[1], e[2], e[3], e[4])
        6 -> Vector6(e[0], e[1], e[2], e[3], e[4], e[5])
        else -> Vector(*e.toTypedArray())
    }


/**
 * Creates a [MutableVector] from the values of this [Vector], or returns [this] if it's already a [MutableVector]
 */
inline fun <reified T> Vector<T>.toMutableVector(): MutableVector<T> =
    if (this is MutableVector<T>) this
    else MutableVector(*this.elements.toTypedArray())

/**
 * Creates a [MutableVector] from the values of this [Vector], or returns [this] if it's already a [MutableVector]
 */
inline fun <reified T : Number> Vector<T>.toMathVector(): MathVector<T> =
    if (this is MathVector<T>) this
    else MathVector(*this.elements.toTypedArray())

/**
 * Converts a [List] to a [Vector] of the same amount of values
 */
inline fun <reified T> List<T>.toVector(): Vector<T> = listToVector(this)

/**
 * Converts an [Array] to a [Vector] of the same amount of values
 */
inline fun <reified T> Array<T>.toVector(): Vector<T> = listToVector(this.toList())

/**
 * Converts a [Set] to a [Vector] of the same amount of values
 */
inline fun <reified T> Set<T>.toVector(): Vector<T> = listToVector(this.toList())

open class VectorException(message: String = "") : Exception(message)
class UnimplementedVectorException : VectorException(
    message = "The given size vector hasn't been implemented yet"
)
