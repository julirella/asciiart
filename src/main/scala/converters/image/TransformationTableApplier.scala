package converters.image
import models.pixels.{AsciiPixel, GreyScalePixel}
import models.tables.TransformationTable

class TransformationTableApplier (table: TransformationTable) extends GSToAsciiConverter {
  def getTable: TransformationTable = table
   override protected def convertPixel(from: GreyScalePixel): AsciiPixel = {
    table.transformPixel(from)
  }
}
