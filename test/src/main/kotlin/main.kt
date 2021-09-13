@file:Suppress("UNCHECKED_CAST", "TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")

import com.deflatedpickle.bellatrix.*
import com.deflatedpickle.bellatrix.absolute
import com.deflatedpickle.bellatrix.negate
import com.deflatedpickle.bellatrix.zero

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
    println(v2.sum())

    val vf = Vec2f(1f, 2f)
    // The generic for plus has to be given due to KT-10453,
    // But once it's resolved, hopefully just the plus sign will work
    val (r1, r2) = (vf.plus<Float, Int>(v)) as Vec2f
    println("$r1, $r2")
    println(v.containsAll(v))
    // println(v.containsAll(vf))
    // println(vf.containsAll(v))

    val (a1, a2) = v.plus<Int, Float>(vf) as Vec2i
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

    println(mathVecOf(5, 5, 6, 7, 8).plus<Int, Float>(mathVecOf(3f)))
    println(mathVecOf(3).apply { add(7) }.plus<Int, Float>(mathVecOf(5f, 5f, 6f, 7f, 8f)))

    println("${mathVecOf(-1, -5, 5)} -> ${-mathVecOf(-1, -5, 5)}")
    println("${mathVecOf(-1, -5, 5)} -> ${+mathVecOf(-1, -5, 5)}")

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
    println(mathVecOf(10, 8).zero())

    println("--- NEGATE ---")
    println(mathVecOf(10, 8).negate())

    println("--- MIN ---")
    println(mathVecOf(1, 2).min(Vec2i(1, 2)))
    println(mathVecOf(1, 2).min(Vec2i(2, 2)))
    println(mathVecOf(1, 2).min(Vec2i(2, 3)))

    println(mathVecOf(1, 2).min(Vec2f(1f, 2f)))
    println(mathVecOf(1, 2).min(Vec2f(2f, 2f)))
    println(mathVecOf(1, 2).min(Vec2f(2f, 3f)))

    println("--- MAX ---")
    println(mathVecOf(1, 2).max(Vec2i(1, 2)))
    println(mathVecOf(1, 2).max(Vec2i(2, 2)))
    println(mathVecOf(1, 2).max(Vec2i(2, 3)))

    println(mathVecOf(1, 2).max(Vec2f(1f, 2f)))
    println(mathVecOf(1, 2).max(Vec2f(2f, 2f)))
    println(mathVecOf(1, 2).max(Vec2f(2f, 3f)))

    println("--- ABSOLUTE ---")
    println(mathVecOf(-10, 8).absolute())

    println("--- COPY ---")
    val original = Vec2i(1, 2)
    val copy = original.copy()
    println("$original, $copy")

    println("--- COPY TO ---")
    val original2 = Vec2i(1, 2)
    val temp = mutVecOf<Int>()
    original2.copyTo(temp)
    println("$original2, $temp")

    println("--- MATH ---")
    println(mathVecOf(1, 2) + 2)
    println(mathVecOf(1, 2) + 4.0)
    println(mathVecOf(1.0, 2.0) + 4)

    println(mathVecOf(1, 2) * 2)

    println("--- REFLECT ---")
    // -1, 1
    println(Vec2i(1, 1).reflect(Vec2i(0, 1)))
    // 1, 1
    println(Vec2i(-1, 1).reflect(Vec2i(0, 1)))
    // -2, 1
    println(Vec2i(2, 1).reflect(Vec2i(0, 1)))
}