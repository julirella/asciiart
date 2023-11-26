package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter
import helpers.TwoDMapper
import models.images.GreyScaleImage
import models.pixels.GreyScalePixel

trait OneToOneFilter extends GreyscaleFilter with TwoDMapper[GreyScalePixel, GreyScalePixel]{
  def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel

  override def applyFilter(item: GreyScaleImage): GreyScaleImage = {
    GreyScaleImage(map2D(item.getPixels, applyToOnePixel))
  }
}
