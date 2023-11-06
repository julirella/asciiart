package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter

case class InversionFilter() extends OneToOneFilter {
  override def applyToOnePixel(pixel: Int): Int = 255 - pixel
}
