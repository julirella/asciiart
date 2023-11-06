package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter

trait OneToOneFilter extends GreyscaleFilter{
  def applyToOnePixel(pixel: Int): Int

  override def applyFilter(pixels: List[List[Int]]): List[List[Int]] = {
//    https://stackoverflow.com/questions/10049581/mapping-a-function-over-a-multidimensional-array-in-scala
    pixels.map(_.map(p => applyToOnePixel(p)))
  }
}
