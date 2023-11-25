package models.tables

class LameTable private (private val table : Array[Char]) extends TransformationTable (table){
  def this() = {
    this(createTable)
  }

  override def createTable: Array[Char] = {
    val table = Array[Char]()
    for (i <- 0 to 200) table.appended('.')
    for (i <- 201 to 255) table.appended('*')
    table
  }
}
