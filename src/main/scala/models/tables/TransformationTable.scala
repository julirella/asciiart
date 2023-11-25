package models.tables

abstract class TransformationTable private (private val table : Array[Char]) {
  def this(table: Array[Char]) = {
    this(table)
    if(table.length != 256) {
      ???
    }
  }
  def createTable : Array[Char]
  def transformPixel(gsPixel : Int) : Char = table(gsPixel)

}
