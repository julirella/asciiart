package filters.greyScale.oneToOne

import filters.greyScale.GreyscaleFilter
import helpers.TwoDMapper
import models.pixels.GreyScalePixel

trait OneToOneFilter extends GreyscaleFilter{
  /**
   * Applies a filter to a greyscale pixel
   *
   * @param pixel The pixel to be filtered
   * @return A new, filtered pixel
   */
  def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel

  /**
   * Calls the applyToOnePixel method on each greyscale pixel of a 2D array
   *
   * @param item The array to be changed
   *  @return The new, changed array
   */
  override def applyFilter(item: Array[Array[GreyScalePixel]]): Array[Array[GreyScalePixel]] = {
    new TwoDMapper().map2D(item, applyToOnePixel)
  }
}
