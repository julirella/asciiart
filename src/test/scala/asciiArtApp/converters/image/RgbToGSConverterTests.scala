package asciiArtApp.converters.image

import helpers.TwoDCompare
import asciiArtApp.models.images.{GreyScaleImage, RgbImage}
import asciiArtApp.models.pixels.{GreyScalePixel, RgbPixel}
import org.scalatest.FunSuite

class RgbToGSConverterTests extends FunSuite{
  val converter = new RgbToGSConverter
  val arrCmp = new TwoDCompare

  test("2x2 array"){
    val from = new RgbImage(Array(
      Array(new RgbPixel(100, 39, 150), new RgbPixel(0, 0, 0)),
      Array(new RgbPixel(255, 0, 199), new RgbPixel(255, 255, 255))
    ))
    val to = new GreyScaleImage(Array(
      Array(GreyScalePixel(70), GreyScalePixel(0)),
        Array(GreyScalePixel(98), GreyScalePixel(255))
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

  test("1x1 array") {
    val from = new RgbImage(Array(
      Array(new RgbPixel(200, 100, 50)),
    ))
    val to = new GreyScaleImage(Array(
      Array(GreyScalePixel(125))
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

  test("0x0 array") {
    val from = new RgbImage(Array(
      Array()
    ))
    val to = new GreyScaleImage(Array(
      Array()
    ))
    val result = converter.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }
}
