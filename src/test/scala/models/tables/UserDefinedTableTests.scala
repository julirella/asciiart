package models.tables

import models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class UserDefinedTableTests extends FunSuite{
  val table: UserDefinedTable = UserDefinedTable("abc")
  def transformed(from: Int): Char = table.transformPixel(GreyScalePixel(from)).value

  test("first group end") {
    assert(transformed(85) == 'a')
  }
  test("second group start") {
    assert(transformed(86) == 'b')
  }
  test("second group end") {
    assert(transformed(170) == 'b')
  }
  test("third group start") {
    assert(transformed(171) == 'c')
  }
}
