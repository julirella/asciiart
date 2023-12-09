package console.arguments.table

import console.arguments.ArgumentWithString
import converters.image.TransformationTableApplier
import models.tables.UserDefinedTable

case class CustomTableArgument(chars: String) extends ArgumentWithString(chars) with TableArgument{
  override def createModule: TransformationTableApplier = {
    new TransformationTableApplier(new UserDefinedTable(chars))
  }
}
