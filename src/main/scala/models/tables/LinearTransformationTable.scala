package models.tables

import models.pixels.AsciiPixel

abstract class LinearTransformationTable (chars: String) extends TransformationTable {

  override protected def createTable: Array[AsciiPixel] = {
    val charsLen : Int = chars.length
    val groupLen : Int = 256 / charsLen
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
