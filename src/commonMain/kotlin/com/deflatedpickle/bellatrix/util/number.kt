/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.bellatrix.util

import kotlin.reflect.typeOf

@PublishedApi
internal const val note = "Unknown numeric type"

@Throws(RuntimeException::class)
operator fun Number.plus(other: Number): Number =
    when (this) {
        is Int -> this.toInt() + other.toInt()
        is Float -> this.toFloat() + other.toFloat()
        is Double -> this.toDouble() + other.toDouble()
        is Long -> this.toLong() + other.toLong()
        is Short -> this.toShort() + other.toShort()
        is Byte -> this.toByte() + other.toByte()
        else -> throw RuntimeException(note)
    }

@Throws(RuntimeException::class)
operator fun Number.minus(other: Number): Number =
    when (this) {
        is Int -> this.toInt() - other.toInt()
        is Float -> this.toFloat() - other.toFloat()
        is Double -> this.toDouble() - other.toDouble()
        is Long -> this.toLong() - other.toLong()
        is Short -> this.toShort() - other.toShort()
        is Byte -> this.toByte() - other.toByte()
        else -> throw RuntimeException(note)
    }

@Throws(RuntimeException::class)
operator fun Number.times(other: Number): Number =
    when (this) {
        is Int -> this.toInt() * other.toInt()
        is Float -> this.toFloat() * other.toFloat()
        is Double -> this.toDouble() * other.toDouble()
        is Long -> this.toLong() * other.toLong()
        is Short -> this.toShort() * other.toShort()
        is Byte -> this.toByte() * other.toByte()
        else -> throw RuntimeException(note)
    }

@Throws(RuntimeException::class)
operator fun Number.div(other: Number): Number =
    when (this) {
        is Int -> this.toInt() / other.toInt()
        is Float -> this.toFloat() / other.toFloat()
        is Double -> this.toDouble() / other.toDouble()
        is Long -> this.toLong() / other.toLong()
        is Short -> this.toShort() / other.toShort()
        is Byte -> this.toByte() / other.toByte()
        else -> throw RuntimeException(note)
    }

@Throws(RuntimeException::class)
operator fun Number.rem(other: Number): Number =
    when (this) {
        is Int -> this.toInt() % other.toInt()
        is Float -> this.toFloat() % other.toFloat()
        is Double -> this.toDouble() % other.toDouble()
        is Long -> this.toLong() % other.toLong()
        is Short -> this.toShort() % other.toShort()
        is Byte -> this.toByte() % other.toByte()
        else -> throw RuntimeException(note)
    }

operator fun <T : Number, K : Number> T.compareTo(other: K): Int =
    when (this) {
        is Int -> this.toInt().compareTo(other.toInt())
        is Float -> this.toFloat().compareTo(other.toFloat())
        is Double -> this.toDouble().compareTo(other.toDouble())
        is Long -> this.toLong().compareTo(other.toLong())
        is Short -> this.toShort().compareTo(other.toShort())
        is Byte -> this.toByte().compareTo(other.toByte())
        else -> throw RuntimeException(note)
    }

@PublishedApi
@OptIn(ExperimentalStdlibApi::class)
@Throws(RuntimeException::class)
internal inline fun <reified T : Number> Number.to() =
    when (typeOf<T>().classifier) {
        Int::class -> this.toInt()
        Float::class -> this.toFloat()
        Double::class -> this.toDouble()
        Long::class -> this.toLong()
        Short::class -> this.toShort()
        Byte::class -> this.toByte()
        else -> throw RuntimeException(note)
    }
