package asciiArtApp.filters.greyScale.oneToOne
import asciiArtApp.models.pixels.GreyScalePixel
import helpers.TwoDCompare
import org.scalatest.FunSuite

class InversionFilterTests extends FunSuite {

  val arrCmp = new TwoDCompare

  test("regular invert") {
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

  test("empty array") {
    val filter = new InversionFilter
    val inputArray: Array[Array[GreyScalePixel]] = Array.empty
    val result = filter.applyFilter(inputArray)
    assert(result.isEmpty)
  }

  test("max to min") {
    val filter = new InversionFilter
    val inputArray: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(255))
    )
    val result = filter.applyFilter(inputArray)

    val expected: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(0))
    )

    assert(arrCmp.cmp2DArray(result, expected))
  }

  test("min to max") {
    val filter = new InversionFilter
    val inputArray: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(0))
    )
    val result = filter.applyFilter(inputArray)

    val expected: Array[Array[GreyScalePixel]] = Array(
      Array(GreyScalePixel(255))
    )

    assert(arrCmp.cmp2DArray(result, expected))
  }

  test("invert mustn't modify the original array") {
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


}

