package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter
import helpers.TwoDMapper
import models.pixels.GreyScalePixel

trait OneToOneFilter extends GreyscaleFilter{
  def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel

  override def applyFilter(item: Array[Array[GreyScalePixel]]): Array[Array[GreyScalePixel]] = {
    new TwoDMapper().map2D(item, applyToOnePixel)
  }
}
