package console.arguments.table

import converters.image.TransformationTableApplier
import models.tables.UserDefinedTable
import org.scalatest.FunSuite

class CustomTableArgumentTests extends FunSuite{
  test("table instance created"){
    val argument = CustomTableArgument("table")
    val applier = argument.createModule
    assert(applier.getTable == UserDefinedTable("table"))
  }
}
