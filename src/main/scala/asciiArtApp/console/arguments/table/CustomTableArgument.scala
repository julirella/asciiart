package asciiArtApp.console.arguments.table

import asciiArtApp.console.arguments.ArgumentWithString
import asciiArtApp.converters.image.TransformationTableApplier
import asciiArtApp.models.tables.UserDefinedTable

case class CustomTableArgument(chars: String) extends ArgumentWithString(chars) with TableArgument{
  override def createModule: TransformationTableApplier = {
    new TransformationTableApplier(new UserDefinedTable(chars))
  }
}
