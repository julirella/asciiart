package models.tables

case class UserDefinedTable(chars: String) extends LinearTransformationTable(chars)
//TODO: check chars validity and uniqueness of characters in constructor??
