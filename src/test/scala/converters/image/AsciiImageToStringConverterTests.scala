package converters.image

import converters.AsciiImageToStringConverter
import models.images.AsciiImage
import models.pixels.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageToStringConverterTests extends FunSuite{
  val converter = new AsciiImageToStringConverter()
  test("1D list"){
    val from = AsciiImage(List(
      List(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c'))
    ))
    val to = "abc\n"
    assert(converter.convert(from) == to)
  }
  test("2D list") {
    val from = AsciiImage(List(
      List(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
      List(AsciiPixel('d'), AsciiPixel('e'), AsciiPixel('f')),
      List(AsciiPixel('h'), AsciiPixel('i'), AsciiPixel('j'))

    ))
    val to = "abc\ndef\nhij\n"
    assert(converter.convert(from) == to)
  }

  test("weird list"){
    val from = AsciiImage(List(
      List(AsciiPixel('a'), AsciiPixel('b'), AsciiPixel('c')),
      List(),
      List(AsciiPixel('h'), AsciiPixel('i'))
    ))
    val to = "abc\n\nhi\n"
    assert(converter.convert(from) == to)
  }
}
