package filters.greyScale.oneToOne

import org.scalatest.FunSuite

class InversionFilterTests extends FunSuite{
//  def filtered(pixels : List[List[Int]]): List[List[Int]] = new InversionFilter().applyFilter(pixels)
def filtered(pixel : Int): Int = new InversionFilter().applyToOnePixel(pixel)

  test("dark"){
    val pixel = 0
    assert(filtered(pixel) == 255)
  }

  test("light"){
    val pixel = 255
    assert(filtered(pixel) == 0)
  }

  test("random") {
    val pixel = 55
    assert(filtered(pixel) == 200)
  }
}
