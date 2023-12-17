package asciiArtApp.creators.generators.image

import asciiArtApp.creators.generators.pixel.RandomRgbPixelGenerator
import models.images.RgbImage
import models.pixels.RgbPixel

/**
 * Class for generating a random RGB image
 */
class RandomRgbImageGenerator extends RandomImageGenerator[RgbImage, RgbPixel]{
  override protected val pixelGenerator = new RandomRgbPixelGenerator
  override protected def createImage(pixels: Array[Array[RgbPixel]]): RgbImage = RgbImage(pixels)
}
