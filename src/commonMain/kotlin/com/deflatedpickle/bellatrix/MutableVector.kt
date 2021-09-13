@file:Suppress("unused")

package com.deflatedpickle.bellatrix

/**
 * Creates a [MutableVector] from the variables in [elements]
 */
inline fun <reified T> mutableVectorOf(vararg elements: T): MutableVector<T> =
    listToVector(elements.toList()).toMutableVector()

/**
 * Creates a [MutableVector] from the variables in [elements]
 */
inline fun <reified T> mutVecOf(vararg elements: T): MutableVector<T> =
    vectorOf(*elements).toMutableVector()

/**
 * An mutable collection with unlimited elements of [T]
 */
open class MutableVector<T>(
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
 * Creates a [Vector] from the values of this [MutableVector]
 */
inline fun <reified T> MutableVector<T>.toVector(): Vector<T> =
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
 * Converts a [List] to a [MutableVector] of the same amount of values
 */
inline fun <reified T> List<T>.toMutableVector(): MutableVector<T> = listToVector(this, true) as MutableVector<T>

/**
 * Converts an [Array] to a [MutableVector] of the same amount of values
 */
inline fun <reified T> Array<T>.toMutableVector(): MutableVector<T> =
    listToVector(this.toList(), true) as MutableVector<T>

/**
 * Converts a [Set] to a [MutableVector] of the same amount of values
 */
inline fun <reified T> Set<T>.toMutableVector(): MutableVector<T> =
    listToVector(this.toList(), true) as MutableVector<T>