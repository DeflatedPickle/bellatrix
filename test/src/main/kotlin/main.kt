@file:Suppress("UNCHECKED_CAST")

import com.deflatedpickle.bellatrix.Vec2f
import com.deflatedpickle.bellatrix.Vec2i
import com.deflatedpickle.bellatrix.Vec3i
import com.deflatedpickle.bellatrix.sum

@ExperimentalStdlibApi
fun main() {
    val v = Vec2i(1, 2)
    println(v)
    val v2 = Vec3i(6, 5, 2)
    println(v2)
    println(v2[0])
    println(v2[0, 1])

    println(v2.sum())

    val vf = Vec2f(1f, 2f)
    val (r1, r2) = vf.plus<Float>(v) as Vec2f
    println("$r1, $r2")

    val (a1, a2) = v.plus<Int>(vf) as Vec2i
    println("$a1, $a2")

    println(v == v2)
    println(v == vf)
    println(Vec2i(1, 2) == Vec2i(1, 2))
    println(Vec2i(1, 2) == Vec2i(2, 1))
}