package converters

import models.images.AsciiImage
import models.pixels.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageToStringConverterTests extends FunSuite{
  val converter = new AsciiImageToStringConverter()
  test("1D array"){
    val from = AsciiImage(Array(
      Array(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c'))
    ))
    val to = "abc\n"
    assert(converter.convert(from) == to)
  }
  test("2D array") {
    val from = AsciiImage(Array(
      Array(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
      Array(AsciiPixel('d'), AsciiPixel('e'), AsciiPixel('f')),
      Array(AsciiPixel('h'), AsciiPixel('i'), AsciiPixel('j'))

    ))
    val to = "abc\ndef\nhij\n"
    assert(converter.convert(from) == to)
  }

  test("weird array"){
    val from = AsciiImage(Array(
      Array(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
      Array(),
      Array(AsciiPixel('h'), AsciiPixel('i'))
    ))
    val to = "abc\n\nhi\n"
    assert(converter.convert(from) == to)
  }
}
