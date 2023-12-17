package asciiArtApp.converters.image

import converters.image.TransformationTableApplier
import helpers.TwoDCompare
import models.images.{AsciiImage, GreyScaleImage}
import models.pixels.{AsciiPixel, GreyScalePixel}
import models.tables.{LameTable, PaulBourkesTable, UserDefinedTable}
import org.scalatest.FunSuite

class TransformationTableApplierTests extends FunSuite{
  val arrCmp = new TwoDCompare

  test("lameTable empty array"){
    val applier = new TransformationTableApplier(new LameTable)

    val from = new GreyScaleImage(Array(
      Array()
    ))
    val to = new AsciiImage(Array(
      Array()
    ))
    val result = applier.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))

  }

  test("userDefinedTable normal"){
    val applier = new TransformationTableApplier(UserDefinedTable("1234"))

    val from = new GreyScaleImage(Array(
      Array(GreyScalePixel(50), GreyScalePixel(240))
    ))
    val to = new AsciiImage(Array(
      Array(AsciiPixel('1'), AsciiPixel('4'))
    ))
    val result = applier.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

  test("paulBourkesTable weird image shape") {
    val applier = new TransformationTableApplier(PaulBourkesTable())

    val from = new GreyScaleImage(Array(
      Array(GreyScalePixel(1), GreyScalePixel(255)),
      Array(GreyScalePixel(75))
    ))
    val to = new AsciiImage(Array(
      Array(AsciiPixel(' '), AsciiPixel('@')),
      Array(AsciiPixel(':'))
    ))
    val result = applier.convert(from)
    assert(arrCmp.cmp2DArray(result.getPixels, to.getPixels))
  }

}
