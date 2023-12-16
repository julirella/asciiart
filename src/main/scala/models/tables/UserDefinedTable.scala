package models.tables

case class UserDefinedTable(chars: String) extends LinearTransformationTable(chars){
  //TODO: maybe this to assert proper linearity
  //  require(chars.length == chars.toSeq.distinct.length)

}
