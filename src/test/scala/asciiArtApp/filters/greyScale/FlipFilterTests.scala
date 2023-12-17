package asciiArtApp.filters.greyScale

import helpers.TwoDCompare
import asciiArtApp.models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class FlipFilterTests extends FunSuite {
  val arrCmp = new TwoDCompare

  test("x axis flip") {
    val filter = new FlipFilter(axis = 0)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3))
    )

    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("y axis flip") {
    val filter = new FlipFilter(axis = 1)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )

    val result = filter.applyFilter(inputImage)

    val expectedOutput = Array(
      Array(GreyScalePixel(3), GreyScalePixel(2), GreyScalePixel(1)),
      Array(GreyScalePixel(6), GreyScalePixel(5), GreyScalePixel(4)),
      Array(GreyScalePixel(9), GreyScalePixel(8), GreyScalePixel(7))
    )

    assert(arrCmp.cmp2DArray(result, expectedOutput))

  }

  test("non-square image x axis") {
    val filter0 = new FlipFilter(axis = 0)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2)),
      Array(GreyScalePixel(3), GreyScalePixel(4)),
      Array(GreyScalePixel(5), GreyScalePixel(6))
    )

    val result0 = filter0.applyFilter(inputImage)
    val expectedOutput0 = Array(
      Array(GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(3), GreyScalePixel(4)),
      Array(GreyScalePixel(1), GreyScalePixel(2))
    )

    assert(arrCmp.cmp2DArray(result0, expectedOutput0))
  }

  test("non-square image y axis") {
    val filter1 = new FlipFilter(axis = 1)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2)),
      Array(GreyScalePixel(3), GreyScalePixel(4)),
      Array(GreyScalePixel(5), GreyScalePixel(6))
    )

    val result1 = filter1.applyFilter(inputImage)
    val expectedOutput1 = Array(
      Array(GreyScalePixel(2), GreyScalePixel(1)),
      Array(GreyScalePixel(4), GreyScalePixel(3)),
      Array(GreyScalePixel(6), GreyScalePixel(5))
    )
    assert(arrCmp.cmp2DArray(result1, expectedOutput1))

  }

  test("empty image x axis") {
    val filter = new FlipFilter(axis = 0)
    val inputImage = Array[Array[GreyScalePixel]]()
    val result = filter.applyFilter(inputImage)
    val expectedOutput = Array[Array[GreyScalePixel]]()
    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("empty image y axis") {
    val filter = new FlipFilter(axis = 1)
    val inputImage = Array[Array[GreyScalePixel]]()
    val result = filter.applyFilter(inputImage)
    val expectedOutput = Array[Array[GreyScalePixel]]()
    assert(arrCmp.cmp2DArray(result, expectedOutput))
  }

  test("flip mustn't modify original array") {
    val filter = new FlipFilter(axis = 0)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )
    val originalArray = inputImage.map(a => a.clone())

    filter.applyFilter(inputImage)

    assert(arrCmp.cmp2DArray(inputImage, originalArray))
  }

  test("wrong axis") {
    assertThrows[IllegalArgumentException]{
      new FlipFilter(2)
    }
  }
}

