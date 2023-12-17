package models.tables

import models.pixels.AsciiPixel

abstract class LinearTransformationTable (chars: String) extends TransformationTable {
  /**
   * Equally distributes chars between the 256 greyscale values
   *
   *  @return the created table represented by an array
   */
  override protected def createTable: Array[AsciiPixel] = {
    if(chars.length == 0 || chars.length > 256) throw new IllegalArgumentException("wrong table length")
    val charsLen : Int = chars.length
    val groupLen : Int = 256 / charsLen
    //because 256 is not always divisible by charsLen, some chars will get an extra GS value
    var groupsWithExtraOne = 256 % charsLen

    val table = new Array[AsciiPixel](256)
    var j = 0
    for (i <- 0 until charsLen) {
      for (_ <- 1 to groupLen) {
        table(j) = AsciiPixel(chars(i))
        j += 1
      }
      if (groupsWithExtraOne > 0) {
        table(j) = AsciiPixel(chars(i))
        j += 1
        groupsWithExtraOne -= 1
      }
    }
    table
  }
}
