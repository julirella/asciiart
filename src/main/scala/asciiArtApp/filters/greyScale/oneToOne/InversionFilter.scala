package filters.greyScale.oneToOne

import models.pixels.GreyScalePixel

case class InversionFilter() extends OneToOneFilter {
  override def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel =  GreyScalePixel(255 - pixel.value)
}
