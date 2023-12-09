package filters.greyScale.oneToOne

import models.images.GreyScaleImage
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class OneToOneFilterTests extends FunSuite {
  test("Applying InversionFilter to an image should invert each pixel") {
    val filter = new InversionFilter()
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      List(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
    ))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(
      List(GreyScalePixel(254), GreyScalePixel(253), GreyScalePixel(252)),
      List(GreyScalePixel(251), GreyScalePixel(250), GreyScalePixel(249)),
    ))

    assert(result == expectedOutput)
  }

  test("Applying BrightnessFilter to an image should adjust the brightness of each pixel") {
    val filter = new BrightnessFilter(amount = 20)
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(30), GreyScalePixel(40)),
      List(GreyScalePixel(60), GreyScalePixel(70)),
      List(GreyScalePixel(90), GreyScalePixel(100)),
    ))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(
      List(GreyScalePixel(50), GreyScalePixel(60)),
      List(GreyScalePixel(80), GreyScalePixel(90)),
      List(GreyScalePixel(110), GreyScalePixel(120))
    ))

    assert(result == expectedOutput)
  }

  test("Applying BrightnessFilter to an image with a single pixel should adjust the brightness of that pixel") {
    val filter = new BrightnessFilter(amount = -10)
    val inputImage = GreyScaleImage(List(List(GreyScalePixel(30))))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(List(GreyScalePixel(20))))

    assert(result == expectedOutput)
  }

  test("Applying InversionFilter to an empty image should result in an empty image") {
    val filter = new InversionFilter()
    val inputImage = GreyScaleImage(List(List()))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(List()))

    assert(result == expectedOutput)
  }
}