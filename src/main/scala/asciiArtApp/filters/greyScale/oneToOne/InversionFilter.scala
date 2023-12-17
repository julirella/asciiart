package filters.greyScale.oneToOne

import models.pixels.GreyScalePixel

class InversionFilter() extends OneToOneFilter {
  /**
   * Invert a greyscale pixel, ie subtract its value from 255
   *
   * @param pixel the pixel to be inverted
   * @return A new, inverted pixel
   */
  override def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel =  GreyScalePixel(255 - pixel.value)
}
