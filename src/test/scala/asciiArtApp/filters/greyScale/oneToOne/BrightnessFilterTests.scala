package asciiArtApp.filters.greyScale.oneToOne

import asciiArtApp.models.pixels.GreyScalePixel
import helpers.TwoDCompare
import org.scalatest.FunSuite

class BrightnessFilterTests extends FunSuite {

  val arrCmp = new TwoDCompare

  test("regular brightness increase") {
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


  test("regular brightness decrease") {
    val filter = new BrightnessFilter(amount = -20)
    val inputImage = Array(
      Array(GreyScalePixel(50), GreyScalePixel(60)),
      Array(GreyScalePixel(80), GreyScalePixel(90)),
      Array(GreyScalePixel(110), GreyScalePixel(120))
    )

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(
      Array(GreyScalePixel(30), GreyScalePixel(40)),
      Array(GreyScalePixel(60), GreyScalePixel(70)),
      Array(GreyScalePixel(90), GreyScalePixel(100)),
    )

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("one pixel array") {
    val filter = new BrightnessFilter(amount = -10)
    val inputImage = Array(Array(GreyScalePixel(30)))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(Array(GreyScalePixel(20)))

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("empty array") {
    val filter = new BrightnessFilter(10)
    val inputArray: Array[Array[GreyScalePixel]] = Array.empty
    val result = filter.applyFilter(inputArray)
    assert(result.isEmpty)
  }


  test("increase brightness beyond maximum") {
    val filter = new BrightnessFilter(300)
    val inputArray: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(100), GreyScalePixel(150)),
      Array(GreyScalePixel(50), GreyScalePixel(200))
    )
    val result = filter.applyFilter(inputArray)

    val expected: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(255), GreyScalePixel(255)),
      Array(GreyScalePixel(255), GreyScalePixel(255))
    )

    assert(arrCmp.cmp2DArray(result, expected))

  }

  test("decrease brightness beyond minimum") {
    val filter = new BrightnessFilter(-300)
    val inputArray: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(100), GreyScalePixel(150)),
      Array(GreyScalePixel(50), GreyScalePixel(200))
    )
    val result = filter.applyFilter(inputArray)

    val expected: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(0), GreyScalePixel(0)),
      Array(GreyScalePixel(0), GreyScalePixel(0))
    )

    assert(arrCmp.cmp2DArray(result, expected))
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

