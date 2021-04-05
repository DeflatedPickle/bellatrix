/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("SpellCheckingInspection")

package com.deflatedpickle.bellatrix.util

import kotlin.math.abs as ktabs

fun <T : Number> fma(x: T, y: T, z: T) = x * y + z

fun abs(that: Number): Number =
    when (that) {
        is Int -> ktabs(that)
        is Float -> ktabs(that)
        is Double -> ktabs(that)
        is Long -> ktabs(that)
        is Short -> ktabs(that.toInt())
        is Byte -> ktabs(that.toInt())
        else -> throw RuntimeException(note)
    }

