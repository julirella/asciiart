package models.images

import helpers.TwoDCompare
import models.pixels.RgbPixel
import org.scalatest.FunSuite

class RgbImageTests extends FunSuite{
  val arrCmp = new TwoDCompare

  val pixel1: RgbPixel = RgbPixel(255, 0, 0)
  val pixel2: RgbPixel = RgbPixel(0, 255, 0)
  val pixel3: RgbPixel = RgbPixel(255, 255, 0)
  val pixel4: RgbPixel = RgbPixel(255, 0, 255)

  test("getter"){
    val pixels = Array(Array(pixel1, pixel2), Array(pixel3, pixel4))
    val rgbImage = RgbImage(pixels)
    val retrievedPixels = rgbImage.getPixels
    retrievedPixels(0)(0) = RgbPixel(1, 1, 1)
    assert(rgbImage != RgbImage(retrievedPixels))
    assert(!arrCmp.cmp2DArray(rgbImage.getPixels, retrievedPixels))
  }

  test("identity") {
    val image = RgbImage(Array(Array(RgbPixel(1, 2, 3), RgbPixel(4, 5, 6))))
    val updatedImage = image.updatePixels(identity)
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, image.getPixels))
  }

  test("reverse rows") {
    val image = RgbImage(Array(Array(RgbPixel(1, 2, 3)), Array(RgbPixel(4, 5, 6))))
    val updatedImage = image.updatePixels(_.reverse)
    val expectedImage = RgbImage(Array(Array(RgbPixel(4, 5, 6)), Array(RgbPixel(1, 2, 3))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))

  }

  test("keep first column") {
    val image = RgbImage(Array(Array(pixel1, pixel2), Array(pixel3, pixel4)))
    val updatedImage = image.updatePixels(_.map( row => Array(row(0))))
    val expectedImage = RgbImage(Array(Array(pixel1), Array(pixel3)))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))
  }
}
