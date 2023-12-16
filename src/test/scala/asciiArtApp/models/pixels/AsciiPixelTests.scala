package asciiArtApp.models.pixels

import models.pixels.AsciiPixel
import org.scalatest.FunSuite

class AsciiPixelTests extends FunSuite{
  test("ok value") {
    val pixel = AsciiPixel(126)
    assert(pixel.value == 126)
  }
  test("wrong value") {
    assertThrows[IllegalArgumentException] {
      AsciiPixel(127)
    }
  }
}
