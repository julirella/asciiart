package filters.greyScale.oneToOne
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class BrightnessFilterTests extends FunSuite {

  test("Increasing brightness of a black pixel should result in a brighter pixel") {
    val filter = BrightnessFilter(amount = 50)
    val blackPixel = GreyScalePixel(0)
    val result = filter.applyToOnePixel(blackPixel)
    val expected = GreyScalePixel(50)
    assert(result == expected)
  }

  test("Decreasing brightness of a white pixel should result in a darker pixel") {
    val filter = BrightnessFilter(amount = -50)
    val whitePixel = GreyScalePixel(255)
    val result = filter.applyToOnePixel(whitePixel)
    val expected = GreyScalePixel(205)
    assert(result == expected)
  }

  test("Increasing brightness of a mid-gray pixel should result in a brighter pixel") {
    val filter = BrightnessFilter(amount = 30)
    val midGrayPixel = GreyScalePixel(128)
    val result = filter.applyToOnePixel(midGrayPixel)
    val expected = GreyScalePixel(158)
    assert(result == expected)
  }

  test("Decreasing brightness of a pixel with the maximum value should result in a pixel with the minimum value") {
    val filter = BrightnessFilter(amount = -300)
    val maxPixel = GreyScalePixel(255)
    val result = filter.applyToOnePixel(maxPixel)
    val expected = GreyScalePixel(0)
    assert(result == expected)
  }

  test("Increasing brightness of a pixel with the minimum value should result in a pixel with the maximum value") {
    val filter = BrightnessFilter(amount = 300)
    val minPixel = GreyScalePixel(0)
    val result = filter.applyToOnePixel(minPixel)
    val expected = GreyScalePixel(255)
    assert(result == expected)
  }

  test("Applying zero brightness change should result in the same pixel value") {
    val filter = BrightnessFilter(amount = 0)
    val randomPixelValue = scala.util.Random.nextInt(256)
    val randomPixel = GreyScalePixel(randomPixelValue)
    val result = filter.applyToOnePixel(randomPixel)
    assert(result == randomPixel)
  }

  test("Increasing brightness beyond the maximum should result in a white pixel") {
    val filter = BrightnessFilter(amount = 300)
    val randomPixel = GreyScalePixel(100)
    val result = filter.applyToOnePixel(randomPixel)
    val expected = GreyScalePixel(255)
    assert(result == expected)
  }

  test("Decreasing brightness beyond the minimum should result in a black pixel") {
    val filter = BrightnessFilter(amount = -300)
    val randomPixel = GreyScalePixel(150)
    val result = filter.applyToOnePixel(randomPixel)
    val expected = GreyScalePixel(0)
    assert(result == expected)
  }
}

