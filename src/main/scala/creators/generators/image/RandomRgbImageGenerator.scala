package creators.generators.image

import creators.generators.pixel.RandomRgbPixelGenerator
import models.images.RgbImage
import models.pixels.RgbPixel

class RandomRgbImageGenerator extends RandomImageGenerator[RgbImage, RgbPixel]{
  private val pixelGenerator = new RandomRgbPixelGenerator
  override def createPixel: RgbPixel = pixelGenerator.create()
}
