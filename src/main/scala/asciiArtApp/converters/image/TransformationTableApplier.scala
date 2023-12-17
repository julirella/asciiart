package converters.image
import models.pixels.{AsciiPixel, GreyScalePixel}
import models.tables.TransformationTable

/**
 * Class that uses an ascii transformation table to transform greyscale images to ascii images
 * @param table the transformation table used
 */
class TransformationTableApplier (val table: TransformationTable) extends GSToAsciiConverter {
  /**
   * Convert greyscale pixel to ascii pixel using transformation table
    * @param from the pixel to convert from
   *  @return the new, converted pixel
   */
  override protected def convertPixel(from: GreyScalePixel): AsciiPixel = {
    table.transformPixel(from)
  }
}
