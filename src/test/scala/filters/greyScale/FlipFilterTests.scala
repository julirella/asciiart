//package filters.greyScale
//
//import org.scalatest.FunSuite
//
//class FlipFilterTests extends FunSuite{
//  def filtered(pixels : List[List[Int]], axis: Char): List[List[Int]] = new FlipFilter(axis).applyFilter(pixels)
//
//  test("xAxis"){
//    val pixels = List(List(0, 1, 2), List(3, 4, 5), List(6, 7, 8))
//    val axis = 'x'
//    val expectedList = List(List(6, 7, 8), List(3, 4, 5), List(0, 1, 2))
//    assert(filtered(pixels, axis) == expectedList)
//  }
//
//  test("yAxis") {
//    val pixels = List(List(0, 1, 2), List(3, 4, 5), List(6, 7, 8))
//    val axis = 'y'
//    val expectedList = List(List(2, 1, 0), List(5, 4, 3), List(8, 7, 6))
//    assert(filtered(pixels, axis) == expectedList)
//  }
//
////  test("wrongAxis") = ???
//}
