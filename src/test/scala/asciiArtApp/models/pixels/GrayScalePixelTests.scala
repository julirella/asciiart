package asciiArtApp.models.pixels

import org.scalatest.FunSuite

class GrayScalePixelTests extends FunSuite{
  test("ok value high") {
    val pixel = GreyScalePixel(255)
    assert(pixel.value == 255)
  }
  test("wrong value high"){
    assertThrows[IllegalArgumentException] { GreyScalePixel(256)}
  }

  test("ok value low") {
    val pixel = GreyScalePixel(0)
    assert(pixel.value == 0)
  }
  test("wrong value low") {
    assertThrows[IllegalArgumentException] {
      GreyScalePixel(-1)
    }
  }
}
