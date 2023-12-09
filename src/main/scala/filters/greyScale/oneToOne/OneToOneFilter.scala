package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter
import helpers.TwoDMapper
import models.images.GreyScaleImage
import models.pixels.GreyScalePixel

trait OneToOneFilter extends GreyscaleFilter{
  def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel

  override def applyFilter(item: GreyScaleImage): GreyScaleImage = {
    GreyScaleImage(new TwoDMapper().map2D(item.getPixels, applyToOnePixel))
  }
}
