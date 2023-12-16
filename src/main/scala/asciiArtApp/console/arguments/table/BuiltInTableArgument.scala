package console.arguments.table

import console.arguments.ArgumentWithString
import converters.image.TransformationTableApplier
import models.tables.{LameTable, PaulBourkesTable}

case class BuiltInTableArgument(name: String) extends ArgumentWithString(name) with TableArgument {
  require(name == "paul-bourkes" || name == "lame", "invalid table name")
  override def createModule: TransformationTableApplier = {
    if(name == "paul-bourkes") new TransformationTableApplier(new PaulBourkesTable)
    else new TransformationTableApplier(new LameTable)
  }
}
