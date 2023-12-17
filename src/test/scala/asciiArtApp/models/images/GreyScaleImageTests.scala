package asciiArtApp.models.images

import helpers.TwoDCompare
import models.images.GreyScaleImage
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class GreyScaleImageTests extends FunSuite{
  val arrCmp = new TwoDCompare

  test("identity") {
    val image = GreyScaleImage(Array(Array(GreyScalePixel(1), GreyScalePixel(2))))
    val updatedImage = image.updatePixels(identity)
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, image.getPixels))
  }

  test("reverse rows") {
    val image = GreyScaleImage(Array(Array(GreyScalePixel(1)), Array(GreyScalePixel(2))))
    val updatedImage = image.updatePixels(_.reverse)
    val expectedImage = GreyScaleImage(Array(Array(GreyScalePixel(2)), Array(GreyScalePixel(1))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))
  }

  test("sum rows") {
    val image = GreyScaleImage(Array(
                              Array(GreyScalePixel(1), GreyScalePixel(4)),
                              Array(GreyScalePixel(2), GreyScalePixel(5)),
                              Array(GreyScalePixel(3), GreyScalePixel(6))))
    val updatedImage = image.updatePixels(_.map(row => Array(GreyScalePixel(row.foldLeft(0)((sum, pixel) => sum + pixel.value)))))
    val expectedImage = GreyScaleImage(Array(
      Array(GreyScalePixel(5)),
      Array(GreyScalePixel(7)),
      Array(GreyScalePixel(9))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))

  }

  test("update mustn't change original image") {
    val image = GreyScaleImage(Array(Array(GreyScalePixel(1)), Array(GreyScalePixel(2))))
    val originalPixels = image.getPixels
    image.updatePixels(_.reverse)
    val newPixels = image.getPixels
    assert(arrCmp.cmp2DArray(originalPixels, newPixels))
  }

  test("getter") {
    val originalPixels = Array(Array(GreyScalePixel(1), GreyScalePixel(2)))
    val image = GreyScaleImage(originalPixels)
    val retrievedPixels = image.getPixels
    retrievedPixels(0)(0) = GreyScalePixel(99)
    assert(image != GreyScaleImage(retrievedPixels))
    assert(!arrCmp.cmp2DArray(originalPixels, retrievedPixels))
  }
}
