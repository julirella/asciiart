package converters.image
import models.pixels.{AsciiPixel, GreyScalePixel}
import models.tables.TransformationTable

class TransformationTableApplier (table: TransformationTable) extends GSToAsciiConverter {

   override protected def convertPixel(from: GreyScalePixel): AsciiPixel = {
    table.transformPixel(from)
  }
}
