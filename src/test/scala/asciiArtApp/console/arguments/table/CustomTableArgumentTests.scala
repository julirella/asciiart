package asciiArtApp.console.arguments.table

import asciiArtApp.converters.image.TransformationTableApplier
import asciiArtApp.models.tables.UserDefinedTable
import org.scalatest.FunSuite

class CustomTableArgumentTests extends FunSuite{
  test("table instance created"){
    val argument = CustomTableArgument("table")
    val applier: TransformationTableApplier = argument.createModule
//    assert(applier.table == new UserDefinedTable("table"))
    assert(applier.table.isInstanceOf[UserDefinedTable])
  }
}
