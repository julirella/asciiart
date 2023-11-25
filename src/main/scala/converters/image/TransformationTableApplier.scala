package converters.image
import models.images.{AsciiImage, GreyscaleImage}
import models.tables.TransformationTable

class TransformationTableApplier private (table: TransformationTable, val characters : String, val tableLength: Int, val longTable: Vector[Int]) extends GSToAsciiConverter {
  def this(table: TransformationTable) = {
    this(table, table.getChars, table.getChars.length)
  }
  def convertPixel(from: Int): Int = {

  }
  override def convert(from: GreyscaleImage): AsciiImage = {
    val imageGrid = from.getPixels
  }
}
