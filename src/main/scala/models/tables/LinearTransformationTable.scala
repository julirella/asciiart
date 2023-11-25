package models.tables

abstract class LinearTransformationTable (chars: String) extends TransformationTable {
//  def this(chars: String) = {
//    this(chars)
//    table = createTable
//  }

  override protected def createTable: Array[Char] = {
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
