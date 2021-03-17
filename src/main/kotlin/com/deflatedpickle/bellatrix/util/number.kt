/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.bellatrix.util

operator fun Number.plus(other: Number): Number =
    when (this) {
        is Int -> this.toInt() + other.toInt()
        is Float -> this.toFloat() + other.toFloat()
        is Long -> this.toLong() + other.toLong()
        is Short -> this.toShort() + other.toShort()
        is Byte -> this.toByte() + other.toByte()
        else -> throw RuntimeException("Unknown numeric type")
    }

operator fun Number.minus(other: Number): Number =
    when (this) {
        is Int -> this.toInt() - other.toInt()
        is Float -> this.toFloat() - other.toFloat()
        is Long -> this.toLong() - other.toLong()
        is Short -> this.toShort() - other.toShort()
        is Byte -> this.toByte() - other.toByte()
        else -> throw RuntimeException("Unknown numeric type")
    }

operator fun Number.times(other: Number): Number =
    when (this) {
        is Int -> this.toInt() * other.toInt()
        is Float -> this.toFloat() * other.toFloat()
        is Long -> this.toLong() * other.toLong()
        is Short -> this.toShort() * other.toShort()
        is Byte -> this.toByte() * other.toByte()
        else -> throw RuntimeException("Unknown numeric type")
    }

operator fun Number.div(other: Number): Number =
    when (this) {
        is Int -> this.toInt() / other.toInt()
        is Float -> this.toFloat() / other.toFloat()
        is Long -> this.toLong() / other.toLong()
        is Short -> this.toShort() / other.toShort()
        is Byte -> this.toByte() / other.toByte()
        else -> throw RuntimeException("Unknown numeric type")
    }

operator fun Number.rem(other: Number): Number =
    when (this) {
        is Int -> this.toInt() % other.toInt()
        is Float -> this.toFloat() % other.toFloat()
        is Long -> this.toLong() % other.toLong()
        is Short -> this.toShort() % other.toShort()
        is Byte -> this.toByte() % other.toByte()
        else -> throw RuntimeException("Unknown numeric type")
    }
