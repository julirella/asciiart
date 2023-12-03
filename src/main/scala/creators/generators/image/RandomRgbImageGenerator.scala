package creators.generators.image

import creators.generators.pixel.RandomRgbPixelGenerator
import models.images.RgbImage
import models.pixels.RgbPixel

class RandomRgbImageGenerator extends RandomImageGenerator[RgbImage, RgbPixel]{
  private val pixelGenerator = new RandomRgbPixelGenerator
  override protected def createPixel: RgbPixel = pixelGenerator.create()
  override protected def createArray(height: Int, width: Int): Array[Array[RgbPixel]] = Array.ofDim[RgbPixel](height, width)
  override protected def createImage(list: List[List[RgbPixel]]): RgbImage = RgbImage(list)
}
