package asciiArtApp.filters.greyScale.oneToOne

import asciiArtApp.models.pixels.GreyScalePixel

/**
 * Filter that changes brightness of a greyscale pixel by amount
 *
 * @param amount the amount by which to change the brightness
 */
class BrightnessFilter(val amount: Int) extends OneToOneFilter {
  /**
   * Change the brightness of a greyscale pixel by amount
    * @param pixel the pixel
   * @return A new pixel with changed brightness
   */
  override protected def applyToOnePixel(pixel: GreyScalePixel): GreyScalePixel = {
    val newPixel = pixel.value + amount
    if(newPixel > 255) GreyScalePixel(255)
    else if(newPixel < 0) GreyScalePixel(0)
    else GreyScalePixel(newPixel)
  }
}
