package helpers

import org.scalatest.FunSuite

class TwoDCompareTests extends FunSuite{
  test("Comparing two empty 2D arrays should return true") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array.empty
    val right: Array[Array[Int]] = Array.empty
    assert(comparer.cmp2DArray(left, right))
  }

  test("Comparing two equal non-empty 2D arrays should return true") {
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

  test("Comparing two non-equal 2D arrays with different lengths should return false") {
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

  test("Comparing two non-equal 2D arrays with different elements should return false") {
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

  test("Comparing two arrays with the same length but different inner arrays should return false") {
    val comparer = new TwoDCompare
    val left: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val right: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9, 10) // Different length inner array
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
}
