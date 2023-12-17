package asciiArtApp.models.tables

import models.pixels.GreyScalePixel
import models.tables.UserDefinedTable
import org.scalatest.FunSuite

class UserDefinedTableTests extends FunSuite{
  val table: UserDefinedTable = new UserDefinedTable("abc")
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

  test("table too long"){
    assertThrows[IllegalArgumentException]{
      new UserDefinedTable("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    }
  }

  test("table too short") {
    assertThrows[IllegalArgumentException] {
      new UserDefinedTable("")
    }
  }
  test("table just right short") {
    val okTable = new UserDefinedTable("a")
    assert(okTable.transformPixel(GreyScalePixel(42)).value == 'a')
  }

  test("table just right long") {
    val okTable = new UserDefinedTable("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    assert(okTable.transformPixel(GreyScalePixel(42)).value == 'a')
  }
}
