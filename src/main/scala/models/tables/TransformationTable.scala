package models.tables

import models.pixels.{AsciiPixel, GreyScalePixel}

abstract class TransformationTable () {
//  def this(table: Array[Char]) = {
//    this(table)
//    if(table.length != 256) {
//      ???
//    }
//  }
  protected val table: Array[AsciiPixel] = createTable
  protected def createTable : Array[AsciiPixel]
  def transformPixel(gsPixel : GreyScalePixel) : AsciiPixel = table(gsPixel.value)

}
