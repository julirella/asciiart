package converters.image

import models.images.{AsciiImage, GreyScaleImage}
import helpers.TwoDMapper
import models.pixels.{AsciiPixel, GreyScalePixel}

trait GSToAsciiConverter extends ImageConverter[GreyScaleImage, AsciiImage, GreyScalePixel, AsciiPixel] {
  /**
   * convert greyscale image to ascii image
   *
   * @param from The greyscale image to convert from
   *  @return The created ascii image
   */
  override def convert(from: GreyScaleImage): AsciiImage = {
    new AsciiImage(new TwoDMapper().map2D(from.getPixels, convertPixel))
  }
}
