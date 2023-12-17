package asciiArtApp.filters.greyScale.oneToOne

import asciiArtApp.models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class BrightnessFilterTests extends FunSuite {

  test("increase brightness from 0") {
    val filter = new BrightnessFilter(amount = 50)
    val blackPixel = GreyScalePixel(0)
    val result = filter.applyToOnePixel(blackPixel)
    val expected = GreyScalePixel(50)
    assert(result == expected)
  }

  test("decrease brightness from maximum") {
    val filter = new BrightnessFilter(amount = -50)
    val whitePixel = GreyScalePixel(255)
    val result = filter.applyToOnePixel(whitePixel)
    val expected = GreyScalePixel(205)
    assert(result == expected)
  }

  test("increase brightness from middle") {
    val filter = new BrightnessFilter(amount = 30)
    val midGrayPixel = GreyScalePixel(128)
    val result = filter.applyToOnePixel(midGrayPixel)
    val expected = GreyScalePixel(158)
    assert(result == expected)
  }

  test("decrease brightness beyond minimum") {
    val filter = new BrightnessFilter(amount = -300)
    val maxPixel = GreyScalePixel(255)
    val result = filter.applyToOnePixel(maxPixel)
    val expected = GreyScalePixel(0)
    assert(result == expected)
  }

  test("increase brightness beyond maximum") {
    val filter = new BrightnessFilter(amount = 300)
    val minPixel = GreyScalePixel(0)
    val result = filter.applyToOnePixel(minPixel)
    val expected = GreyScalePixel(255)
    assert(result == expected)
  }

  test("brightness change mustn't modify original pixel"){
    val filter = new BrightnessFilter(amount = 50)
    val pixel = GreyScalePixel(10)
    val originalVal = pixel.value
    filter.applyToOnePixel(pixel)
    val newVal = pixel.value
    assert(originalVal == newVal)
  }

  test("brightness change over max mustn't modify original pixel") {
    val filter = new BrightnessFilter(amount = 300)
    val pixel = GreyScalePixel(10)
    val originalVal = pixel.value
    filter.applyToOnePixel(pixel)
    val newVal = pixel.value
    assert(originalVal == newVal)
  }

  test("brightness change bellow min mustn't modify original pixel") {
    val filter = new BrightnessFilter(amount = -300)
    val pixel = GreyScalePixel(10)
    val originalVal = pixel.value
    filter.applyToOnePixel(pixel)
    val newVal = pixel.value
    assert(originalVal == newVal)
  }
}

