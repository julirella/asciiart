package models.tables

import models.pixels.AsciiPixel

class LameTable extends TransformationTable() {

  override protected def createTable: Array[AsciiPixel] = {
    val table = new Array[AsciiPixel](256)
    for (i <- 0 to 200) table(i) = AsciiPixel('.')
    for (i <- 201 to 255) table(i) = AsciiPixel('*')
    table
  }
}
