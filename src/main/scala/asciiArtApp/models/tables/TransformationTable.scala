package models.tables

import models.pixels.{AsciiPixel, GreyScalePixel}

/**
 * A transformation table for ascii art
 */
abstract class TransformationTable {

  /**
   * The table formatted as an array of 256 ascii pixels, each representing the character a greyscale value will map to
   */
  protected val table: Array[AsciiPixel] = createTable

  /**
   * Creates the 256 values of the transformation table
   *
   * @return the created table represented by an array
   */
  protected def createTable : Array[AsciiPixel]

  /**
   * Looks up the character value of a greyscale pixel in the table and transforms it to an ascii pixel
   *
   * @param gsPixel the pixel to be transformed
   * @return the resulting ascii pixel
   */
  def transformPixel(gsPixel : GreyScalePixel) : AsciiPixel = table(gsPixel.value)

}
