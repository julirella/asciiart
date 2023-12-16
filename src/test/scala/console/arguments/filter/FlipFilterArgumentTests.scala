package console.arguments.filter

import filters.greyScale.FlipFilter
import org.scalatest.FunSuite

class FlipFilterArgumentTests extends FunSuite{
  test("x axis") {
    val argument = FlipFilterArgument("x")
    val filter: FlipFilter = argument.createModule
    assert(filter.axis == 0)
  }

  test("y axis") {
    val argument = FlipFilterArgument("y")
    val filter: FlipFilter = argument.createModule
    assert(filter.axis == 1)
  }

  test("wrong axis") {
    assertThrows[IllegalArgumentException] {
      FlipFilterArgument("z")
    }
  }

  test("non argument") {
    assertThrows[IllegalArgumentException] {
      BrightnessFilterArgument("--error")
    }
  }
}
