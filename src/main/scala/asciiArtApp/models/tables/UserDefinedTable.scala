package models.tables

/**
 * A linear transformation table passed in by the user
 * @param chars a string from which the table will  be created
 */
class UserDefinedTable(val chars: String) extends LinearTransformationTable(chars){
}
