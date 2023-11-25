package models.images

import models.pixels.RgbPixel
import org.scalatest.FunSuite

class RgbImageTests extends FunSuite{
  test("getter"){
    val pixel1 = new RgbPixel(255, 0, 0)
    val pixel2 = new RgbPixel(0, 255, 0)
    val pixel3 = new RgbPixel(255, 255, 0)
    val pixel4 = new RgbPixel(255, 0, 255)

    val pixels = List(List(pixel1, pixel2), List(pixel3, pixel4))
    val rgbImage = RgbImage(pixels)
    assert(rgbImage.getPixels == pixels)
  }
}
