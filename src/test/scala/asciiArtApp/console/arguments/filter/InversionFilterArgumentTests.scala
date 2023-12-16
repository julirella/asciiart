package asciiArtApp.console.arguments.filter

import console.arguments.filter.InversionFilterArgument
import filters.greyScale.oneToOne.InversionFilter
import org.scalatest.FunSuite

class InversionFilterArgumentTests extends FunSuite{
  test("filter instance created") {
    val argument = InversionFilterArgument()
    val filter = argument.createModule
    assert(filter.isInstanceOf[InversionFilter])
  }
}
