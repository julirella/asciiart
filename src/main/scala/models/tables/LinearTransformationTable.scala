package models.tables

abstract class LinearTransformationTable private (private val table : Array[Char], chars: String) extends TransformationTable (table) {
  def this(chars: String) = {
    this(createTable, chars)
  }

  override def createTable: Array[Char] = {
    val charsLen : Int = chars.length
    val groupLen : Int = 256 / charsLen
    var groupsWithExtraOne = 256 % charsLen

    val table = Array[Char]()

    for (i <- 0 until charsLen) {
      for (_ <- 1 to groupLen) {
        table.appended(chars(i))
      }
      if (groupsWithExtraOne > 0) {
        table.appended(chars(i))
        groupsWithExtraOne -= 1
      }
    }
    table
  }
}
