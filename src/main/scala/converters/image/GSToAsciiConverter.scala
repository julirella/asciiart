package converters.image

import models.images.{AsciiImage, GreyscaleImage}
import helpers.TwoDMapper

abstract class GSToAsciiConverter extends ImageConverter[GreyscaleImage, AsciiImage, Int, Char] with TwoDMapper[Int, Char] {
  def convertPixel (from: Int): Char

  override def convert(from: GreyscaleImage): AsciiImage = {
    AsciiImage(map2D(from.getPixels, convertPixel))
  }
}
