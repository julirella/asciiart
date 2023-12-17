package asciiArtApp.models.images

import helpers.TwoDCompare
import asciiArtApp.models.pixels.RgbPixel
import org.scalatest.FunSuite

class RgbImageTests extends FunSuite{
  val arrCmp = new TwoDCompare

  val pixel1: RgbPixel = new RgbPixel(255, 0, 0)
  val pixel2: RgbPixel = new RgbPixel(0, 255, 0)
  val pixel3: RgbPixel = new RgbPixel(255, 255, 0)
  val pixel4: RgbPixel = new RgbPixel(255, 0, 255)

  test("getter"){
    val pixels = Array(Array(pixel1, pixel2), Array(pixel3, pixel4))
    val rgbImage = new RgbImage(pixels)
    val retrievedPixels = rgbImage.getPixels
    retrievedPixels(0)(0) = new RgbPixel(1, 1, 1)
    assert(rgbImage != new RgbImage(retrievedPixels))
    assert(!arrCmp.cmp2DArray(rgbImage.getPixels, retrievedPixels))
  }

  test("identity") {
    val image = new RgbImage(Array(Array(new RgbPixel(1, 2, 3), new RgbPixel(4, 5, 6))))
    val updatedImage = image.updatePixels(identity)
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, image.getPixels))
  }

  test("reverse rows") {
    val image = new RgbImage(Array(Array(new RgbPixel(1, 2, 3)), Array(new RgbPixel(4, 5, 6))))
    val updatedImage = image.updatePixels(_.reverse)
    val expectedImage = new RgbImage(Array(Array(new RgbPixel(4, 5, 6)), Array(new RgbPixel(1, 2, 3))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))

  }

  test("keep first column") {
    val image = new RgbImage(Array(Array(pixel1, pixel2), Array(pixel3, pixel4)))
    val updatedImage = image.updatePixels(_.map( row => Array(row(0))))
    val expectedImage = new RgbImage(Array(Array(pixel1), Array(pixel3)))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))
  }

  test("update mustn't change original image") {
    val image = new RgbImage(Array(Array(new RgbPixel(1, 2, 3)), Array(new RgbPixel(4, 5, 6))))
    val originalPixels = image.getPixels
    image.updatePixels(_.reverse)
    val newPixels = image.getPixels
    assert(arrCmp.cmp2DArray(originalPixels, newPixels))
  }
}
