package models.tables

abstract class TransformationTable () {
//  def this(table: Array[Char]) = {
//    this(table)
//    if(table.length != 256) {
//      ???
//    }
//  }
  protected val table: Array[Char] = createTable
  protected def createTable : Array[Char]
  def transformPixel(gsPixel : Int) : Char = table(gsPixel)

}
