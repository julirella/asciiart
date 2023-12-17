package helpers

import org.scalatest.FunSuite

class TwoDCompareTests extends FunSuite{
  test("empty") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array.empty
    val right: Array[Array[Int]] = Array.empty
    assert(comparer.cmp2DArray(left, right))
  }

  test("same shape, same elements") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    assert(comparer.cmp2DArray(left, right))
  }

  test("different row amount") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6)
    )
    assert(!comparer.cmp2DArray(left, right))
  }

  test("same shape, different elements") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 0, 6),
      Array(7, 8, 9)
    )
    assert(!comparer.cmp2DArray(left, right))
  }

  test("same number of rows, different row lengths") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9, 10)
    )
    assert(!comparer.cmp2DArray(left, right))
  }

  test("empty and non empty array"){
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array.empty
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 0, 6),
      Array(7, 8, 9)
    )
    assert(!comparer.cmp2DArray(left, right))
  }

  test("strings"){
    val comparer = new TwoDCompare
    val left: Array[Array[String]] = Array(
      Array("1", "2", "3"),
      Array("4", "5", "6"),
      Array("7", "8", "9")
    )
    val right: Array[Array[String]] = Array(
      Array("1", "2", "3"),
      Array("4", "5", "6"),
      Array("7", "8", "9")
    )
    assert(comparer.cmp2DArray(left, right))
  }

  test("1x1 array") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1)
    )
    val right: Array[Array[Int]] = Array(
      Array(1)
    )
    assert(comparer.cmp2DArray(left, right))
  }
}
