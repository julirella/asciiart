package helpers

import org.scalatest.FunSuite
class TwoDMapperTests extends FunSuite {
  val arrayComparer = new TwoDCompare

  test("empty list") {
    val mapper = new TwoDMapper
    val inputList = List.empty[List[Int]]
    val result = mapper.map2D(inputList, (x: Int) => x * 2)
    val expected = List.empty[List[Int]]
    assert(result == expected)
  }

  test("integer list times 2") {
    val mapper = new TwoDMapper
    val inputList = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )
    val result = mapper.map2D(inputList, (x: Int) => x * 2)
    val expected = List(
      List(2, 4, 6),
      List(8, 10, 12),
      List(14, 16, 18)
    )
    assert(result == expected)
  }

  test("capitalise strings list") {
    val mapper = new TwoDMapper
    val inputList = List(
      List("a", "b", "c"),
      List("d", "e", "f"),
      List("g", "h", "i")
    )
    val result = mapper.map2D(inputList, (s: String) => s.toUpperCase)
    val expected = List(
      List("A", "B", "C"),
      List("D", "E", "F"),
      List("G", "H", "I")
    )
    assert(result == expected)
  }

  test("multiply and convert to string non square list") {
    val mapper = new TwoDMapper
    val inputList = List(
      List(1, 2, 3),
      List(4, 5, 6)
    )
    val result = mapper.map2D(inputList, (x: Int) => (x * 2).toString)
    val expected = List(
      List("2", "4", "6"),
      List("8", "10", "12")
    )
    assert(result == expected)
  }

  test("1x1 list") {
    val mapper = new TwoDMapper
    val inputList = List(
      List("a")
    )
    val result = mapper.map2D(inputList, (s: String) => s.length)
    val expected = List(
      List(1)
    )
    assert(result == expected)
  }

  test("empty array") {
    val mapper = new TwoDMapper
    val inputArray: Array[Array[Int]] = Array.empty
    val result = mapper.map2D(inputArray, (x: Int) => x * 2)
    val expected: Array[Array[Int]] = Array.empty
    assert(arrayComparer.cmp2DArray(result, expected))
  }

  test("integer array times two") {
    val mapper = new TwoDMapper
    val inputArray: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )
    val result = mapper.map2D(inputArray, (x: Int) => x * 2)
    val expected: Array[Array[Int]] = Array(
      Array(2, 4, 6),
      Array(8, 10, 12),
      Array(14, 16, 18)
    )
    assert(arrayComparer.cmp2DArray(result, expected))
  }

  test("capitalise strings array") {
    val mapper = new TwoDMapper
    val inputArray: Array[Array[String]] = Array(
      Array("a", "b", "c"),
      Array("d", "e", "f"),
      Array("g", "h", "i")
    )
    val result = mapper.map2D(inputArray, (s: String) => s.toUpperCase)
    val expected: Array[Array[String]] = Array(
      Array("A", "B", "C"),
      Array("D", "E", "F"),
      Array("G", "H", "I")
    )
    assert(arrayComparer.cmp2DArray(result, expected))

  }

  test("times 2 and convert to string non square array") {
    val mapper = new TwoDMapper
    val inputArray: Array[Array[Int]] = Array(
      Array(1, 2, 3),
      Array(4, 5, 6)
    )
    val result = mapper.map2D(inputArray, (x: Int) => (x * 2).toString)
    val expected: Array[Array[String]] = Array(
      Array("2", "4", "6"),
      Array("8", "10", "12")
    )
    assert(arrayComparer.cmp2DArray(result, expected))

  }

  test("1x1 array") {
    val mapper = new TwoDMapper
    val inputArray: Array[Array[String]] = Array(
      Array("a")
    )
    val result = mapper.map2D(inputArray, (s: String) => s.length)
    val expected: Array[Array[Int]] = Array(
      Array(1)
    )

    assert(arrayComparer.cmp2DArray(result, expected))

  }

}

