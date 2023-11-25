package models.pixels

import org.scalatest.FunSuite

class GrayScalePixelTests extends FunSuite{
  test("ok value") {
    val pixel = GreyScalePixel(255)
    assert(pixel.value == 255)
  }
  test("wrong value"){
    assertThrows[IllegalArgumentException] { GreyScalePixel(256)}
  }
}
