package asciiArtApp.filters.greyScale.oneToOne

import asciiArtApp.filters.greyScale.GreyscaleFilter
import helpers.TwoDMapper
import asciiArtApp.models.pixels.GreyScalePixel

trait OneToOneFilter extends GreyscaleFilter{
  /**
   * Applies a filter to a greyscale pixel
   *
   * @param pixel The pixel to be filtered
   * @return A new, filtered pixel
   */
  protected def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel

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
