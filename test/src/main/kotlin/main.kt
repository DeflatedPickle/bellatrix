@file:Suppress("UNCHECKED_CAST", "TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")

import com.deflatedpickle.bellatrix.Vec2f
import com.deflatedpickle.bellatrix.Vec2i
import com.deflatedpickle.bellatrix.Vec3i
import com.deflatedpickle.bellatrix.Vec6i
import com.deflatedpickle.bellatrix.Vector
import com.deflatedpickle.bellatrix.absolute
import com.deflatedpickle.bellatrix.copy
import com.deflatedpickle.bellatrix.copyTo
import com.deflatedpickle.bellatrix.mutableVectorOf
import com.deflatedpickle.bellatrix.sum
import com.deflatedpickle.bellatrix.toMutableVector
import com.deflatedpickle.bellatrix.toVector
import com.deflatedpickle.bellatrix.vectorOf
import com.deflatedpickle.bellatrix.zero
import com.deflatedpickle.bellatrix.negate
import com.deflatedpickle.bellatrix.min
import com.deflatedpickle.bellatrix.max
import com.deflatedpickle.bellatrix.mutVecOf
import com.deflatedpickle.bellatrix.vecOf

@ExperimentalStdlibApi
fun main() {
    val v = Vec2i(1, 2)
    println(v)
    println(v.toList())
    println(v.toMutableList())
    println(v.toSet())
    println(v.toMutableSet())
    println(v.toTypedArray())
    println(v.toTypedArray().joinToString())
    val v2 = Vec3i(6, 5, 2)
    println(v2)
    println(v2[0])
    println(v2[0, 1])

    val v6 = Vec6i(1, 6, 3, 7, 8, 4)
    println(v6)
    println(v6[1, 5, 3])

    println(v2.sum())

    val vf = Vec2f(1f, 2f)
    // The generic for plus has to be given due to KT-10453,
    // But once it's resolved, hopefully just the plus sign will work
    val (r1, r2) = vf.plus<Float>(v) as Vec2f
    println("$r1, $r2")
    println(v.containsAll(v))
    println(v.containsAll(vf))
    println(vf.containsAll(v))

    val (a1, a2) = v.plus<Int>(vf) as Vec2i
    println("$a1, $a2")

    println(v == v2)
    println(v == vf)
    println(Vec2i(1, 2) == Vec2i(1, 2))
    println(Vec2i(1, 2) == Vec2i(2, 1))

    val mv = mutableVectorOf<Int>()
    println(mv)
    mv.add(5)
    println(mv)
    println(mv.toVector())
    println(mv.toVector().toMutableVector())

    println(vectorOf(5, 5, 6, 7, 8).plus<Int>(mutableVectorOf(3f).apply { add(7f) }))
    println(vectorOf(3).toMutableVector().apply { add(7) }.plus<Int>(mutableVectorOf(5f, 5f, 6f, 7f, 8f)))

    println("--- LENGTH ---")
    println(Vec2i(1, 2).length())
    println(Vec2i(1, 2).lengthSquared())

    println("--- DISTANCE ---")
    println(Vec2i(1, 2).distance(Vec2i(1, 2)))
    println(Vec2i(1, 2).distance(Vec2i(2, 2)))
    println(Vec2i(1, 2).distance(Vec2i(2, 3)))

    println(Vec2i(1, 2).distance(Vec2f(1f, 2f)))
    println(Vec2i(1, 2).distance(Vec2f(2f, 2f)))
    println(Vec2i(1, 2).distance(Vec2f(2f, 3f)))

    println("--- GRID DISTANCE ---")
    println(Vec2i(1, 2).gridDistance(Vec2i(1, 2)))
    println(Vec2i(1, 2).gridDistance(Vec2i(2, 2)))
    println(Vec2i(1, 2).gridDistance(Vec2i(2, 3)))

    println(Vec2i(1, 2).gridDistance(Vec2f(1f, 2f)))
    println(Vec2i(1, 2).gridDistance(Vec2f(2f, 2f)))
    println(Vec2i(1, 2).gridDistance(Vec2f(2f, 3f)))

    println("--- DISTANCE SQUARED ---")
    println(Vec2i(1, 2).distanceSquared(Vec2i(1, 2)))
    println(Vec2i(1, 2).distanceSquared(Vec2i(2, 2)))
    println(Vec2i(1, 2).distanceSquared(Vec2i(2, 3)))

    println(Vec2i(1, 2).distanceSquared(Vec2f(1f, 2f)))
    println(Vec2i(1, 2).distanceSquared(Vec2f(2f, 2f)))
    println(Vec2i(1, 2).distanceSquared(Vec2f(2f, 3f)))

    println("--- DOT ---")
    println(Vec2i(1, 2).dot(Vec2i(1, 2)))
    println(Vec2i(1, 2).dot(Vec2i(2, 2)))
    println(Vec2i(1, 2).dot(Vec2i(2, 3)))

    println(Vec2i(1, 2).dot(Vec2f(1f, 2f)))
    println(Vec2i(1, 2).dot(Vec2f(2f, 2f)))
    println(Vec2i(1, 2).dot(Vec2f(2f, 3f)))

    println("--- ZERO ---")
    println(mutableVectorOf(10, 8).zero())

    println("--- NEGATE ---")
    println(mutableVectorOf(10, 8).negate())

    println("--- MIN ---")
    println(mutVecOf(1, 2).min(Vec2i(1, 2)))
    println(mutVecOf(1, 2).min(Vec2i(2, 2)))
    println(mutVecOf(1, 2).min(Vec2i(2, 3)))

    println(mutVecOf(1, 2).min(Vec2f(1f, 2f)))
    println(mutVecOf(1, 2).min(Vec2f(2f, 2f)))
    println(mutVecOf(1, 2).min(Vec2f(2f, 3f)))

    println("--- MAX ---")
    println(mutVecOf(1, 2).max(Vec2i(1, 2)))
    println(mutVecOf(1, 2).max(Vec2i(2, 2)))
    println(mutVecOf(1, 2).max(Vec2i(2, 3)))

    println(mutVecOf(1, 2).max(Vec2f(1f, 2f)))
    println(mutVecOf(1, 2).max(Vec2f(2f, 2f)))
    println(mutVecOf(1, 2).max(Vec2f(2f, 3f)))

    println("--- ABSOLUTE ---")
    println(mutableVectorOf(-10, 8).absolute())

    println("--- COPY ---")
    val original = Vec2i(1, 2)
    val copy = original.copy()
    println("$original, $copy")

    println("--- COPY TO ---")
    val original2 = Vec2i(1, 2)
    val temp = mutVecOf<Int>()
    original2.copyTo(temp)
    println("$original2, $temp")
}