package asciiArtApp.console.arguments.filter

import asciiArtApp.filters.greyScale.oneToOne.BrightnessFilter
import console.arguments.filter.BrightnessFilterArgument
import org.scalatest.FunSuite

class BrightnessFilterArgumentTests extends FunSuite{
  test("positive int") {
    val argument = BrightnessFilterArgument("20")
    val filter: BrightnessFilter = argument.createModule
    assert(filter.amount == 20)
  }

  test("value is not int") {
    assertThrows[IllegalArgumentException] {
      BrightnessFilterArgument("abc")
    }
  }

  test("negative int") {
    val argument = BrightnessFilterArgument("-10")
    val filter: BrightnessFilter = argument.createModule
    assert(filter.amount == -10)
  }

  test("float") {
    assertThrows[IllegalArgumentException] {
      BrightnessFilterArgument("10.5")
    }
  }

  test("non argument") {
    assertThrows[IllegalArgumentException] {
      BrightnessFilterArgument("--error")
    }
  }
}
