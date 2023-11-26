package filters.greyScale.oneToOne

import models.pixels.GreyScalePixel

case class BrightnessFilter(amount: Int) extends OneToOneFilter {
  override def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel = {
    val newPixel = pixel.value + amount
    if(newPixel > 255) GreyScalePixel(255)
    else if(newPixel < 0) GreyScalePixel(0)
    else GreyScalePixel(newPixel)
  }
}
