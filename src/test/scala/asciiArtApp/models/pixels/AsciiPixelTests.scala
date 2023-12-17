package asciiArtApp.models.pixels

import org.scalatest.FunSuite

class AsciiPixelTests extends FunSuite{
  test("ok value high") {
    val pixel = AsciiPixel(126)
    assert(pixel.value == 126)
  }
  test("wrong value high") {
    assertThrows[IllegalArgumentException] {
      AsciiPixel(127)
    }
  }

  test("ok value low") {
    val pixel = AsciiPixel(32)
    assert(pixel.value == 32)
  }
  test("wrong value low") {
    assertThrows[IllegalArgumentException] {
      AsciiPixel(31)
    }
  }

}
