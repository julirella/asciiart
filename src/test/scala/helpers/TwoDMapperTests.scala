package helpers

import org.scalatest.FunSuite
class TwoDMapperTests extends FunSuite {

  test("Mapping an empty 2D list should result in an empty 2D list") {
    val mapper = new TwoDMapper
    val inputList = List.empty[List[Int]]
    val result = mapper.map2D(inputList, (x: Int) => x * 2)
    val expected = List.empty[List[Int]]
    assert(result == expected)
  }

  test("Mapping a 2D list of integers should apply the function to each element") {
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

  test("Mapping a 2D list of strings should apply the function to each element") {
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

  test("Mapping a 2D list with a function that changes element types") {
    val mapper = new TwoDMapper
    val inputList = List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9)
    )
    val result = mapper.map2D(inputList, (x: Int) => (x * 2).toString)
    val expected = List(
      List("2", "4", "6"),
      List("8", "10", "12"),
      List("14", "16", "18")
    )
    assert(result == expected)
  }

  test("Mapping a 2D list with a function that changes element types to a different type") {
    val mapper = new TwoDMapper
    val inputList = List(
      List("a", "b", "c"),
      List("d", "e", "f"),
      List("g", "h", "i")
    )
    val result = mapper.map2D(inputList, (s: String) => s.length)
    val expected = List(
      List(1, 1, 1),
      List(1, 1, 1),
      List(1, 1, 1)
    )
    assert(result == expected)
  }
}

