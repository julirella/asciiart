package console.arguments.table

import console.arguments.ArgumentWithString
import converters.image.TransformationTableApplier
import models.tables.{LameTable, PaulBourkesTable}

case class BuiltInTableArgument(name: String) extends ArgumentWithString(name) with TableArgument {
  override def createModule: TransformationTableApplier = {
    if(name == "paul-bourkes") new TransformationTableApplier(new PaulBourkesTable)
    else if(name == "lame") new TransformationTableApplier(new LameTable)
    else throw new IllegalArgumentException("invalid table name")
  }
}
