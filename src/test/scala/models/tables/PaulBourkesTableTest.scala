package models.tables

import models.pixels.{AsciiPixel, GreyScalePixel}
import org.scalatest.FunSuite

class PaulBourkesTableTest extends FunSuite{
  //10 values -> 6*26 + 4*25 = 256
  val table = new PaulBourkesTable
  def transformed(from: Int): Char = table.transformPixel(GreyScalePixel(from)).value
  test("first group start"){
    assert(transformed(0) == ' ')
  }
  test("first group end") {
    assert(transformed(25) == ' ')
  }
  test("second group start") {
    assert(transformed(26) == '.')
  }
  test("sixth group end") {
    assert(transformed(155) == '+')
  }
  test("seventh group start") {
    assert(transformed(156) == '*')
  }
  test("seventh group end") {
    assert(transformed(180) == '*')
  }
  test("eighth group start") {
    assert(transformed(181) == '#')
  }
  test("tenth group middle") {
    assert(transformed(253) == '@')
  }
}
