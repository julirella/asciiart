package converters.image

import models.images.{GreyScaleImage, RgbImage}
import models.pixels.{GreyScalePixel, RgbPixel}
import org.scalatest.FunSuite

class RgbToGSConverterTests extends FunSuite{
  val converter = new RgbToGSConverter
  test("2x2 list"){
    val from = RgbImage(List(
      List(RgbPixel(100, 39, 150), RgbPixel(0, 0, 0)),
      List(RgbPixel(255, 0, 199), RgbPixel(255, 255, 255))
    ))
    val to = GreyScaleImage(List(
      List(GreyScalePixel(70), GreyScalePixel(0)),
        List(GreyScalePixel(98), GreyScalePixel(255))
    ))
    assert(converter.convert(from) == to)
  }

  test("1x1 list") {
    val from = RgbImage(List(
      List(RgbPixel(200, 100, 50)),
    ))
    val to = GreyScaleImage(List(
      List(GreyScalePixel(125))
    ))
    assert(converter.convert(from) == to)
  }

  test("0x0 list") {
    val from = RgbImage(List(
      List()
    ))
    val to = GreyScaleImage(List(
      List()
    ))
    assert(converter.convert(from) == to)
  }
}
