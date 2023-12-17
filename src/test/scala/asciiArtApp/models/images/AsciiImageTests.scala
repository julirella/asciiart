package asciiArtApp.models.images

import helpers.TwoDCompare
import models.images.AsciiImage
import models.pixels.AsciiPixel
import org.scalatest.FunSuite

class AsciiImageTests extends FunSuite{
  val arrCmp = new TwoDCompare

  test("identity") {
    val image = new AsciiImage(Array(Array(AsciiPixel('A'))))
    val updatedImage = image.updatePixels(identity)
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, image.getPixels))
  }

  test("reverse rows") {
    val image = new AsciiImage(Array(Array(AsciiPixel('A')), Array(AsciiPixel('B'))))
    val updatedImage = image.updatePixels(_.reverse)
    val expectedImage = new AsciiImage(Array(Array(AsciiPixel('B')), Array(AsciiPixel('A'))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))
  }

  test("fill with X") {
    val image = new AsciiImage(Array(Array(AsciiPixel('A'), AsciiPixel('B'))))
    val updatedImage = image.updatePixels(_.map(_.map(_ => AsciiPixel('X'))))
    val expectedImage = new AsciiImage(Array(Array(AsciiPixel('X'), AsciiPixel('X'))))
    assert(arrCmp.cmp2DArray(updatedImage.getPixels, expectedImage.getPixels))

  }

  test("update mustn't change original image"){
    val image = new AsciiImage(Array(Array(AsciiPixel('A')), Array(AsciiPixel('B'))))
    val originalPixels = image.getPixels
    image.updatePixels(_.map(_.map(_ => AsciiPixel('X'))))
    val newPixels = image.getPixels
    assert(arrCmp.cmp2DArray(originalPixels, newPixels))
  }

  test("getter") {
    val originalPixels = Array(Array(AsciiPixel('A'), AsciiPixel('B')))
    val image = new AsciiImage(originalPixels)
    val retrievedPixels = image.getPixels
    retrievedPixels(0)(0) = AsciiPixel('X')
    assert(!arrCmp.cmp2DArray(originalPixels, retrievedPixels))
  }
}
