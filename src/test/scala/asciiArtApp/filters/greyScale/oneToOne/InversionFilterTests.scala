package filters.greyScale.oneToOne
import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class InversionFilterTests extends FunSuite {

  test("black to white") {
    val filter = new InversionFilter()
    val blackPixel = GreyScalePixel(0)
    val result = filter.applyToOnePixel(blackPixel)
    val expected = GreyScalePixel(255)
    assert(result == expected)
  }

  test("white to black") {
    val filter = new InversionFilter()
    val whitePixel = GreyScalePixel(255)
    val result = filter.applyToOnePixel(whitePixel)
    val expected = GreyScalePixel(0)
    assert(result == expected)
  }

  test("middle") {
    val filter = new InversionFilter()
    val midGrayPixel = GreyScalePixel(128)
    val result = filter.applyToOnePixel(midGrayPixel)
    val expected = GreyScalePixel(127) // 255 - 128
    assert(result == expected)
  }

  test("inversion filter mustn't modify original pixel"){
    val filter = new InversionFilter()
    val pixel = GreyScalePixel(25)
    val originalVal = pixel.value
    filter.applyToOnePixel(pixel)
    assert(originalVal == pixel.value)
  }

}

