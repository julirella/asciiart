package asciiArtApp.console.arguments.table

import console.arguments.table.BuiltInTableArgument
import models.tables.{LameTable, PaulBourkesTable}
import org.scalatest.FunSuite

class BuiltInTableArgumentTests extends FunSuite{
  test("paul-bourkes table") {
    val argument = BuiltInTableArgument("paul-bourkes")
    assert(argument.createModule.getTable.isInstanceOf[PaulBourkesTable])
  }

  test("lame table") {
      val argument = BuiltInTableArgument("lame")
      assert(argument.createModule.getTable.isInstanceOf[LameTable])
  }

  test("wrong table") {
    assertThrows[IllegalArgumentException] {
      BuiltInTableArgument("unknown-table")
    }
  }
}
