package filters.greyScale

import models.images.GreyScaleImage
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class FlipFilterTests extends FunSuite {


  test("x axis flip") {
    val filter = FlipFilter(axis = 0)
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      List(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      List(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    ))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(
      List(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9)),
      List(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      List(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3))
    ))

    assert(result == expectedOutput)
  }

  test("y axis flip") {
    val filter = FlipFilter(axis = 1)
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      List(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      List(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    ))

    val result = filter.applyFilter(inputImage)

    val expectedOutput = GreyScaleImage(List(
      List(GreyScalePixel(3), GreyScalePixel(2), GreyScalePixel(1)),
      List(GreyScalePixel(6), GreyScalePixel(5), GreyScalePixel(4)),
      List(GreyScalePixel(9), GreyScalePixel(8), GreyScalePixel(7))
    ))

    assert(result == expectedOutput)
  }

  test("non-square image") {
    val filter0 = FlipFilter(axis = 0)
    val filter1 = FlipFilter(axis = 1)
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(2)),
      List(GreyScalePixel(3), GreyScalePixel(4)),
      List(GreyScalePixel(5), GreyScalePixel(6))
    ))

    val result0 = filter0.applyFilter(inputImage)
    val expectedOutput0 = GreyScaleImage(List(
      List(GreyScalePixel(5), GreyScalePixel(6)),
      List(GreyScalePixel(3), GreyScalePixel(4)),
      List(GreyScalePixel(1), GreyScalePixel(2))
    ))

    val result1 = filter1.applyFilter(inputImage)
    val expectedOutput1 = GreyScaleImage(List(
      List(GreyScalePixel(2), GreyScalePixel(1)),
      List(GreyScalePixel(4), GreyScalePixel(3)),
      List(GreyScalePixel(6), GreyScalePixel(5))
    ))

    assert(result0 == expectedOutput0)
    assert(result1 == expectedOutput1)
  }

  test("wrong axis") {
    val filter = FlipFilter(axis = 2)
    val inputImage = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(2), GreyScalePixel(3)),
      List(GreyScalePixel(4), GreyScalePixel(5), GreyScalePixel(6)),
      List(GreyScalePixel(7), GreyScalePixel(8), GreyScalePixel(9))
    ))

    intercept[IllegalArgumentException] {
      filter.applyFilter(inputImage)
    }
  }
}

