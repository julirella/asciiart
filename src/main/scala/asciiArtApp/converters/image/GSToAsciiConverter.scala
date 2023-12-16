package converters.image

import models.images.{AsciiImage, GreyScaleImage}
import helpers.TwoDMapper
import models.pixels.{AsciiPixel, GreyScalePixel}

abstract class GSToAsciiConverter extends ImageConverter[GreyScaleImage, AsciiImage, GreyScalePixel, AsciiPixel] {
  override def convert(from: GreyScaleImage): AsciiImage = {
    AsciiImage(new TwoDMapper().map2D(from.getPixels, convertPixel))
  }
}
