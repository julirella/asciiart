package models.tables

import models.pixels.AsciiPixel

class LameTable extends TransformationTable {
//  def this() = {
//    this()
//    table = createTable
//  }

  override protected def createTable: Array[AsciiPixel] = {
    val table = Array[AsciiPixel]()
    for (_ <- 0 to 200) table.appended(AsciiPixel('.'))
    for (_ <- 201 to 255) table.appended(AsciiPixel('.'))
    table
  }
}
