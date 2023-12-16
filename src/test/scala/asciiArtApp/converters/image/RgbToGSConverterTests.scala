package asciiArtApp.converters.image

import converters.image.RgbToGSConverter
import helpers.TwoDCompare
import models.images.{GreyScaleImage, RgbImage}
import models.pixels.{GreyScalePixel, RgbPixel}
import org.scalatest.FunSuite

class RgbToGSConverterTests extends FunSuite{
  val converter = new RgbToGSConverter
  val arrCmp = new TwoDCompare

  test("2x2 array"){
    val from = RgbImage(Array(
      Array(RgbPixel(100, 39, 150), RgbPixel(0, 0, 0)),
      Array(RgbPixel(255, 0, 199), RgbPixel(255, 255, 255))
    ))
    val to = GreyScaleImage(Array(
      Array(GreyScalePixel(70), GreyScalePixel(0)),
        Array(GreyScalePixel(98), GreyScalePixel(255))
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

  test("1x1 array") {
    val from = RgbImage(Array(
      Array(RgbPixel(200, 100, 50)),
    ))
    val to = GreyScaleImage(Array(
      Array(GreyScalePixel(125))
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

  test("0x0 array") {
    val from = RgbImage(Array(
      Array()
    ))
    val to = GreyScaleImage(Array(
      Array()
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }
}
