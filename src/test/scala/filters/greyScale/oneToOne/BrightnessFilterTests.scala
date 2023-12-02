//package filters.greyScale.oneToOne
//
//import org.scalatest.FunSuite
//
//class BrightnessFilterTests extends FunSuite{
//  def filtered(pixel: Int, value: Int): Int = new BrightnessFilter(value).applyToOnePixel(pixel)
//
//  test("random") {
//    val pixel = 30
//    val value = 30
//    assert(filtered(pixel, value) == 60)
//  }
//
//  test("too light") {
//    val pixel = 10
//    val value = -50
//    assert(filtered(pixel, value) == 0)
//  }
//
//  test("too dark") {
//    val pixel = 200
//    val value = 100
//    assert(filtered(pixel, value) == 255)
//  }
//
//  test("just about") {
//    val pixel = 200
//    val value = -199
//    assert(filtered(pixel, value) == 1)
//  }
//}
