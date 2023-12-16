package filters.greyScale

import helpers.TwoDCompare
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class FlipFilterTests extends FunSuite {
  val arrCmp = new TwoDCompare

  test("x axis flip") {
    val filter = FlipFilter(axis = 0)
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
    val filter = FlipFilter(axis = 1)
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

  test("non-square image") {
    val filter0 = FlipFilter(axis = 0)
    val filter1 = FlipFilter(axis = 1)
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

    val result1 = filter1.applyFilter(inputImage)
    val expectedOutput1 = Array(
      Array(GreyScalePixel(2), GreyScalePixel(1)),
      Array(GreyScalePixel(4), GreyScalePixel(3)),
      Array(GreyScalePixel(6), GreyScalePixel(5))
    )

    assert(arrCmp.cmp2DArray(result0, expectedOutput0))
    assert(arrCmp.cmp2DArray(result1, expectedOutput1))

  }

  test("wrong axis") {
    val filter = FlipFilter(axis = 2)
    val inputImage = Array(
      Array(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      Array(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      Array(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    )

    intercept[IllegalArgumentException] {
      filter.applyFilter(inputImage)
    }
  }
}

