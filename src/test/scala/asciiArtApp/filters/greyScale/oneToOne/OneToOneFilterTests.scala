package filters.greyScale.oneToOne

import asciiArtApp.filters.greyScale.oneToOne.BrightnessFilter
import helpers.TwoDCompare
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class OneToOneFilterTests extends FunSuite {
  val arrCmp = new TwoDCompare


  test("Applying InversionFilter to an image should invert each pixel") {
    val filter = new InversionFilter()
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
    )

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(
      Array(GreyScalePixel(254), GreyScalePixel(253), GreyScalePixel(252)),
      Array(GreyScalePixel(251), GreyScalePixel(250), GreyScalePixel(249)),
    )
    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("Applying BrightnessFilter to an image should adjust the brightness of each pixel") {
    val filter = new BrightnessFilter(amount = 20)
    val inputImage = Array(
      Array(GreyScalePixel(30), GreyScalePixel(40)),
      Array(GreyScalePixel(60), GreyScalePixel(70)),
      Array(GreyScalePixel(90), GreyScalePixel(100)),
    )

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(
      Array(GreyScalePixel(50), GreyScalePixel(60)),
      Array(GreyScalePixel(80), GreyScalePixel(90)),
      Array(GreyScalePixel(110), GreyScalePixel(120))
    )

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("Applying BrightnessFilter to an image with a single pixel should adjust the brightness of that pixel") {
    val filter = new BrightnessFilter(amount = -10)
    val inputImage = Array(Array(GreyScalePixel(30)))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(Array(GreyScalePixel(20)))

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("Applying InversionFilter to an empty image should result in an empty image") {
    val filter = new InversionFilter()
    val inputImage = Array[Array[GreyScalePixel]]()

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array[Array[GreyScalePixel]]()

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("invert mustn't modify original array") {
    val filter = new InversionFilter()
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )
    val originalArray = inputImage.map(a => a.clone())

    filter.applyFilter(inputImage)

    assert(arrCmp.cmp2DArray(inputImage, originalArray))
  }

  test("brightness change mustn't modify original array") {
    val filter = new BrightnessFilter(amount = -10)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )
    val originalArray = inputImage.map(a => a.clone())

    filter.applyFilter(inputImage)

    assert(arrCmp.cmp2DArray(inputImage, originalArray))
  }
}