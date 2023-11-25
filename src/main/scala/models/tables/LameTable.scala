package models.tables

class LameTable extends TransformationTable {
//  def this() = {
//    this()
//    table = createTable
//  }

  override protected def createTable: Array[Char] = {
    val table = Array[Char]()
    for (i <- 0 to 200) table.appended('.')
    for (i <- 201 to 255) table.appended('*')
    table
  }
}
