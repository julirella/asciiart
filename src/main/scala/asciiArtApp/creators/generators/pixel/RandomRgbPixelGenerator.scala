package asciiArtApp.creators.generators.pixel

import asciiArtApp.models.pixels.RgbPixel

import scala.util.Random

class RandomRgbPixelGenerator extends RandomPixelGenerator[RgbPixel]{
  /**
   * Generate an rgbPixel with random values
   *
   *  @return The generated pixel
   */
  override def create(): RgbPixel = {
    val red = Random.between(0, 255)
    val green = Random.between(0, 255)
    val blue = Random.between(0, 255)
    new RgbPixel(red, green, blue)
  }
}
