package converters.image

import models.images.{AsciiImage, GreyScaleImage}
import models.pixels.{AsciiPixel, GreyScalePixel}
import models.tables.{LameTable, PaulBourkesTable, UserDefinedTable}
import org.scalatest.FunSuite

class TransformationTableApplierTests extends FunSuite{
  test("lameTable empty list"){
    val applier = new TransformationTableApplier(new LameTable)

    val from = GreyScaleImage(List(
      List()
    ))
    val to = AsciiImage(List(
      List()
    ))
    assert(applier.convert(from) == to)
  }

  test("userDefinedTable normal"){
    val applier = new TransformationTableApplier(UserDefinedTable("1234"))

    val from = GreyScaleImage(List(
      List(GreyScalePixel(50), GreyScalePixel(240))
    ))
    val to = AsciiImage(List(
      List(AsciiPixel('1'), AsciiPixel('4'))
    ))
    assert(applier.convert(from) == to)
  }

  test("paulBourkesTable weird image shape") {
    val applier = new TransformationTableApplier(PaulBourkesTable())

    val from = GreyScaleImage(List(
      List(GreyScalePixel(1), GreyScalePixel(255)),
      List(GreyScalePixel(75))
    ))
    val to = AsciiImage(List(
      List(AsciiPixel(' '), AsciiPixel('@')),
      List(AsciiPixel(':'))
    ))
    assert(applier.convert(from) == to)
  }

}
