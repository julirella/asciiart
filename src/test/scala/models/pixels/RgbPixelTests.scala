package models.pixels

import org.scalatest.FunSuite

class RgbPixelTests extends FunSuite{

  test("values on the limit") {
    var pixel = RgbPixel(0, 0, 255)
    assert(pixel.red == 0 && pixel.blue == 255 && pixel.green == 0)
  }

  test("wrong values") {
    assertThrows[IllegalArgumentException] { RgbPixel(-1, 0, 0) }
  }
}
