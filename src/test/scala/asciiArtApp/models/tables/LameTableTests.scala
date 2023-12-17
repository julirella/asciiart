package asciiArtApp.models.tables

import asciiArtApp.models.pixels.GreyScalePixel
import org.scalatest.FunSuite

class LameTableTests extends FunSuite{
  val table = new LameTable
   test("dot") {
     assert(table.transformPixel(GreyScalePixel(140)).value == '.')
   }

  test("star") {
    assert(table.transformPixel(GreyScalePixel(240)).value == '*')
  }

  test("edge value") {
    assert(table.transformPixel(GreyScalePixel(201)).value == '*')
  }
}
