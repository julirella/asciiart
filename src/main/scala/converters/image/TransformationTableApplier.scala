package converters.image
import models.tables.TransformationTable

class TransformationTableApplier (table: TransformationTable) extends GSToAsciiConverter {

  override def convertPixel(from: Int): Char = {
    table.transformPixel(from)
  }
}
