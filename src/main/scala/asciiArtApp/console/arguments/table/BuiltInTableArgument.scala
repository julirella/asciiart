package asciiArtApp.console.arguments.table

import asciiArtApp.console.arguments.ArgumentWithString
import asciiArtApp.converters.image.TransformationTableApplier
import asciiArtApp.models.tables.{LameTable, PaulBourkesTable}

case class BuiltInTableArgument(name: String) extends ArgumentWithString(name) with TableArgument {
  require(name == "paul-bourkes" || name == "lame", "invalid table name")
  override def createModule: TransformationTableApplier = {
    if(name == "paul-bourkes") new TransformationTableApplier(new PaulBourkesTable)
    else new TransformationTableApplier(new LameTable)
  }
}
